package com.ispan.demo.memeber.registor.model.member;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Member")
public class Member implements Serializable {
//	宣告序列化，讓輸入輸出沒有問題（輸出轉位元，輸入轉java物件）
    public static final long serialVersionUID = 1L;
    // 註冊基本資料
    @Id
//	@Column(columnDefinition = "not null")
    @NotBlank(message = "帳號不可為空")
    @Length(min = 6, message = "帳號長度不可<6")
    private String userId; // 會員帳號

//	@Column(columnDefinition = "not null")
    @NotBlank(message = "姓名不可為空")
    @Pattern(regexp = "^[\u4E00-\u9FA5_]+$", message = "請輸入中文姓名")
    private String userName; // 會員姓名

//	@Column(columnDefinition = "not null",unique = true)
    @NotBlank(message = "暱稱不可為空")
    private String nickName; // 會員暱稱

//	@Column(columnDefinition = "not null")
    @NotBlank(message = "密碼不可為空")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{6,16}$", message = "密碼必須為長度6~16位碼大小寫英文加數字")
    private String password; // 密碼

    @Transient // 暫時
    private String passwordAgain; // 再次輸入密碼

//	@Column(columnDefinition = "varchar(10)",unique = true)
    @NotBlank(message = "身分證不可為空")
    @Pattern(regexp = "^[A-Za-z]{1}[1-2]{1}[0-9]{8}$", message = "身份證輸入錯誤")
    private String personId; // 身份證

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "生日不可為空")
    @Past(message = "日期錯誤")
    private Date birthday; // 生日

	@Column(unique = true)
    @Email(message = "信箱格式錯誤")
    @NotBlank(message = "信箱不可為空")
    private String mail; // 電子郵件

	@Column(unique = true)
	@NotBlank(message = "電話不可為空")
	String phone; // 電話號碼

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss SSS", timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss SSS")
    Timestamp registerTime; // 註冊時間
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss SSS", timezone = "GMT-8")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss SSS")
    Timestamp editTime; // 修改會員資料時間

    // 權限設定
//	@ManyToMany
	String roles; // 會員權限

	boolean rememberMe = false;
    // 個人喜好設定
    String photoName; // 頭貼名稱
    @Lob // 跟hibernate說是LargeObject
//    Blob profilo; // 頭貼照片
    private byte[] prfilo;
public byte[] getPrfilo() {
		return prfilo;
	}
	public void setPrfilo(byte[] prfilo) {
		this.prfilo = prfilo;
	}
	//	@ManyToMany
    String preGroup; // 偏好球隊
//	@ManyToMany
    String prGame; // 偏好運動
	public Member(@NotBlank(message = "帳號不可為空") @Length(min = 6, message = "帳號長度不可<6") String userId,
			@NotBlank(message = "姓名不可為空") @Pattern(regexp = "^[一-龥_]+$", message = "請輸入中文姓名") String userName,
			@NotBlank(message = "暱稱不可為空") String nickName,
			@NotBlank(message = "密碼不可為空") @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{6,16}$", message = "密碼必須為長度6~16位碼大小寫英文加數字") String password,
			String passwordAgain,
			@NotBlank(message = "身分證不可為空") @Pattern(regexp = "^[A-Za-z]{1}[1-2]{1}[0-9]{8}$", message = "身份證輸入錯誤") String personId,
			@NotNull(message = "生日不可為空") @Past(message = "日期錯誤") Date birthday,
			@Email(message = "信箱格式錯誤") @NotBlank(message = "信箱不可為空") String mail,
			@NotNull(message = "電話不可為空") @NotBlank(message = "電話不可為空") String phone, Timestamp registerTime, Timestamp editTime, String roles,
			boolean rememberMe, String photoName, Blob profilo, String preGroup, String prGame) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.personId = personId;
		this.birthday = birthday;
		this.mail = mail;
		this.phone = phone;
		this.registerTime = registerTime;
		this.editTime = editTime;
		this.roles = roles;
		this.rememberMe = rememberMe;
		this.photoName = photoName;
//		this.profilo = profilo;
		this.preGroup = preGroup;
		this.prGame = prGame;
	}
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordAgain() {
		return passwordAgain;
	}
	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}
	public Timestamp getEditTime() {
		return editTime;
	}
	public void setEditTime(Timestamp editTime) {
		this.editTime = editTime;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
//	public  getProfilo() {
//		return profilo;
//	}
//	public void setProfilo(Blob profilo) {
//		this.profilo = profilo;
//	}
	public String getPreGroup() {
		return preGroup;
	}
	public void setPreGroup(String preGroup) {
		this.preGroup = preGroup;
	}
	public String getPrGame() {
		return prGame;
	}
	public void setPrGame(String prGame) {
		this.prGame = prGame;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userName=" + userName + ", nickName=" + nickName + ", password="
				+ password + ", passwordAgain=" + passwordAgain + ", personId=" + personId + ", birthday=" + birthday
				+ ", mail=" + mail + ", phone=" + phone + ", registerTime=" + registerTime + ", editTime=" + editTime
				+ ", roles=" + roles + ", rememberMe=" + rememberMe + ", photoName=" + photoName + ", profilo="
			 + ", preGroup=" + preGroup + ", prGame=" + prGame + "]";
	}
    
    
}
