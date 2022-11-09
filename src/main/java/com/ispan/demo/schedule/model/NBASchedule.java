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
@Table(name="NBAschedule")
public class NBASchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nbascheduleId")
	private Integer nid;
	
	@Column(name="nhomeTeam")
	private String nhomeTeam;
	
	@Column(name="nawayTeam")
	private String nawayTeam;
	
	@JsonFormat(pattern = "yyyyMMdd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyyMMdd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="gameDate")
	private Date gameDate;
	
	@Column(name="point")
	private String point;
	
	@Column(name="img")
	private byte[] img;

	

	public Integer getNid() {
		return nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getNhomeTeam() {
		return nhomeTeam;
	}

	public void setNhomeTeam(String nhomeTeam) {
		this.nhomeTeam = nhomeTeam;
	}

	public String getNawayTeam() {
		return nawayTeam;
	}

	public void setNawayTeam(String nawayTeam) {
		this.nawayTeam = nawayTeam;
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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}
	
	public NBASchedule() {
		
	}
	

}
