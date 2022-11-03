package com.ispan.demo.team.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fielder")
public class Fielder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fielderId")
	private Integer fielderId;
	
	private String fielderName;
	
	private String fielderPos;
	
	private String team;
	
	private Integer gamePlayed;
	
	private Integer ab;
	
	private Integer run;
	
	private Integer hit;
	
	private Integer sbh;
	
	private Integer tbh;
	
	private Integer hr;
	
	private Integer rbi;
	
	public Fielder() {
	}

	public Integer getFielderId() {
		return fielderId;
	}

	public void setFielderId(Integer fielderId) {
		this.fielderId = fielderId;
	}

	public String getFielderName() {
		return fielderName;
	}

	public void setFielderName(String fielderName) {
		this.fielderName = fielderName;
	}

	public String getFielderPos() {
		return fielderPos;
	}

	public void setFielderPos(String fielderPos) {
		this.fielderPos = fielderPos;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Integer getGamePlayed() {
		return gamePlayed;
	}

	public void setGamePlayed(Integer gamePlayed) {
		this.gamePlayed = gamePlayed;
	}

	public Integer getAb() {
		return ab;
	}

	public void setAb(Integer ab) {
		this.ab = ab;
	}

	public Integer getRun() {
		return run;
	}

	public void setRun(Integer run) {
		this.run = run;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public Integer getSbh() {
		return sbh;
	}

	public void setSbh(Integer sbh) {
		this.sbh = sbh;
	}

	public Integer getTbh() {
		return tbh;
	}

	public void setTbh(Integer tbh) {
		this.tbh = tbh;
	}

	public Integer getHr() {
		return hr;
	}

	public void setHr(Integer hr) {
		this.hr = hr;
	}

	public Integer getRbi() {
		return rbi;
	}

	public void setRbi(Integer rbi) {
		this.rbi = rbi;
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

	public Integer getSb() {
		return sb;
	}

	public void setSb(Integer sb) {
		this.sb = sb;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	public Float getAvg() {
		return avg;
	}

	public void setAvg(Float avg) {
		this.avg = avg;
	}

	public Float getObp() {
		return obp;
	}

	public void setObp(Float obp) {
		this.obp = obp;
	}

	public Float getSlg() {
		return slg;
	}

	public void setSlg(Float slg) {
		this.slg = slg;
	}

	public Float getOps() {
		return ops;
	}

	public void setOps(Float ops) {
		this.ops = ops;
	}

	private Integer bb;
	
	private Integer so;
	
	private Integer sb;
	
	private Integer cs;
	
	private Float avg;
	
	private Float obp;
	
	private Float slg;
	
	private Float ops;
	
	
}
