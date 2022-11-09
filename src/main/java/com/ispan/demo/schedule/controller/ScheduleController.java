package com.ispan.demo.schedule.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.schedule.model.Schedule;
import com.ispan.demo.schedule.model.ScheduleDao;
import com.ispan.demo.schedule.service.ScheduleService;

@Controller
public class ScheduleController {
	@Autowired
	private ScheduleService sDao;
	@Autowired
	private ScheduleDao scDao;

	@GetMapping("/getSchedule")
	public String getSchedule() {
		scDao.deleteAll();
		sDao.getbymonth();
		return"index";
	
	}
	
	@GetMapping("/getSchedule1")
	public String getSchedule1() {
		scDao.deleteAll();
		Date date;
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse("2022/04/01");
			List<Schedule> list = sDao.getByDate(date);
			for (Schedule schedule : list) {
				System.out.println(schedule.getPoint());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "index";
	}
	
	@GetMapping("/Schedule")
	public String Schedule() {
		return "Schedule/showSD";
	}
	
//	@GetMapping("/Schedule")
//	public String Schedule1(Model model) {
//		List<Schedule> res = scDao.findByGameDate();
//		model.addAttribute("res", res);
//		
//		return "Schedule/showSD";
//	}
//	
	@ResponseBody
	@GetMapping("/Schedule1")
	public Map<String, List<Schedule>> Schedule1(Model model) {
		HashMap<String, List<Schedule>> map = new HashMap<>();
		List<com.ispan.demo.schedule.model.Schedule> res = sDao.findAllSchedule();
		map.put("data", res);
		return map;
	}
}
