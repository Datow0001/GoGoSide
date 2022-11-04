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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@GetMapping("/Team/getTeam")
	public String getTeam() {
		ts.getTeam();
		return "index";

	}

	@GetMapping("/Team/updateStanding")
	public String updateStanding() {
		ts.update();
		return "index";
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
		model.addAttribute("team", team);
		return "/Teams/teamInfoIndex";
	}
	
	@ResponseBody
	@GetMapping("/Team/teamFInfo")
	public Map<String, List<Fielder>> FielderStat(@RequestParam(name = "num") String num,Model model) {
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
	public Map<String, List<Pitcher>> PitcherStat(@RequestParam(name = "num") String num,Model model) {
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
					"C:\\_SpringBoot\\workspaceA\\MainWorkSpace\\GoGoSide\\src\\main\\resources\\static\\images\\TeamImg\\"
							+ teamName + ".png");
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
