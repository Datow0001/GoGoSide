package com.ispan.demo.schedule.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.ispan.demo.schedule.service.NBAScheduleService;




@Controller
public class NBAScheduleController {
	@Autowired
	private NBAScheduleService NBAS;

	@GetMapping("/NBAgetSchedule")
	public String NBAgetSchedule() {
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
	
	
	@ResponseBody
	@GetMapping("/NBASchedule1")
	public Map<String, List<NBASchedule>> NBASchedule1(Model model) {
		HashMap<String, List<NBASchedule>> map = new HashMap<>();
		List<com.ispan.demo.schedule.model.NBASchedule> res = NBAS.findAllSchedule();
		map.put("data", res);
		return map;
	}
}
