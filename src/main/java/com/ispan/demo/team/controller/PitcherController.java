package com.ispan.demo.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.team.model.Pitcher;
import com.ispan.demo.team.service.PitcherService;

@Controller
public class PitcherController {
	@Autowired
	private PitcherService ps;
	
	@GetMapping("/Player/GetPitcher")
	public String getPitcher() {
		ps.getStat();
		return"index";
	}
	@GetMapping("/Pitcherstat")
	public String Pitcherstat() {
		return"Teams/PitcherStat";
	}
	@ResponseBody
	@GetMapping("/PitcherStat1")
	public Map<String, List<Pitcher>> FielderStat(Model model) {
		HashMap<String, List<Pitcher>> map = new HashMap<>();
		List<com.ispan.demo.team.model.Pitcher> res = ps.findAll();
		map.put("data", res);
		return map;
	}
}
