package com.ispan.demo.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ispan.demo.team.model.Fielder;
import com.ispan.demo.team.service.FielderService;

@Controller
public class FielderController {
@Autowired
	private FielderService fs;

	@GetMapping("/Player/GetFielder")
	public String getFielder() {
		fs.getStat();
		return"index";
	}
	@GetMapping("/fielderstat")
	public String fielderstat() {
		return"Teams/FielderStat";
	}
		
	
	@ResponseBody
	@GetMapping("/FielderStat1")
	public Map<String, List<Fielder>> FielderStat(Model model) {
		HashMap<String, List<Fielder>> map = new HashMap<>();
		List<com.ispan.demo.team.model.Fielder> res = fs.findAll();
		for (Fielder fielder : res) {
			System.out.println(fielder.getFielderName());
			
		}
		map.put("data", res);
		return map;
	}
}
