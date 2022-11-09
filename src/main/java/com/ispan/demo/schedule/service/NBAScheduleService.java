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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.schedule.model.NBASchedule;
import com.ispan.demo.schedule.model.NBAScheduleDao;

@Service
public class NBAScheduleService {

	@Autowired
	NBAScheduleDao sDao;
	// https://www.cbssports.com/mlb/schedule/20220915/
	// 從日期找賽程 測試

	public void get(int date) {
//		https://www.cbssports.com/nba/schedule/20221101/
//		date = 20220909;
		String url = "https://www.cbssports.com/nba/schedule/" + date + "/";
		String hometeam = "", awayteam = "", title = "";

		try {
			Document doc = Jsoup.connect(url).get(); // connect to the link
			Elements hometeamele = doc.body().select("span.TeamName a");
			Elements awayteamele = doc.body().select("div.Cellgame a");
//	        Elements img=doc.body().select("figure.img img");
//	            Elements detail=doc.body().select("");
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
			NBASchedule sch = new NBASchedule();
			sch.setPoint(str2[x]);
			sch.setNhomeTeam(home.get(x));
			sch.setNawayTeam(away.get(x));
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
			sDao.save(sch);
		}
    
	}

	public void getbymonth() {
		for (int i = 20221109; i <= 20221123; i++) {
			get(i);
		}
	}
	
	public List<NBASchedule> getByDate(Date date){
	return	sDao.findByGameDate(date);
	}
	
	public List<NBASchedule> findAllSchedule(){
		return sDao.findAllOrderByGameDate();
	}

}
