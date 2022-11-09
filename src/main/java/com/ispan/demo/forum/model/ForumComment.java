package com.ispan.demo.forum.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="forum_comments")
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cmmtNo")
	private Integer cmmtNo;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="FK_postNo")
//	private ForumPost postNo;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="FK_userId")
//	private Member userId;
	
	@Column(name="postNo", columnDefinition = "integer")
	private Integer postNo;
	
	@Column(name="userId", columnDefinition = "nvarchar(20) not null")
	private String userId;
	
	@Column(name="cmmtContent", columnDefinition = "nvarchar(200) not null")
	private String cmmtContent;
	
	@Column(name="cmmtLikes", columnDefinition = "integer")
	private Integer cmmtLikes = 0 ;
	
	@Column(name="cmmtDislikes", columnDefinition = "integer")
	private Integer cmmtDislikes = 0 ;
	
	@Column(name="cmmtStatus", columnDefinition = "integer")
	private Integer cmmtStatus = 0 ;
		
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss EEE", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="cmmtTime", columnDefinition="datetime")
	private Date cmmtTime;
	
	@PrePersist
	public void onCreate() {
		if(cmmtTime == null) {
			cmmtTime = new Date();
		}
	}
	
	public ForumComment() {
	}

	public Integer getCmmtNo() {
		return cmmtNo;
	}

	public void setCmmtNo(Integer cmmtNo) {
		this.cmmtNo = cmmtNo;
	}

	public Integer getPostNo() {
		return postNo;
	}

	public void setPostNo(Integer postNo) {
		this.postNo = postNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getCmmtContent() {
        return cmmtContent;
    }

    public void setCmmtContent(String cmmtContent) {
        this.cmmtContent = cmmtContent;
    }

    public Integer getCmmtLikes() {
        return cmmtLikes;
    }

    public void setCmmtLikes(Integer cmmtLikes) {
        this.cmmtLikes = cmmtLikes;
    }

    public Integer getCmmtDislikes() {
        return cmmtDislikes;
    }

    public void setCmmtDislikes(Integer cmmtDislikes) {
        this.cmmtDislikes = cmmtDislikes;
    }

    public Integer getCmmtStatus() {
        return cmmtStatus;
    }

    public void setCmmtStatus(Integer cmmtStatus) {
        this.cmmtStatus = cmmtStatus;
    }

    public Date getCmmtTime() {
        return cmmtTime;
    }

    public void setCmmtTime(Date cmmtTime) {
        this.cmmtTime = cmmtTime;
    }

}