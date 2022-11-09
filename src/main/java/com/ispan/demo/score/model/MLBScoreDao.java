package com.ispan.demo.score.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MLBScoreDao extends JpaRepository<MLBScore, Integer> {
	
//	@Query("From MLBScore Order by gameDate DESC")
//	List<MLBScore> findScoreByGameDate(Date date);
	
}
