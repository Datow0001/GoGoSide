package com.ispan.demo.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teamId")
	private Integer teamId;
	
	private String place;
	
	private String name;
	
	private Integer win;
	
	private Integer lose;
	
	private Float percent;
	
	private Float diff;

	private String wcb;
	
	@Lob
	private byte[] teamImage;

	public byte[] getTeamImage() {
		return teamImage;
	}

	public void setTeamImage(byte[] teamImage) {
		this.teamImage = teamImage;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public Integer getLose() {
		return lose;
	}

	public void setLose(Integer lose) {
		this.lose = lose;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	public Float getDiff() {
		return diff;
	}

	public void setDiff(Float diff) {
		this.diff = diff;
	}

	public String getWcb() {
		return wcb;
	}

	public void setWcb(String wcb) {
		this.wcb = wcb;
	}

	public Team(Integer teamId, String place, String name, Integer win, Integer lose, Float percent, Float diff,
			String wcb) {
		super();
		this.teamId = teamId;
		this.place = place;
		this.name = name;
		this.win = win;
		this.lose = lose;
		this.percent = percent;
		this.diff = diff;
		this.wcb = wcb;
	}

	public Team() {
		
	}
	
	
}
