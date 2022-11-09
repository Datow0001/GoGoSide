package com.ispan.demo.score.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.score.model.MLBScore;

import com.ispan.demo.score.service.ScoreService;

@Controller
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping("/Score2/{month}")
	public void getScoreMonth(@PathVariable String month) {
		
		for(int i=1;i<=31;i++) {
			String monthStr="";
			if(i<10) {
				monthStr="0"+i;
			}else {
				monthStr=""+ i;
			}
			System.out.println(month+monthStr);
			scoreService.get(month+monthStr);
			
		}
	}	
	
	
	@GetMapping("/Score1")
	public void getScoreOneDay() {
//		scoreDao.get("20221022");
	}
	
	@GetMapping("/WatchScore")
	public String watchScore() {
		return "MLBscore/ShowScore";
	}
	
	//從資料庫撈資料裝成Map送出
	@GetMapping("/ShowAllScore")
	@ResponseBody
	public Map<String, List<MLBScore>> MLBAllData() {
		List<MLBScore> res = scoreService.findAllData();
		HashMap<String, List<MLBScore> >map = new HashMap<>();
		map.put("data", res);
		return map;
	}
//	@GetMapping("/Score/{date}")
//	public void getScore2(@PathVariable String date) {
//		
//		System.out.println(date);
//		System.out.println("------------------");
//		scoreDao.get(date);
//	}
}
