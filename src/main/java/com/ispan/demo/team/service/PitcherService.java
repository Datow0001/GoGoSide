package com.ispan.demo.team.service;

import java.util.List;

import com.ispan.demo.team.model.Pitcher;

public interface PitcherService {

	void getStat();
	
	List<Pitcher> findAll();
	
}
