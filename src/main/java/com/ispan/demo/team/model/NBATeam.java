package com.ispan.demo.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "NBAteam")
public class NBATeam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "teamId")
	private Integer teamId;
	
	private String teamName;
	
	private String teamDiv;
	
	private Integer win;
	
	private Integer Lose;
	
	private Float percent;
	
	private Float gb;
	
	private Float ppg;
	
	private Float oppg;
	
	private Float diff;
	
	private String home;
	
	private String road;
	
	private String strk;
	
	private String lastTen;
	
	@Lob
	private byte[] teamImage;
	
	private String teamImageSrc;

	public NBATeam() {
	
	}
	public String getTeamDiv() {
		return teamDiv;
	}
	
	public void setTeamDiv(String teamDiv) {
		this.teamDiv = teamDiv;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getWin() {
		return win;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public Integer getLose() {
		return Lose;
	}

	public void setLose(Integer lose) {
		Lose = lose;
	}

	public Float getPercent() {
		return percent;
	}

	public void setPercent(Float percent) {
		this.percent = percent;
	}

	public Float getGb() {
		return gb;
	}

	public void setGb(Float gb) {
		this.gb = gb;
	}

	public Float getPpg() {
		return ppg;
	}

	public void setPpg(Float ppg) {
		this.ppg = ppg;
	}

	public Float getOppg() {
		return oppg;
	}

	public void setOppg(Float oppg) {
		this.oppg = oppg;
	}

	public Float getDiff() {
		return diff;
	}

	public void setDiff(Float diff) {
		this.diff = diff;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getStrk() {
		return strk;
	}

	public void setStrk(String strk) {
		this.strk = strk;
	}

	public String getLastTen() {
		return lastTen;
	}

	public void setLastTen(String lastTen) {
		this.lastTen = lastTen;
	}

	public byte[] getTeamImage() {
		return teamImage;
	}

	public void setTeamImage(byte[] teamImage) {
		this.teamImage = teamImage;
	}
	public String getTeamImageSrc() {
		return teamImageSrc;
	}
	public void setTeamImageSrc(String teamImageSrc) {
		this.teamImageSrc = teamImageSrc;
	}
	
	
}
