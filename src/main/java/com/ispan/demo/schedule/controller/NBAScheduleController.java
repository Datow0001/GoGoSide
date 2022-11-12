package com.ispan.demo.schedule.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.schedule.model.NBASchedule;
import com.ispan.demo.schedule.model.NBAScheduleDao;
import com.ispan.demo.schedule.service.NBAScheduleService;
import com.ispan.demo.team.model.NBATeam;
import com.ispan.demo.team.service.NBATeamService;




@Controller
public class NBAScheduleController {
	@Autowired
	private NBAScheduleService NBAS;

	@Autowired
	private NBAScheduleDao NBAD;
	@Autowired
	private NBATeamService NBAts;
	
	@GetMapping("/NBAgetSchedule")
	public String NBAgetSchedule() {
		NBAD.deleteAll(); 
		NBAS.getbymonth();
		return"index";
	}
	
	@GetMapping("/getNBASchedule1")
	public String getNBASchedule1() {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse("2022/11/01");
			List<NBASchedule> list = NBAS.getByDate(date);
			for (NBASchedule schedule : list) {
				System.out.println(schedule.getPoint());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@GetMapping("/NBASchedule")
	public String NBASchedule() {
		return "Schedule/showNBA";
	}
	
	@GetMapping("/preNBAsc")
	public String preNBASchedule(Model model) {
		Date date = new Date();		
		
		List<NBASchedule> list = new ArrayList<NBASchedule>();
		try {			
			list = NBAS.getByDate(new SimpleDateFormat ("yyyy-MM-dd").parse((date.getYear()+1900)+"-"+(date.getMonth()+1)+"-"+(date.getDate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<list.size();i++) {
			NBATeam team = new NBATeam();
			NBATeam team2 = new NBATeam();
			team = NBAts.findByName(list.get(i).getNhomeTeam());
			team2 = NBAts.findByName(list.get(i).getNawayTeam());
			list.get(i).setHomeImg(team.getTeamImageSrc());
			list.get(i).setAwayImg(team2.getTeamImageSrc());
			
//			String a=;
//			a=a.replace("pm", "");
//			String[] b =a.split(":");
//			int time= Integer.parseInt(b[0])+1;
//			String end = time+":"+b[1]+"am";
			
			
			
			
		}
		System.out.println(list.size());
		model.addAttribute("list",list);
		return "Schedule/preNBA";
	}
	
	
	@ResponseBody
	@GetMapping("/NBASchedule1")
	public Map<String, List<NBASchedule>> NBASchedule1(Model model) {
		HashMap<String, List<NBASchedule>> map = new HashMap<>();
		List<com.ispan.demo.schedule.model.NBASchedule> res = NBAS.findAllSchedule();
		map.put("data", res);
		return map;
	}
	@ResponseBody
	@GetMapping("/preNBASchedule")
	public Map<String, List<NBASchedule>> NBApreSchedule(Model model) {
		HashMap<String, List<NBASchedule>> map = new HashMap<>();
		Date date = new Date();	
		date.setDate(date.getDate()+1);
		List<com.ispan.demo.schedule.model.NBASchedule> res = NBAS.getByDate(date);
		map.put("data", res);
		return map;
	}
}
