package com.ispan.demo.news.newsservice.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.news.newsmodel.HighLight;
import com.ispan.demo.news.newsmodel.HighLightDao;
import com.ispan.demo.news.newsservice.HighLightService;

@Service
@Transactional
public class HighLightServiceImpl implements HighLightService {
	@Autowired
	private HighLightDao hlDao;
	
	@Override
	public void getHighLight() {
		System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		 Date date1 = new Date();
		 String date = sdf.format(date1);
	
//		String date="10/23/22"; 
		
		 driver.get("https://www.youtube.com/playlist?list=PLL-lmlkrmJanUePyXyLusrJGzyGRg-Qj3");
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		 
		 List<WebElement> list = driver.findElements(By.partialLinkText(date));		 
		 for(int i=0;i<list.size();i++) {
			String str=list.get(i).getText();
			HighLight hl = new HighLight();
			hl.setTitle(str.substring(0,str.indexOf("|")));
			String href=list.get(i).getAttribute("href");
			hl.setHighLightHref(href.substring(0,href.indexOf("&")));
			boolean exist=false;
			List<HighLight> ex = hlDao.findAll();
			for (HighLight highLight : ex) {
				if(highLight.getTitle().equals(hl.getTitle())) {
					exist=true;
				}
			}
			if(exist==false) {
				hlDao.save(hl);
			}
		}
		 driver.close();

	}
	public List<HighLight> findHL(){
		return hlDao.findTop7ByOrderByHighLightIdDesc();
	}

}
