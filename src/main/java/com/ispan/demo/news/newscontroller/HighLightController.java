package com.ispan.demo.news.newscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.demo.news.newsmodel.HighLight;
import com.ispan.demo.news.newsmodel.News;
import com.ispan.demo.news.newsservice.HighLightService;
import com.ispan.demo.news.newsservice.NewsService;

@Controller
public class HighLightController {
	@Autowired
	private HighLightService hls;
	@Autowired
	private NewsService ns;
	
	@GetMapping("/getHighLight")
	public String getHighlight() {
		hls.getHighLight();
		return "index";
	}

	@GetMapping("/highlight")
	public String highlight(Model model) {
		List<HighLight> hl = hls.findHL();
		for(int i=0;i<=6;i++) {
			HighLight hl0 = hl.get(i);
			String href0=hl0.getHighLightHref();
			String sh=href0.substring(href0.indexOf("=")+1);
			String url0 = "http://img.youtube.com/vi/"+sh+"/maxresdefault.jpg";
			model.addAttribute("url"+i,url0);
			model.addAttribute("hl"+i, hl0);
		}
		List<News> list = ns.findTopTenClick();
		for(int i=0;i<=9;i++) {
			News news = list.get(i);
			model.addAttribute("news"+i,news);
		}
		
		
//		HighLight hl0 = hl.get(0);
//		HighLight hl1 = hl.get(1);
//		HighLight hl2 = hl.get(2);
//		HighLight hl3 = hl.get(3);
//		HighLight hl4 = hl.get(4);
//		HighLight hl5 = hl.get(5);
//		HighLight hl6 = hl.get(6);
//		String href0=hl0.getHighLightHref();
//		String sh=href0.substring(href0.indexOf("=")+1);
//		String url0 = "http://img.youtube.com/vi/"+sh+"/maxresdefault.jpg";
//		
//		String href1=hl1.getHighLightHref();
//		String sh1=href1.substring(href1.indexOf("=")+1);
//		String url1 = "http://img.youtube.com/vi/"+sh1+"/maxresdefault.jpg";
//		
//		String href2=hl2.getHighLightHref();
//		String sh2=href2.substring(href2.indexOf("=")+1);
//		String url2 = "http://img.youtube.com/vi/"+sh2+"/maxresdefault.jpg";
//		
//		String href3=hl3.getHighLightHref();
//		String sh3=href3.substring(href3.indexOf("=")+1);
//		String url3 = "http://img.youtube.com/vi/"+sh3+"/maxresdefault.jpg";
//		
//		String href4=hl4.getHighLightHref();
//		String sh4=href4.substring(href4.indexOf("=")+1);
//		String url4 = "http://img.youtube.com/vi/"+sh4+"/maxresdefault.jpg";
//		
//		String href5=hl5.getHighLightHref();
//		String sh5=href5.substring(href5.indexOf("=")+1);
//		String url5 = "http://img.youtube.com/vi/"+sh5+"/maxresdefault.jpg";
//		
//		String href6=hl6.getHighLightHref();
//		String sh6=href6.substring(href6.indexOf("=")+1);
//		String url6 = "http://img.youtube.com/vi/"+sh6+"/maxresdefault.jpg";
//		
//		
//		
//		model.addAttribute("url0",url0);
//		model.addAttribute("url1",url1);
//		model.addAttribute("url2",url2);
//		model.addAttribute("url3",url3);
//		model.addAttribute("url4",url4);
//		model.addAttribute("url5",url5);
//		model.addAttribute("url6",url6);
//		
//		model.addAttribute("hl0", hl0);
//		model.addAttribute("hl1", hl1);
//		model.addAttribute("hl2", hl2);
//		model.addAttribute("hl3", hl3);
//		model.addAttribute("hl4", hl4);
//		model.addAttribute("hl5", hl5);
//		model.addAttribute("hl6", hl6);
		return "/layout/reel";
	}

}
