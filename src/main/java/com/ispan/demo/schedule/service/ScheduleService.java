package com.ispan.demo.schedule.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator.IsEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.schedule.model.Schedule;
import com.ispan.demo.schedule.model.ScheduleDao;

@Service
public class ScheduleService {

	@Autowired
	ScheduleDao sDao;
	// https://www.cbssports.com/mlb/schedule/20220915/
	// 從日期找賽程 測試

	public void get(int date) {

//		date = 20220909;
		String url = "https://www.cbssports.com/mlb/schedule/" + date + "/";
		String hometeam = "", awayteam = "", title = "";

		try {
			Document doc = Jsoup.connect(url).get(); // connect to the link
			Elements hometeamele = doc.body().select("span.TeamName a");
			Elements awayteamele = doc.body().select("div.Cellgame a");
			
//	        Elements img=doc.body().select("figure.img img");
//	        Elements detail=doc.body().select("");
			title = doc.title();
			for (Element dat : hometeamele) {
				if (!dat.ownText().equals("")) {
					hometeam += dat.ownText() + ",";
				}
			}
			for (Element ele : awayteamele)
				if (!ele.ownText().equals("")) {
					awayteam += ele.ownText() + ",";
				}

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("fetch words from " + title + ':');

		// System.out.println(hometeam);

		String[] str = hometeam.split(",");
		List<String> home = new ArrayList<>();
		List<String> away = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			if (i % 2 == 0) {
				home.add(str[i]);
			} else {
				away.add(str[i]);
			}
		}
		String[] str2 = awayteam.split(",");

//	        for (String string : str) {
//				System.out.println(string);
//			}
//	        for (String string : str2) {
//				System.out.println(string);
//			}	        

		for (int x = 0; x < str2.length; x++) {
			Schedule sch = new Schedule();
			sch.setPoint(str2[x]);

			if(x<home.size()) {
				sch.setHomeTeam(home.get(x));
				
			}
			if(x<away.size()) {
				sch.setAwayTeam(away.get(x));
			}
			String da = Integer.toString(date);
			Date gameDate;
			try {
				gameDate = new SimpleDateFormat("yyyyMMdd").parse(da);
				SimpleDateFormat newFormat = new SimpleDateFormat("yyyy/MM/dd");
				String formatedDate = newFormat.format(gameDate);
				Date xdate = newFormat.parse(formatedDate);
				sch.setGameDate(xdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(sch.getHomeTeam().isEmpty()) {}
			else {
				sDao.save(sch);
				
			}
		}

//	        for(int i=0;i<str.length;i++) {
//	        	if(i%2==0) {sch.setHometeam(str[i]);}
//	        	else {sch.setAwayteam(str[i]);}
//	        }

//	        int count=0;
//	        for(int i=0;i<str.length;i++) {
//	        	
//	        if(i%2==1) {
//	        System.out.println(str[i]+"      \t"+str2[count]);	        				
//	        count++;
//	        }else {
//	        System.out.print(str[i]+" vs ");}
//	        System.out.println(sch.getHometeam()+"\t"+sch.getAwayteam()+"\t"+sch.getPoint());
//	        
//	    }      
	}

	public void getbymonth() {
		for (int i = 20220401; i <= 20220430; i++) {
			get(i);
		}
		for (int i = 20220501; i <= 20220531; i++) {
			get(i);
		}
		for (int i = 20220601; i <= 20220630; i++) {
			get(i);
		}
		for (int i = 20220701; i <= 20220731; i++) {
			get(i);
		}
		for (int i = 20220801; i <= 20220831; i++) {
			get(i);
		}
		for (int i = 20220901; i <= 20220930; i++) {
			get(i);
		}
		for (int i = 20221001; i <= 20221031; i++) {
			get(i);
		}
		for (int i = 20221101; i <= 20221130; i++) {
			get(i);
		}
	}
	
	public List<Schedule> getByDate(Date date){
	return	sDao.findByGameDate(date);
	}
	
	public List<Schedule> findAllSchedule(){
		return sDao.findAllOrderByGameDate();
	}

}
