package com.ispan.demo.news.newsmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "highLight")
public class HighLight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer highLightId;

	@Column(name = "title")
	private String title;
	
	@Column(name = "highLightHref")
	private String highLightHref;

	public Integer gethighLightId() {
		return highLightId;
	}

	public void setId(Integer highLightId) {
		this.highLightId = highLightId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHighLightHref() {
		return highLightHref;
	}

	public void setHighLightHref(String highLightHref) {
		this.highLightHref = highLightHref;
	}

	public HighLight(Integer highLightId, String title, String highLightHref) {
		super();
		this.highLightId = highLightId;
		this.title = title;
		this.highLightHref = highLightHref;
	}

	public HighLight() {

	}

}
