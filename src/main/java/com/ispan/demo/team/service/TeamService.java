package com.ispan.demo.team.service;

import java.util.List;

import com.ispan.demo.team.model.Team;

public interface TeamService {

	void getTeam();
	
	void update();
	
	List<Team> findTeams(String place);
	
	List<Team> finAll();
	
	Team insert(Team t);
	
	Team findById(Integer id);
}
