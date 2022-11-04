package com.ispan.demo.news.newscontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ispan.demo.news.newsmodel.News;
import com.ispan.demo.news.newsmodel.NewsMessages;
import com.ispan.demo.news.newsservice.NewsMessagesService;
import com.ispan.demo.news.newsservice.NewsService;

@Controller
public class NewsController {
	@Autowired
	private NewsService nService;
	@Autowired
	private NewsMessagesService nmService;
	


	@GetMapping("/getNews")
	public String getNews() {
//		List<News> list = nService.findAllNews();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//		Date date = new Date();
//		String sDate = sdf.format(date);
//		String sDate = "2022/10/13";
//		Boolean b = true;
//		for (News news : list) {
//			if (sdf.format(news.getNewsDate()).equals(sDate)) {
////				nService.deleteNews(news.getNewsNumber());
////				nmService.deleteByNewsNumber(news.getNewsNumber());
//				b = false;
//			}
//		}
//		if (b == true) {
//			nService.getNews();
//		} else {
//			System.out.println(date+"已有");
//		}
		nService.getNews();
		return "index";
	}
	@GetMapping("/getNBAnews")
	public String getNBAnews() {
		nService.getNBANews();
		return"index";
	}
	
	@GetMapping("/News/search")
	public String searchNews(@RequestParam(name="word")String word,Model model) {
		Page<News> page=nService.findBySearch(word);	
		model.addAttribute("page",page);
		
		List<News> top = nService.findTopClick();
		model.addAttribute("top",top);

		return "News/ViewSearchNews"; 
	}
	
	
	@GetMapping("/News/searchNBA")
	public String searchNBANews(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber,Model model) {
		Page<News> page=nService.findBySport("NBA",pageNumber);	
		model.addAttribute("page",page);
		
		List<News> top = nService.findTopClick();
		model.addAttribute("top",top);
		model.addAttribute("type","NBA");
		return "News/ViewSearchNews"; 
	}
	@GetMapping("/News/searchMLB")
	public String searchMLBNews(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber,Model model) {
		Page<News> page=nService.findBySport("MLB",pageNumber);	
		model.addAttribute("page",page);
		
		List<News> top = nService.findTopClick();
		model.addAttribute("top",top);
		model.addAttribute("type","MLB");
		return "News/ViewSearchNews"; 
	}

	@GetMapping("/News/newsPage")
	public String viewNews(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		Page<News> page = nService.findByPage(pageNumber);
		model.addAttribute("page", page);
		List<News> top = nService.findTopClick();
		model.addAttribute("top",top);

		return "News/ViewNews";
	}

	@GetMapping("/News/ViewNewsPage")
	public String viewNewsPage(@RequestParam(name = "id", defaultValue = "1") Integer pageNumber, Model model) {
		News news = nService.findById(pageNumber);
		news.setNewsClickCount(news.getNewsClickCount()+1);
		model.addAttribute("News", news);
		Page<NewsMessages> page = nmService.findByPage(pageNumber);
		model.addAttribute("page", page);
		NewsMessages n1 = new NewsMessages();
		model.addAttribute("newsMessage", n1);
		List<News> top = nService.findTopClick();
		model.addAttribute("top",top);
		return "News/ViewNewsPage";
	}

	@PostMapping("/News/ViewNewsPage")
	public String postNewsMessages(@ModelAttribute(name = "newsMessage") NewsMessages nm, Model model) {
		nmService.insert(nm);
		NewsMessages n1 = new NewsMessages();
		model.addAttribute("newsMessage", n1);
		String ret = "News/ViewNewsPage?id=" + nm.getNewsNumber();
		return "redirect:/" + ret;

	}
	
//	@GetMapping("/News/Login")
//	public String Login() {
//		return "News/Login";
//	}
	
	@GetMapping("/preNews")
	public String preNews(Model model) {
		List<News> lns = nService.findLastThree();
		News news = lns.get(0);
		News news2 = lns.get(1);
		News news3 = lns.get(2);
		model.addAttribute("news",news);
		model.addAttribute("news2",news2);
		model.addAttribute("news3",news3);
		return "/layout/preNews";
	}
	
	@GetMapping("/delNews")
	public String deleteNews(@ModelAttribute(name="delid")Integer id) {
		nService.deleteNews(id);
		return"redirect:/News/newsPage";
	}
	
	@GetMapping("/News/EditNews")
	public String editNews(@ModelAttribute(name="id")Integer id,Model model) {
		News news = nService.findById(id);
		model.addAttribute("News",news);
		return"/News/EditNews";
	}
	
	@PostMapping("/News/postEditNews")
	public String postEditNews(@ModelAttribute("News") News news) {
		nService.insert(news);
		return"redirect:/News/newsPage";
	}
	
	@GetMapping("/delMessage")
	public String deleteMessage(@ModelAttribute(name="delid") Integer id) {
		int idN=nmService.findById(id).getNewsNumber();
		nmService.deleteById(id);		
		return"redirect:/News/ViewNewsPage?id="+idN;
		
	}
	

}
