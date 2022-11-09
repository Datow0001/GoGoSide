package com.ispan.demo.score.model;

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
@Table(name="ScoreTable")
public class MLBScore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="scoreId")
	private Integer scoreid;
	
	@Column(name="gameID")
	private String gameid;

	@Column(name="TeamNameA")
	private String TeamNameA;
	
	@Column(name="TeamNameB")
	private String TeamNameB;
	
	@Column(name="RecordA")
	private String RecordA;
	
	@Column(name="RecordB")
	private String RecordB;
	
	@Column(name="RunA")
	private String RunA;
	
	@Column(name="RunB")
	private String RunB;
	
	@Column(name="HitA")
	private String HitA;
	
	@Column(name="HitB")
	private String HitB;
	
	@Column(name="ErrA")
	private String ErrA;
	
	@Column(name="ErrB")
	private String ErrB;
	
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="gameData")
	private Date gameDate;

	

	public Integer getScoreid() {
		return scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public String getTeamNameA() {
		return TeamNameA;
	}

	public void setTeamNameA(String teamNameA) {
		TeamNameA = teamNameA;
	}

	public String getTeamNameB() {
		return TeamNameB;
	}

	public void setTeamNameB(String teamNameB) {
		TeamNameB = teamNameB;
	}

	public String getRecordA() {
		return RecordA;
	}

	public void setRecordA(String recordA) {
		RecordA = recordA;
	}

	public String getRecordB() {
		return RecordB;
	}

	public void setRecordB(String recordB) {
		RecordB = recordB;
	}

	public String getRunA() {
		return RunA;
	}

	public void setRunA(String runA) {
		RunA = runA;
	}

	public String getRunB() {
		return RunB;
	}

	public void setRunB(String runB) {
		RunB = runB;
	}

	public String getHitA() {
		return HitA;
	}

	public void setHitA(String hitA) {
		HitA = hitA;
	}

	public String getHitB() {
		return HitB;
	}

	public void setHitB(String hitB) {
		HitB = hitB;
	}

	public String getErrA() {
		return ErrA;
	}

	public void setErrA(String errA) {
		ErrA = errA;
	}

	public String getErrB() {
		return ErrB;
	}

	public void setErrB(String errB) {
		ErrB = errB;
	}

	public Date getGameDate() {
		return gameDate;
	}

	public void setGameDate(Date gameDate) {
		this.gameDate = gameDate;
	}

	public String getGameid() {
		return gameid;
	}

	public void setGameid(String gameid) {
		this.gameid = gameid;
	}
	
	
	
}

