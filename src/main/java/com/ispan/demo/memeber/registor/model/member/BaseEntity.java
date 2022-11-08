//package com.ispan.demo.memeber.registor.model.member;
//
//import java.io.Serializable;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//
//import org.openqa.selenium.devtools.v101.webaudio.model.AudioListener;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//
////抽象實體類
////@MappedSuperclass
////@EntityListeners(AudioListener.class)
//public class BaseEntity implements Serializable {
//	private static final long serialVersionUID = 1L;
////	@CreatedBy
////	@Column(length = 210, nullable = true)
//	private String createUser;
//
////	@CreatedDate
////	@Column(nullable = true)
//	private Date createDate;
//
////	@LastModifiedBy
////	@Column(length = 20)
//	private String modifiedUser;
//	private Date modifiedTime;
//
////	@LastModifiedBy
//	public String getCreateUser() {
//		return createUser;
//	}
//
//	public void setCreateUser(String createUser) {
//		this.createUser = createUser;
//	}
//
//	public Date getCreateTime() {
//		return createDate;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createDate = createTime;
//	}
//
//	public String getModifiedUser() {
//		return modifiedUser;
//	}
//
//	public void setModifiedUser(String modifiedUser) {
//		this.modifiedUser = modifiedUser;
//	}
//
//	public Date getModifiedTime() {
//		return modifiedTime;
//	}
//
//	public void setModifiedTime(Date modifiedTime) {
//		this.modifiedTime = modifiedTime;
//	}
//
//}
