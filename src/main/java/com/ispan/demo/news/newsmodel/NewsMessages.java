package com.ispan.demo.news.newsmodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "newsmessage")
public class NewsMessages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postNumber")
	private Integer postNumber;

	@Column(name = "userId")
	private String userId;

	@Column(name = "newsNumber")
	private Integer newsNumber;

	@Column(name = "postIndex")
	private String postIndex;
	@Lob
	@Column(name = "postPhoto")
	private byte[] postPhoto;
		
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEEE", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "postTime")
	private Date postTime;

	@PrePersist
	public void onCreate() {
		if (postTime == null) {
			postTime = new Date();
		}
	}

	public Integer getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(Integer postNumber) {
		this.postNumber = postNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getNewsNumber() {
		return newsNumber;
	}

	public void setNewsNumber(Integer newsNumber) {
		this.newsNumber = newsNumber;
	}

	public String getPostIndex() {
		return postIndex;
	}

	public void setPostIndex(String postIndex) {
		this.postIndex = postIndex;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public NewsMessages() {
	}

	public byte[] getPostPhoto() {
		return postPhoto;
	}

	public void setPostPhoto(byte[] postPhoto) {
		this.postPhoto = postPhoto;
	}

}
