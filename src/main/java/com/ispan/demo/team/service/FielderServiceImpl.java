package com.ispan.demo.team.service;

import java.util.List;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.team.model.Fielder;
import com.ispan.demo.team.model.FielderDao;

@Transactional
@Service
public class FielderServiceImpl implements FielderService {
	@Autowired
	private FielderDao fDao;

	public void getStat() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		for (int i = 1; i <= 32; i++) {
			driver.get("https://www.mlb.com/stats/games/regular-season?page=" + i + "&playerPool=ALL");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> stat = driver.findElements(By.className("number-aY5arzrB"));
			for (int x = 18; x < stat.size(); x++) {
				if (x % 18 == 0) {
					Fielder fielder = new Fielder();
					String a = stat.get(x).getText();
					String aa[] = a.split("\n");
//						System.out.println(aa[1]);
					fielder.setFielderName(aa[1]);
//						System.out.println(aa[2]);
					fielder.setFielderPos(aa[2]);
					for(int y=1;y<18;y++) {
						if(y==1) {
							fielder.setTeam(stat.get(x+y).getText());
						}
						if(y==2) {
							fielder.setGamePlayed(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==3) {
							fielder.setAb(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==4) {
							fielder.setRun(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==5) {
							fielder.setHit(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==6) {
							fielder.setSbh(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==7) {
							fielder.setTbh(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==8) {
							fielder.setHr(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==9) {
							fielder.setRbi(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==10) {
							fielder.setBb(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==11) {
							fielder.setSo(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==12) {
							fielder.setSb(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==13) {
							fielder.setCs(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==14) {
							fielder.setAvg(Float.parseFloat(stat.get(x+y).getText()));
						}
						if(y==15) {
							fielder.setObp(Float.parseFloat(stat.get(x+y).getText()));
						}
						if(y==16) {
							fielder.setSlg(Float.parseFloat(stat.get(x+y).getText()));
						}
						if(y==17) {
							fielder.setOps(Float.parseFloat(stat.get(x+y).getText()));
						}
						fDao.save(fielder); 
					}
				} 
				
				
				

				
			}

		}
		driver.close();

	}

	@Override
	public List<Fielder> findAll() {
		return fDao.findAll();
	}
}
