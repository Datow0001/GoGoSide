package com.ispan.demo.team.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NBATeamDao extends JpaRepository<NBATeam, Integer> {

	List<NBATeam> findByTeamDiv(String string);
	
	NBATeam findByTeamName(String name);
	
}
