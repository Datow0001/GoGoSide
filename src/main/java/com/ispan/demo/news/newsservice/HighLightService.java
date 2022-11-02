package com.ispan.demo.news.newsservice;

import java.util.List;

import com.ispan.demo.news.newsmodel.HighLight;

public interface HighLightService {

	void getHighLight();
	List<HighLight> findHL();
	
}
