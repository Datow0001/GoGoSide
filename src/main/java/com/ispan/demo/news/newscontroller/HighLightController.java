package com.ispan.demo.news.newscontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.demo.news.newsmodel.HighLight;
import com.ispan.demo.news.newsservice.HighLightService;

@Controller
public class HighLightController {
	@Autowired
	private HighLightService hls;

	@GetMapping("/getHighLight")
	public String getHighlight() {
		hls.getHighLight();
		return "index";
	}

	@GetMapping("/highlight")
	public String highlight(Model model) {
		List<HighLight> hl = hls.findHL();
		HighLight hl0 = hl.get(0);
		HighLight hl1 = hl.get(1);
		HighLight hl2 = hl.get(2);
		model.addAttribute("hl0", hl0);
		model.addAttribute("hl1", hl1);
		model.addAttribute("hl2", hl2);
		return "/layout/HighLight";
	}

}
