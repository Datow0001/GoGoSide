package com.ispan.demo.score.service;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.demo.score.dto.scoreDto;
import com.ispan.demo.score.model.MLBScore;
import com.ispan.demo.score.model.MLBScoreDao;




@Service
public class ScoreService {

	@Autowired
	private MLBScoreDao sDao;

	// 爬蟲抓取資料
	public void get(String date) {
		// https://www.cbssports.com/mlb/scoreboard/20221102/
		String url = "https://www.cbssports.com/mlb/scoreboard/" + date + "/";
		
		int i=1;
		try {
			Document doc = Jsoup.connect(url).get(); // connect to the link
			Elements scoreCards = doc.body().select(".score-cards .single-score-card.mlb");
			for (Element scoreCard : scoreCards) {
				String gameId= scoreCard.attr("data-abbrev");
				scoreDto sd = new scoreDto();
				sd.setGameId(gameId);
				Elements Team1 = scoreCard.select("tbody tr").eq(0);
				sd.setHomeTeam(Team1.select(".team.team--mlb a").text());
				sd.setHomeR(Team1.select("td").eq(1).text());
				sd.setHomeH(Team1.select("td").eq(2).text());
				sd.setHomeE(Team1.select("td").eq(3).text());
				sd.setHomeRecord(Team1.select(".record").text());

				Elements Team2 = scoreCard.select("tbody tr").eq(1);
				sd.setAwayTeam(Team2.select(".team.team--mlb a").text());
				sd.setAwayR(Team2.select("td").eq(1).text());
				sd.setAwayH(Team2.select("td").eq(2).text());
				sd.setAwayE(Team2.select("td").eq(3).text());
				sd.setAwayRecord(Team2.select(".record").text());
				
				System.out.println("============第"+i+"場===========");
				System.out.println(sd.toString());
				System.out.println("========================");
				
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//				String sDate = sdf.format(date);
//				int gameDate=Integer.parseInt(sDate);
				
				MLBScore ms=new MLBScore();
//				ms.setGameDate();
				ms.setGameid(sd.getGameId());
				ms.setTeamNameA(sd.getHomeTeam());
				ms.setTeamNameB(sd.getAwayTeam());
				ms.setRunA(sd.getHomeR());
				ms.setRunB(sd.getAwayR());
				ms.setHitA(sd.getHomeH());
				ms.setHitB(sd.getAwayH());
				ms.setErrA(sd.getHomeE());
				ms.setErrB(sd.getAwayE());
				ms.setRecordA(sd.getHomeRecord());
				ms.setRecordB(sd.getAwayRecord());
				
				sDao.save(ms);
				System.out.println("儲存第"+i+"場比賽資訊進資料庫");
				
				i++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("fetch words from " + title + ':');

	}

	// 儲存資料庫
	public void insert(MLBScore mlbScore) {
//		sDao.save(mlbScore);
	}
	
	public List<MLBScore> findAllData(){
		return sDao.findAll();
	} 
	
	
//	public List<MLBScore> getScoreByDate(Date date){
//	return	sDao.findScoreByGameDate(date);
//	}
	
	
}
