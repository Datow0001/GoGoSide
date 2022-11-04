package com.ispan.demo.team.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FielderDao extends JpaRepository<Fielder, Integer> {
	List<Fielder> findByTeam(String team);
}
