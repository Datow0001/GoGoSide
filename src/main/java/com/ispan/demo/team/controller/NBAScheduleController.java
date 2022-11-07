package com.ispan.demo.team.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.demo.team.service.NBAScheduleService;

@Controller
public class NBAScheduleController {
	@Autowired
	private NBAScheduleService ss;
	@GetMapping("/Team/getNBAsch")
	public String getNBAsch() {
		ss.getSchedule();
		return"redirect:/";
	}
}
