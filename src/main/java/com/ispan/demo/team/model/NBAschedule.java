package com.ispan.demo.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NBAschedule")
public class NBAschedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gameId")
	private Integer gameId;
	
	private String gameDate;
	
	private String gameTime;
	
	private String awayTeam;
	
	private String homeTeam;
	
	private Integer awayScore;
	
	private Integer homeScore;
	
	private String isGameOt;
	
	private String gamePlace;
	
	
	public String getIsGameOt() {
		return isGameOt;
	}

	public void setIsGameOt(String isGameOt) {
		this.isGameOt = isGameOt;
	}


	public NBAschedule() {
		super();
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameDate() {
		return gameDate;
	}

	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}

	public String getGameTime() {
		return gameTime;
	}

	public void setGameTime(String gameTime) {
		this.gameTime = gameTime;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Integer getAwayScore() {
		return awayScore;
	}

	public void setAwayScore(Integer awayScore) {
		this.awayScore = awayScore;
	}

	public Integer getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(Integer homeScore) {
		this.homeScore = homeScore;
	}

	public String getGamePlace() {
		return gamePlace;
	}

	public void setGamePlace(String gamePlace) {
		this.gamePlace = gamePlace;
	}
}
