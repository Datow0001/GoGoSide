package com.ispan.demo.news.newscontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.demo.news.newsservice.NewsService;

@Controller
public class PageController {

	NewsService ns;

	
	
	@GetMapping("/")
	public String home() {	
		
		
		return "index";
	}
	

	
	
}
