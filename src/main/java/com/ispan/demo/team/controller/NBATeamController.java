package com.ispan.demo.team.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.team.model.NBAPlayer;
import com.ispan.demo.team.model.NBATeam;
import com.ispan.demo.team.service.NBAPlayerService;
import com.ispan.demo.team.service.NBATeamService;

@Controller
public class NBATeamController {
	@Autowired
	private NBATeamService NBAts;
	
	@Autowired
	private NBAPlayerService NBAps;
	
	@GetMapping("/Team/getNBAteam")
	public String getNBATeam() {
		NBAts.getStanding();
		return"index";
	}
	@GetMapping("/Team/updateNBAteam")
	public String updateNBATeam() {
		NBAts.updateStanding();
		return"index";
	}
	
	@GetMapping("/Team/NBAstand")
	public String findTeams(Model model) {
		List<NBATeam> east = NBAts.findByDiv("EAST");
		List<NBATeam> west = NBAts.findByDiv("WEST");
		List<List> list = new ArrayList<List>();
		list.add(east);
		list.add(west);
		model.addAttribute("list", list);
		return"Teams/NBAStanding";
	}
	@GetMapping("/Team/NBATeamInfo")
	public String findTeamsInfo(Model model) {
		List<NBATeam> east = NBAts.findByDiv("EAST");
		List<NBATeam> west = NBAts.findByDiv("WEST");
		List<List> list = new ArrayList<List>();
		list.add(east);
		list.add(west);
		model.addAttribute("list", list);
		return"Teams/TeamInfoNBA";
	}
	@GetMapping("/Team/showNBATeamInfo")
	public String showTeamInfo(@RequestParam(name = "name") String name, Model model) {
		NBATeam team = NBAts.findByName(name);
		model.addAttribute("team", team);
		return "/Teams/teamInfoIndexNBA";
	}
	@ResponseBody
	@GetMapping("/NBAPlayerStatInINfo")
	public Map<String, List<NBAPlayer>> showTeamInfoPlayer(@RequestParam(name = "name") String name,Model model) {
		HashMap<String, List<NBAPlayer>> map = new HashMap<>();
		String n=null;
		System.out.println(name);
		if(name.equals("Milwaukee")) {n="MIL";}
		if(name.equals("Cleveland")) {n="CLE";}
		if(name.equals("Boston")) {n="BOS";}
		if(name.equals("Atlanta")) {n="ATL";}
		if(name.equals("Toronto")) {n="TOR";}
		if(name.equals("New York")) {n="NYK";}
		if(name.equals("Chicago")) {n="CHI";}
		if(name.equals("Indiana")) {n="IND";}
		if(name.equals("Washington")) {n="WAS";}
		if(name.equals("Philadelphia")) {n="PHI";}
		if(name.equals("Miami")) {n="MIA";}
		if(name.equals("Brooklyn")) {n="BRK";}
		if(name.equals("Charlotte")) {n="CHO";}
		if(name.equals("Orlando")) {n="ORL";}
		if(name.equals("Detroit")) {n="DET";}
		if(name.equals("Portland")) {n="POR";}
		if(name.equals("Phoenix")) {n="PHO";}
		if(name.equals("Utah")) {n="UTA";}
		if(name.equals("Memphis")) {n="MEM";}
		if(name.equals("New Orleans")) {n="NOP";}
		if(name.equals("Denver")) {n="DEN";}
		if(name.equals("Dallas")) {n="DAL";}
		if(name.equals("L.A. Clippers")) {n="LAC";}
		if(name.equals("San Antonio")) {n="SAS";}
		if(name.equals("Oklahoma City")) {n="OKC";}
		if(name.equals("Minnesota")) {n="MIN";}
		if(name.equals("Golden St.")) {n="GSW";}
		if(name.equals("Sacramento")) {n="SAC";}
		if(name.equals("L.A. Lakers")) {n="LAL";}
		if(name.equals("Houston")) {n="HOU";}

		List<com.ispan.demo.team.model.NBAPlayer> res = NBAps.findByTeamName(n);
		map.put("data", res);
		return map;
	}
	
	
	

}
