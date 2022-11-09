package com.ispan.demo.schedule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="schedule")
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="scheduleId")
	private Integer id;
	
	@Column(name="homeTeam")
	private String homeTeam;
	
	@Column(name="awayTeam")
	private String awayTeam;
	
	@JsonFormat(pattern = "yyyy/MM/dd  EEEE", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd ")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="gameData")
	private Date gameDate;
	
	@Column(name="point")
	private String point;
	
	public Schedule() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}

	public String getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	

	
	
	

}
