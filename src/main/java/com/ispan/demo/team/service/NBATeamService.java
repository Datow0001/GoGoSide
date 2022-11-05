package com.ispan.demo.team.service;

import java.util.List;

import com.ispan.demo.team.model.NBATeam;

public interface NBATeamService {

	void getStanding();
	
	void updateStanding();

	List<NBATeam> findByDiv(String string);

	NBATeam findById(Integer id);
}
