package com.ispan.demo.team.service;

import java.util.List;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.team.model.NBAschedule;
import com.ispan.demo.team.model.NBAscheduleDao;

@Transactional
@Service
public class NBAScheduleServiceImpl implements NBAScheduleService {
	@Autowired
	private NBAscheduleDao NBAsch;

	public void getSchedule() {
		NBAsch.deleteAll();
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] month= {"october","november","december","january","february","march","april"};
//november october december january february march april
		for (String string : month) {
			String url ="https://www.basketball-reference.com/leagues/NBA_2023_games-"+string+".html";
		driver.get(url);
		List<WebElement> head = driver.findElements(By.cssSelector("th.left"));
		List<WebElement> all = driver.findElements(By.cssSelector(".table_container.is_setup tr td"));
		for (int i = 0; i < head.size(); i++) {
			NBAschedule sch = new NBAschedule();
			sch.setGameDate(head.get(i).getText());
			for (int x = (i * 10); x < (i * 10) + 10; x++) {
				if (x % 10 == 5 || x % 10 == 7 || x % 10 == 9) {} 
				else {
					if(x%10==0) {
						String a=all.get(x).getText().replace("p", "");
						String[] b=a.split(":");
						Integer c = Integer.parseInt(b[0])+1;
						b[0]=c.toString();
						sch.setGameTime(b[0]+":"+b[1]+"am");}
					if(x%10==1) {
						sch.setAwayTeam(all.get(x).getText());
					}
					if(x%10==2) {
						if(all.get(x).getText().equals("")) {sch.setAwayScore(null);}
						else {
							sch.setAwayScore(Integer.parseInt(all.get(x).getText()));
						}
					}
					if(x%10==3) {
						sch.setHomeTeam(all.get(x).getText());
					}
					if(x%10==4) {
						if(all.get(x).getText().equals("")) {sch.setHomeScore(null);}
						else {
							sch.setHomeScore(Integer.parseInt(all.get(x).getText()));
						}
					}
					if(x%10==6) {
						sch.setIsGameOt(all.get(x).getText());
					}
					if(x%10==8) {
						sch.setGamePlace(all.get(x).getText());
					}
				}
			}
			NBAsch.save(sch);
		}
		}
		driver.close();
	}
}
