package com.ispan.demo.team.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.news.newsmodel.News;
import com.ispan.demo.news.newsservice.NewsService;
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
	@Autowired
	private NewsService ns;
	@GetMapping("/Team/getNBAteam")
	public String getNBATeam() {
		NBAts.getStanding();
		return"redirect:/";
	}
	@GetMapping("/Team/updateNBAteam")
	public String updateNBATeam() {
		NBAts.updateStanding();
		return"redirect:/";
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
		String n=null;
		String fullname=null;
		if(name.equals("Milwaukee")) {n="公鹿";fullname="密爾瓦基公鹿";}
		if(name.equals("Cleveland")) {n="騎士";fullname="克里夫蘭騎士";}
		if(name.equals("Boston")) {n="賽爾提克";fullname="波士頓賽爾提克";}
		if(name.equals("Atlanta")) {n="老鷹";fullname="亞特蘭大老鷹";}
		if(name.equals("Toronto")) {n="暴龍";fullname="多倫多暴龍";}
		if(name.equals("New York")) {n="尼克";fullname="紐約尼克";}
		if(name.equals("Chicago")) {n="公牛";fullname="芝加哥公牛";}
		if(name.equals("Indiana")) {n="溜馬";fullname="印第安那溜馬";}
		if(name.equals("Washington")) {n="巫師";fullname="華盛頓巫師";}
		if(name.equals("Philadelphia")) {n="七六人";fullname="費城七六人";}
		if(name.equals("Miami")) {n="熱火";fullname="邁阿密熱火";}
		if(name.equals("Brooklyn")) {n="籃網";fullname="布魯克林籃網";}
		if(name.equals("Charlotte")) {n="黃蜂";fullname="夏洛特黃蜂";}
		if(name.equals("Orlando")) {n="魔術";fullname="奧蘭多魔術";}
		if(name.equals("Detroit")) {n="活塞";fullname="底特律活塞";}
		if(name.equals("Portland")) {n="拓荒者";fullname="波特蘭拓荒者";}
		if(name.equals("Phoenix")) {n="太陽";fullname="鳳凰城太陽";}
		if(name.equals("Utah")) {n="爵士";fullname="猶他爵士";}
		if(name.equals("Memphis")) {n="灰熊";fullname="孟菲斯灰熊";}
		if(name.equals("New Orleans")) {n="鵜鶘";fullname="紐奧良鵜鶘";}
		if(name.equals("Denver")) {n="金塊";fullname="丹佛金塊";}
		if(name.equals("Dallas")) {n="獨行俠";fullname="達拉斯獨行俠";}
		if(name.equals("L.A. Clippers")) {n="快艇";fullname="洛杉磯快艇";}
		if(name.equals("San Antonio")) {n="馬刺";fullname="聖安東尼奧馬刺";}
		if(name.equals("Oklahoma City")) {n="雷霆";fullname="奧克拉荷馬雷霆";}
		if(name.equals("Minnesota")) {n="灰狼";fullname="明尼蘇達灰狼";}
		if(name.equals("Golden St.")) {n="勇士";fullname="金州勇士";}
		if(name.equals("Sacramento")) {n="國王";fullname="沙加緬度國王";}
		if(name.equals("L.A. Lakers")) {n="湖人";fullname="洛杉磯湖人";}
		if(name.equals("Houston")) {n="火箭";fullname="休士頓火箭";}
		Page<News> page = ns.findByNewsIndex(n, 1);
		model.addAttribute("team", team);
		model.addAttribute("page",page);
		model.addAttribute("fullname",fullname);
		
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
