package com.ispan.demo.team.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ispan.demo.news.newsmodel.News;
import com.ispan.demo.news.newsservice.NewsService;
import com.ispan.demo.team.model.Fielder;
import com.ispan.demo.team.model.Pitcher;
import com.ispan.demo.team.model.Team;
import com.ispan.demo.team.service.FielderService;
import com.ispan.demo.team.service.PitcherService;
import com.ispan.demo.team.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService ts;
	@Autowired
	private PitcherService ps;
	@Autowired
	private FielderService fs;
	@Autowired
	private NewsService ns;

	@GetMapping("/Team/getTeam")
	public String getTeam() {
		ts.getTeam();
		return "redirect:/";

	}

	@GetMapping("/Team/updateStanding")
	public String updateStanding() {
		ts.update();
		return "redirect:/";
	}

	@GetMapping("/Team/teamInfo")
	public String teamInfo(Model model) {
		List<Team> nlEast = ts.findTeams("NL East");
		List<Team> nlCentral = ts.findTeams("NL Central");
		List<Team> nlWest = ts.findTeams("NL West");
		List<Team> alEast = ts.findTeams("AL East");
		List<Team> alCentral = ts.findTeams("AL Central");
		List<Team> alWest = ts.findTeams("AL West");

		List<List> list = new ArrayList<List>();
		list.add(alEast);
		list.add(alCentral);
		list.add(alWest);
		list.add(nlEast);
		list.add(nlCentral);
		list.add(nlWest);
		model.addAttribute("list", list);
		return "/Teams/TeamInfo";
	}

	@GetMapping("/Team/showTeamInfo")
	public String showTeamInfo(@RequestParam(name = "id") Integer id, Model model) {
		Team team = ts.findById(id);
		String name=null;
		String fullname=null;
		if(team.getName().equals("NY Yankees")) {name="洋基";fullname="紐約洋基";}
		if(team.getName().equals("Toronto")) {name="藍鳥";fullname="多倫多藍鳥";}
		if(team.getName().equals("Tampa Bay")) {name="光芒";fullname="坦帕灣光芒";}
		if(team.getName().equals("Baltimore")) {name="金鶯";fullname="巴爾的摩金鶯";}
		if(team.getName().equals("Boston")) {name="紅襪";fullname="波士頓紅襪";}
		if(team.getName().equals("Cleveland")) {name="守護者";fullname="克里夫蘭守護者";}
		if(team.getName().equals("Chi White Sox")) {name="白襪";fullname="芝加哥白襪";}
		if(team.getName().equals("Minnesota")) {name="雙城";fullname="明尼蘇達雙城";}
		if(team.getName().equals("Detroit")) {name="老虎";fullname="底特律老虎";}
		if(team.getName().equals("Kansas City")) {name="皇家";fullname="堪薩斯皇家";}
		if(team.getName().equals("Houston")) {name="太空人";fullname="休士頓太空人";}
		if(team.getName().equals("Seattle")) {name="水手";fullname="西雅圖水手";}
		if(team.getName().equals("LA Angels")) {name="天使";fullname="洛杉磯天使";}
		if(team.getName().equals("Texas")) {name="遊騎兵";fullname="德州遊騎兵";}
		if(team.getName().equals("Oakland")) {name="運動家";fullname="奧克蘭運動家";}
		if(team.getName().equals("Atlanta")) {name="勇士";fullname="亞特蘭大勇士";}
		if(team.getName().equals("NY Mets")) {name="大都會";fullname="紐約大都會";}
		if(team.getName().equals("Philadelphia")) {name="費城人";fullname="費城費城人";}
		if(team.getName().equals("Miami")) {name="馬林魚";fullname="邁阿密馬林魚";}
		if(team.getName().equals("Washington")) {name="國民";fullname="華盛頓國民";}
		if(team.getName().equals("St. Louis")) {name="紅雀";fullname="聖路易紅雀";}
		if(team.getName().equals("Milwaukee")) {name="釀酒人";fullname="密爾瓦基釀酒人";}
		if(team.getName().equals("Chi Cubs")) {name="小熊";fullname="芝加哥小熊";}
		if(team.getName().equals("Cincinnati")) {name="紅人";fullname="辛辛那提紅人";}
		if(team.getName().equals("Pittsburgh")) {name="海盜";fullname="匹茲堡海盜";}
		if(team.getName().equals("LA Dodgers")) {name="道奇";fullname="洛杉磯道奇";}
		if(team.getName().equals("San Diego")) {name="教士";fullname="聖地牙哥教士";}
		if(team.getName().equals("San Francisco")) {name="巨人";fullname="舊金山巨人";}
		if(team.getName().equals("Arizona")) {name="響尾蛇";fullname="亞利桑那響尾蛇";}
		if(team.getName().equals("Colorado")) {name="落磯";fullname="科羅拉多落磯";}
//================================================================================================
		
		Page<News> page = ns.findByNewsIndex(name, 1);
		model.addAttribute("team", team);
		model.addAttribute("page",page);
		model.addAttribute("fullname",fullname);
		return "/Teams/teamInfoIndex";
	}

	@ResponseBody
	@GetMapping("/Team/teamFInfo")
	public Map<String, List<Fielder>> FielderStat(@RequestParam(name = "num") String num, Model model) {
		HashMap<String, List<Fielder>> map = new HashMap<>();
		String teamName = null;
		int id = Integer.parseInt(num);
		if (id == 1) {
			teamName = "NYY";
		}
		if (id == 2) {
			teamName = "TOR";
		}
		if (id == 3) {
			teamName = "TB";
		}
		if (id == 4) {
			teamName = "BAL";
		}
		if (id == 5) {
			teamName = "BOS";
		}
		if (id == 6) {
			teamName = "CLE";
		}
		if (id == 7) {
			teamName = "CWS";
		}
		if (id == 8) {
			teamName = "MIN";
		}
		if (id == 9) {
			teamName = "DET";
		}
		if (id == 10) {
			teamName = "KC";
		}
		if (id == 11) {
			teamName = "HOU";
		}
		if (id == 12) {
			teamName = "SEA";
		}
		if (id == 13) {
			teamName = "LAA";
		}
		if (id == 14) {
			teamName = "TEX";
		}
		if (id == 15) {
			teamName = "OAK";
		}
		if (id == 16) {
			teamName = "ATL";
		}
		if (id == 17) {
			teamName = "NYM";
		}
		if (id == 18) {
			teamName = "PHI";
		}
		if (id == 19) {
			teamName = "MIA";
		}
		if (id == 20) {
			teamName = "WSH";
		}
		if (id == 21) {
			teamName = "STL";
		}
		if (id == 22) {
			teamName = "MIL";
		}
		if (id == 23) {
			teamName = "CHC";
		}
		if (id == 24) {
			teamName = "CIN";
		}
		if (id == 25) {
			teamName = "PIT";
		}
		if (id == 26) {
			teamName = "LAD";
		}
		if (id == 27) {
			teamName = "SD";
		}
		if (id == 28) {
			teamName = "SF";
		}
		if (id == 29) {
			teamName = "ARI";
		}
		if (id == 30) {
			teamName = "COL";
		}
		List<com.ispan.demo.team.model.Fielder> res = fs.findByTeam(teamName);
		map.put("data", res);
		return map;
	}

	@ResponseBody
	@GetMapping("/Team/teamPInfo")
	public Map<String, List<Pitcher>> PitcherStat(@RequestParam(name = "num") String num, Model model) {
		HashMap<String, List<Pitcher>> map = new HashMap<>();
		String teamName = null;
		int id = Integer.parseInt(num);
		if (id == 1) {
			teamName = "NYY";
		}
		if (id == 2) {
			teamName = "TOR";
		}
		if (id == 3) {
			teamName = "TB";
		}
		if (id == 4) {
			teamName = "BAL";
		}
		if (id == 5) {
			teamName = "BOS";
		}
		if (id == 6) {
			teamName = "CLE";
		}
		if (id == 7) {
			teamName = "CWS";
		}
		if (id == 8) {
			teamName = "MIN";
		}
		if (id == 9) {
			teamName = "DET";
		}
		if (id == 10) {
			teamName = "KC";
		}
		if (id == 11) {
			teamName = "HOU";
		}
		if (id == 12) {
			teamName = "SEA";
		}
		if (id == 13) {
			teamName = "LAA";
		}
		if (id == 14) {
			teamName = "TEX";
		}
		if (id == 15) {
			teamName = "OAK";
		}
		if (id == 16) {
			teamName = "ATL";
		}
		if (id == 17) {
			teamName = "NYM";
		}
		if (id == 18) {
			teamName = "PHI";
		}
		if (id == 19) {
			teamName = "MIA";
		}
		if (id == 20) {
			teamName = "WSH";
		}
		if (id == 21) {
			teamName = "STL";
		}
		if (id == 22) {
			teamName = "MIL";
		}
		if (id == 23) {
			teamName = "CHC";
		}
		if (id == 24) {
			teamName = "CIN";
		}
		if (id == 25) {
			teamName = "PIT";
		}
		if (id == 26) {
			teamName = "LAD";
		}
		if (id == 27) {
			teamName = "SD";
		}
		if (id == 28) {
			teamName = "SF";
		}
		if (id == 29) {
			teamName = "ARI";
		}
		if (id == 30) {
			teamName = "COL";
		}
		List<com.ispan.demo.team.model.Pitcher> res = ps.findByTeam(teamName);

		map.put("data", res);
		return map;
	}

	@GetMapping("/Team/Standing")
	public String findteams(Model model) {
		List<Team> nlEast = ts.findTeams("NL East");
		List<Team> nlCentral = ts.findTeams("NL Central");
		List<Team> nlWest = ts.findTeams("NL West");
		List<Team> alEast = ts.findTeams("AL East");
		List<Team> alCentral = ts.findTeams("AL Central");
		List<Team> alWest = ts.findTeams("AL West");

		List<List> list = new ArrayList<List>();
		list.add(alEast);
		list.add(alCentral);
		list.add(alWest);
		list.add(nlEast);
		list.add(nlCentral);
		list.add(nlWest);
		model.addAttribute("list", list);
		return "/Teams/Standing";
	}

	@GetMapping("Team/getImg")
	public String getImg() {
		List<Team> list = ts.finAll();
		for (Team team : list) {
			String teamName = team.getName();
			File originalImgFile = new File(
					"C:\\_SpringBoot\\workspace2\\GoGoSide\\src\\main\\resources\\static\\images\\TeamImg\\" + teamName
							+ ".png");
			try {
				BufferedImage bufferedImage = ImageIO.read(originalImgFile);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bufferedImage, "png", baos);
				baos.flush();
				byte[] originalImgByte = baos.toByteArray();
				team.setTeamImage(originalImgByte);
				ts.insert(team);
				baos.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}
		return "index";

	}

	@GetMapping("/showTeamImage/{id}")
	public ResponseEntity<byte[]> showTeamImage(@PathVariable("id") Integer id) {
		Team team = ts.findById(id);
		byte[] file = team.getTeamImage();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);

	}

}
