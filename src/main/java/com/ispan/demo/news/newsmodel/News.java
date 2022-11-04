package com.ispan.demo.news.newsmodel;

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
@Table(name = "newstable")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "newsNumber")
	private Integer newsNumber;

	@Column(name = "newsTitle")
	private String newsTitle;

	@Column(name = "newsIndex")
	private String newsIndex;

	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "newsDate")
	private Date newsDate;

	@Column(name = "newsClickCount")
	private Integer newsClickCount;

//	@Column(name="picNumber")
//	private Integer picNumber;

	@Column(name = "picTitle")
	private String picTitle;

//	@Lob
	@Column(name = "picFile")
	private String picFile;

	@Column(name = "shortIndex")
	private String shortIndex;
	
	private String sportType;

	public String getSportType() {
		return sportType;
	}

	public void setSportType(String sportType) {
		this.sportType = sportType;
	}

	public String getShortIndex() {
		return shortIndex;
	}

	public void setShortIndex(String shortIndex) {
		this.shortIndex = shortIndex;
	}

	public Integer getNewsNumber() {
		return newsNumber;
	}

	public void setNewsNumber(Integer newsNumber) {
		this.newsNumber = newsNumber;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsIndex() {
		return newsIndex;
	}

	public void setNewsIndex(String newsIndex) {
		this.newsIndex = newsIndex;
	}

	public Date getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(Date newsDate) {
		this.newsDate = newsDate;
	}

	public Integer getNewsClickCount() {
		return newsClickCount;
	}

	public void setNewsClickCount(Integer newsClickCount) {
		this.newsClickCount = newsClickCount;
	}

	public String getPicTitle() {
		return picTitle;
	}

	public void setPicTitle(String picTitle) {
		this.picTitle = picTitle;
	}

	public String getPicFile() {
		return picFile;
	}

	public void setPicFile(String picFile) {
		this.picFile = picFile;
	}

	public News() {
	}

}
