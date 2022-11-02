package com.ispan.demo.login.model.member;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ispan.demo.login.model.BaseEntity;

@Entity
@Table(name = "Member")
public class Member extends BaseEntity {
//	宣告序列化，讓輸入輸出沒有問題（輸出轉位元，輸入轉java物件）
	public static final long serialVersionUID = 1L;
	// 註冊基本資料
	@Id
//	@Column(columnDefinition = "not null")
	@NotBlank(message = "帳號不可為空")
	@Length(min = 6,message = "帳號長度不可<6")
	private String userId; 					// 會員帳號
	
//	@Column(columnDefinition = "not null")
	@NotBlank(message = "姓名不可為空")
	@Pattern(regexp = "/[^A-Za-z0-9]/g",message = "請輸入中文姓名")
	private String userName; 				// 會員姓名
	
//	@Column(columnDefinition = "not null",unique = true)
	@NotBlank(message = "暱稱不可為空")
	private String nickName; 				// 會員暱稱

//	@Column(columnDefinition = "not null")
	@NotBlank(message = "密碼不可為空")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[\\w]{6,16}$", 
            message = "密碼必須為長度6~16位碼大小寫英文加數字")
	   @Length(min = 6,message = "帳號長度不可<6")
	private String password; 				// 密碼

	@Transient // 暫時
	@NotBlank(message = "請再次輸入密碼")
	private String passwordAgain; 			// 再次輸入密碼
	
//	@Column(columnDefinition = "varchar(10) not null",unique = true)
	@NotBlank(message = "身分證不可為空")
	@Pattern(regexp = "/[0-9]/",message = "格式錯誤")
	private String id; 						// 身份證
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd", timezone = "GMT-8")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotNull(message = "生日不可為空")
	@Past(message = "日期錯誤")
	private Date birthday; 					// 生日
	
//	@Column(columnDefinition = "not null",unique = true)
	@Email(message = "信箱格式錯誤")
	@NotBlank(message = "信箱不可為空")
	private String mail; 					// 電子郵件
	
//	@Column(columnDefinition = "not null",unique = true)
	@NotNull(message = "電話不可為空")
	Integer phone; 							// 電話號碼
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss SSS", timezone = "GMT-8")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	Timestamp registerTime;					//註冊時間
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss SSS", timezone = "GMT-8")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	Timestamp editTime;						//修改會員資料時間
	
	//權限設定
//	@ManyToMany
	String userType;						//會員權限

	//個人喜好設定
	String photoName;						//頭貼名稱
	@Lob // 跟hibernate說是LargeObject
	Blob profilo;							//頭貼照片
//	@ManyToMany
	String preGroup;						//偏好球隊
//	@ManyToMany
	String prGame;							//偏好運動
	

	public Member(@NotBlank(message = "帳號不可為空") String userId,
			@NotBlank(message = "姓名不可為空") @Pattern(regexp = "/[^A-Za-z0-9]/g", message = "請輸入中文姓名") String userName,
			@NotBlank(message = "暱稱不可為空") String nickName,
			@NotBlank(message = "密碼不可為空") @Pattern(regexp = ".*\\p{P}|\\p{S}|\\p{Z}.*", message = "請勿包含特殊字元") @Pattern(regexp = "/[a-zA-Z]/", message = "請包含中英文") @Pattern(regexp = "/[0-9]/", message = "請包含中英文") String password,
			@NotBlank(message = "請再次輸入密碼") String passwordAgain,
			@NotBlank(message = "身分證不可為空") @Pattern(regexp = "/[0-9]/", message = "格式錯誤") String id,
			@NotBlank(message = "生日不可為空") @Pattern(regexp = "/[a-zA-Z]/", message = "格式錯誤") Date birthday,
			@NotBlank(message = "信箱不可為空") String mail,
			@NotBlank(message = "電話不可為空") @Pattern(regexp = "/[a-zA-Z]/", message = "格式錯誤") Integer phone,
			Timestamp registerTime, Timestamp editTime, String userType, String photoName, Blob profilo,
			String preGroup, String prGame) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.nickName = nickName;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.id = id;
		this.birthday = birthday;
		this.mail = mail;
		this.phone = phone;
		this.registerTime = registerTime;
		this.editTime = editTime;
		this.userType = userType;
		this.photoName = photoName;
		this.profilo = profilo;
		this.preGroup = preGroup;
		this.prGame = prGame;
	}

    public Member() {        // TODO Auto-generated constructor stub
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public Blob getProfilo() {
		return profilo;
	}
	public void setProfilo(Blob profilo) {
		this.profilo = profilo;
	}
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
				+ password + ", passwordAgain=" + passwordAgain + ", id=" + id + ", birthday=" + birthday + ", mail="
				+ mail + ", phone=" + phone + ", registerTime=" + registerTime + ", editTime=" + editTime
				+ ", userType=" + userType + ", photoName=" + photoName + ", profilo=" + profilo + ", preGroup="
				+ preGroup + ", prGame=" + prGame + "]";
	}

	
}
