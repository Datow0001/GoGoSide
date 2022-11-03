package com.ispan.demo.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pitcher")
public class Pitcher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pitcherId")
	private Integer pitcherId;
	
	private String pitcherName;
	
	private String pitcherPos;
	
	private String team;
	
	private Integer win;

	private Integer lose;
	
	private Float era;
	
	private Integer game;
	
	private Integer gameStart;
	
	private Integer cg;
	
	private Integer sho;
	
	private Integer sv;
	
	private Integer svo;
	
	private Float ip;
	
	private Integer hit;
	
	private Integer run;
	
	private Integer er;
	
	private Integer hr;
	
	private Integer hb;
	
	private Integer bb;
	
	private Integer so;
	
	private Float whip;
	
	public Pitcher() {
	}

	private Float avg;

	public Integer getPitcherId() {
		return pitcherId;
	}

	public void setPitcherId(Integer pitcherId) {
		this.pitcherId = pitcherId;
	}

	public String getPitcherName() {
		return pitcherName;
	}

	public void setPitcherName(String pitcherName) {
		this.pitcherName = pitcherName;
	}

	public String getPitcherPos() {
		return pitcherPos;
	}

	public void setPitcherPos(String pitcherPos) {
		this.pitcherPos = pitcherPos;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
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

	public Float getEra() {
		return era;
	}

	public void setEra(Float era) {
		this.era = era;
	}

	public Integer getGame() {
		return game;
	}

	public void setGame(Integer game) {
		this.game = game;
	}

	public Integer getGameStart() {
		return gameStart;
	}

	public void setGameStart(Integer gameStart) {
		this.gameStart = gameStart;
	}

	public Integer getCg() {
		return cg;
	}

	public void setCg(Integer cg) {
		this.cg = cg;
	}

	public Integer getSho() {
		return sho;
	}

	public void setSho(Integer sho) {
		this.sho = sho;
	}

	public Integer getSv() {
		return sv;
	}

	public void setSv(Integer sv) {
		this.sv = sv;
	}

	public Integer getSvo() {
		return svo;
	}

	public void setSvo(Integer svo) {
		this.svo = svo;
	}

	public Float getIp() {
		return ip;
	}

	public void setIp(Float ip) {
		this.ip = ip;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public Integer getRun() {
		return run;
	}

	public void setRun(Integer run) {
		this.run = run;
	}

	public Integer getEr() {
		return er;
	}

	public void setEr(Integer er) {
		this.er = er;
	}

	public Integer getHr() {
		return hr;
	}

	public void setHr(Integer hr) {
		this.hr = hr;
	}

	public Integer getHb() {
		return hb;
	}

	public void setHb(Integer hb) {
		this.hb = hb;
	}

	public Integer getBb() {
		return bb;
	}

	public void setBb(Integer bb) {
		this.bb = bb;
	}

	public Integer getSo() {
		return so;
	}

	public void setSo(Integer so) {
		this.so = so;
	}

	public Float getWhip() {
		return whip;
	}

	public void setWhip(Float whip) {
		this.whip = whip;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}
}
