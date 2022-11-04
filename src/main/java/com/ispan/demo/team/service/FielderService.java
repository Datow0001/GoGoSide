package com.ispan.demo.team.service;

import java.util.List;

import com.ispan.demo.team.model.Fielder;

public interface FielderService {

	void getStat();
	
	List<Fielder> findAll();
	
	List<Fielder> findByTeam(String team);
	
}
