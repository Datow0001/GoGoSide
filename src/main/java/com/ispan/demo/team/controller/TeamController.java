package com.ispan.demo.team.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

import com.ispan.demo.team.model.Team;
import com.ispan.demo.team.service.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService ts;

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
			String teamName=team.getName();
			File originalImgFile = new File("C:\\_SpringBoot\\workspaceA\\MainWorkSpace\\GoGoSide\\src\\main\\resources\\static\\images\\TeamImg\\"+teamName+".png");
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
			
		}return "index";
		
	}
	
	@GetMapping("/showTeamImage/{id}")
	public ResponseEntity<byte[]> showTeamImage(@PathVariable("id") Integer id){
		Team team = ts.findById(id);
		byte[] file = team.getTeamImage();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		
		return new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);
		
	}
	
}
