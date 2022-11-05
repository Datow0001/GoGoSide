package com.ispan.demo.team.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.demo.team.model.NBATeam;
import com.ispan.demo.team.service.NBATeamService;

@Controller
public class NBATeamController {
	@Autowired
	private NBATeamService NBAts;
	
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
	
	
	
	
//	@GetMapping("/showNBATeamImage/{id}")
//	public ResponseEntity<byte[]> showTeamImage(@PathVariable("id") Integer id) {
//		NBATeam team = NBAts.findById(id);
//		byte[] file = team.getTeamImage();
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_XML);
//
//		return new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);
//
//	}
}
