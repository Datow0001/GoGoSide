package com.ispan.demo.team.service;

import java.util.List;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.team.model.Pitcher;
import com.ispan.demo.team.model.PitcherDao;
@Transactional
@Service
public class PitcherServiceImpl implements PitcherService {
	@Autowired
	private PitcherDao pDao;
	
	
	
	@Override
	public void getStat() {
		pDao.deleteAll();
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.mlb.com/stats/pitching/regular-season?page=1&playerPool=ALL&sortState=asc");
		List<WebElement> but = driver.findElements(By.className("tab-27nhZTIl"));
		int size=Integer.parseInt(but.get(but.size()-1).getText());
		for (int i = 1; i <= size; i++) {
			driver.get("https://www.mlb.com/stats/pitching/regular-season?page="+i+"&playerPool=ALL&sortState=asc");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> stat = driver.findElements(By.className("number-aY5arzrB"));
			for (int x = 21; x < stat.size(); x++) {
				if (x % 21 == 0) {
					Pitcher pitcher = new Pitcher();
					String a = stat.get(x).getText();
					String aa[] = a.split("\n");
//						System.out.println(aa[1]);
					pitcher.setPitcherName(aa[1]);
//						System.out.println(aa[2]);
					pitcher.setPitcherPos(aa[2]);
					for(int y=1;y<21;y++) {
						if(y==1) {
							pitcher.setTeam(stat.get(x+y).getText());
						}
						if(y==2) {
							pitcher.setWin(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==3) {
							pitcher.setLose(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==4) {
							pitcher.setEra(Float.parseFloat(stat.get(x+y).getText()));
						}
						if(y==5) {
							pitcher.setGame(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==6) {
							pitcher.setGameStart(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==7) {
							pitcher.setCg(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==8) {
							pitcher.setSho(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==9) {
							pitcher.setSv(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==10) {
							pitcher.setSvo(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==11) {
							pitcher.setIp(Float.parseFloat(stat.get(x+y).getText()));
						}
						if(y==12) {
							pitcher.setHit(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==13) {
							pitcher.setRun(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==14) {
							pitcher.setEr(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==15) {
							pitcher.setHr(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==16) {
							pitcher.setHb(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==17) {
							pitcher.setBb(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==18) {
							pitcher.setSo(Integer.parseInt(stat.get(x+y).getText()));
						}
						if(y==19) {
							pitcher.setWhip(Float.parseFloat(stat.get(x+y).getText()));
						}
						if(y==20) {
							pitcher.setAvg(Float.parseFloat(stat.get(x+y).getText()));
						}
						
						pDao.save(pitcher); 
					}
				} 
				
				
				

				
			}

		}
		driver.close();
		
	}

	@Override
	public List<Pitcher> findAll() {
		
		return pDao.findAll();
	}

	@Override
	public List<Pitcher> findByTeam(String team) {
		return pDao.findAllByTeam(team);
	}

}
