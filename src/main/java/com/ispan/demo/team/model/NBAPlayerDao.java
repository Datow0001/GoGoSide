package com.ispan.demo.team.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NBAPlayerDao extends JpaRepository<NBAPlayer, Integer> {
List<NBAPlayer> findByTeam(String team);
}
