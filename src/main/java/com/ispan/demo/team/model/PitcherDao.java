package com.ispan.demo.team.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PitcherDao extends JpaRepository<Pitcher, Integer> {
	List<Pitcher> findAllByTeam(String team);
}
