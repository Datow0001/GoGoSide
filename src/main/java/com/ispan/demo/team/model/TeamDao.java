package com.ispan.demo.team.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team, Integer> {
	Team findByName(String name);
	List<Team> findByPlaceOrderByPercentDesc(String place);
}
