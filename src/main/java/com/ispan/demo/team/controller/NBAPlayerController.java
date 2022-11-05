package com.ispan.demo.team.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.team.model.NBAPlayer;
import com.ispan.demo.team.service.NBAPlayerService;

@Controller
public class NBAPlayerController {

	@Autowired
	private NBAPlayerService ps;
	
	@GetMapping("/NBAPlayer/get")
	public String getNBAPlayer() {
		ps.getStat();
		return"index";				
	}
	@GetMapping("/NBAPlayer/Stat")
	public String NBAPlayerStat() {
		return"Teams/NBAPlayerStat";
	}
	@ResponseBody
	@GetMapping("/NBAPlayerStat1")
	public Map<String, List<NBAPlayer>> FielderStat(Model model) {
		HashMap<String, List<NBAPlayer>> map = new HashMap<>();
		List<com.ispan.demo.team.model.NBAPlayer> res = ps.findAll();
		map.put("data", res);
		return map;
	}
}
