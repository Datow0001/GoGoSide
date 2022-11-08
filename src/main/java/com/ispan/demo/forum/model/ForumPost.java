package com.ispan.demo.forum.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ispan.demo.memeber.registor.model.member.Member;

@Entity
@Table(name="forum_posts")
public class ForumPost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="postNo")
	private Integer postNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_userId")
	private Member userId;
	
	@Column(name="teamName", columnDefinition = "nvarchar(50) not null")
	private String teamName;
	
	@Column(name="postArticle", columnDefinition = "nvarchar(50) not null")
	private String postArticle;
	
	@Column(name="postContent", columnDefinition = "nvarchar(3000) not null")
	private String postContent;
	
	@Column(name="postViews", columnDefinition = "integer")
	private Integer postViews = 0 ;
	
	@Column(name="postLikes", columnDefinition = "integer")
	private Integer postLikes = 0 ;
	
	@Column(name="postDislikes", columnDefinition = "integer")
	private Integer postDislikes = 0 ;
	
	@Column(name="postStatus", columnDefinition = "integer")
	private Integer postStatus = 0 ;
		
	@Lob
	@Column(name = "imageFile")
	private byte[] imageFile;	
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEE", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="postTime", columnDefinition="datetime")
	private Date postTime;
	
	@PrePersist
	public void onCreate() {
		if(postTime == null) {
			postTime = new Date();
		}
	}
	
	public ForumPost() {
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public Member getUserId() {
		return userId;
	}

	public void setUserId(Member userId) {
		this.userId = userId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPostArticle() {
		return postArticle;
	}

	public void setPostArticle(String postArticle) {
		this.postArticle = postArticle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Integer getPostViews() {
		return postViews;
	}

	public void setPostViews(Integer postViews) {
		this.postViews = postViews;
	}

	public Integer getPostLikes() {
		return postLikes;
	}

	public void setPostLikes(Integer postLikes) {
		this.postLikes = postLikes;
	}

	public Integer getPostDislikes() {
		return postDislikes;
	}

	public void setPostDislikes(Integer postDislikes) {
		this.postDislikes = postDislikes;
	}

	public Integer getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(Integer postStatus) {
		this.postStatus = postStatus;
	}

	public byte[] getImageFile() {
		return imageFile;
	}

	public void setImageFile(byte[] imageFile) {
		this.imageFile = imageFile;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

}