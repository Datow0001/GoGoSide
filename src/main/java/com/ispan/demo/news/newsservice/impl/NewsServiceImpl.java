package com.ispan.demo.news.newsservice.impl;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ispan.demo.news.newsmodel.News;
import com.ispan.demo.news.newsmodel.NewsDao;
import com.ispan.demo.news.newsservice.NewsService;

@Transactional
@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsDao nDao;

	public void getNews() {

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriver driver2 = new ChromeDriver();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date1 = new Date();
		String date = sdf.format(date1);

//		String date = "2022/11/04";
		WebElement title;
//         從力台新聞網爬取
		driver.get("https://www.ltsports.com.tw/category/baseball/mlb/");

		List<WebElement> list = driver.findElements(By.className("post-date"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(date)) {
				title = driver.findElement(with(By.tagName("a")).above(list.get(i)));
				News news = new News();
				String dat = list.get(i).getText();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

				try {
					Date Ddate = sdf.parse(dat);
					news.setNewsDate(Ddate);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				news.setNewsTitle(title.getText());

				driver2.get(title.getAttribute("href"));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<WebElement> text = driver2.findElements(By.tagName("p"));
				List<WebElement> pic = driver2.findElements(By.tagName("img"));
				news.setPicFile(pic.get(1).getAttribute("src"));
				news.setPicTitle(pic.get(1).getAttribute("alt"));
				String index = "";
				for (int n = 0; n < text.size(); n++) {
					if (text.get(n).getText().contains("pic.twitter.com")||text.get(n).getText().equals("")) {
					} else {
						index += "<p>"+text.get(n).getText()+"</p>";
					}

				}
				news.setNewsIndex(index);			
				news.setShortIndex(index.substring(0, index.indexOf("。") + 1));
				news.setNewsClickCount(0);
				news.setSportType("MLB");
				Date datetoday=null;
				try {
					datetoday = new SimpleDateFormat("yyyy/MM/dd").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<News> ex = nDao.findByNewsDate(datetoday);
				boolean c=true;
				for (News news2 : ex) {
					if(news2.getNewsTitle().equals(news.getNewsTitle())) {
						c=false;
					}
				}
				if(c==true) {
					nDao.save(news);
				}
				
				}

		}
//		======================從中時新聞網爬取
		driver.get("https://www.chinatimes.com/sports/baseball/?chdtv");
		List<WebElement> list2 = driver.findElements(By.className("date"));

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().contains(date)) {
				News news2 = new News();
				
				try {
					Date Ddate = sdf.parse(date);
					news2.setNewsDate(Ddate);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				
				WebElement href = driver.findElement(with(By.tagName("a")).above(list2.get(i)));
				if (href.getText().contains("MLB")) {

					
					driver2.get(href.getAttribute("href"));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

//					System.out.println((driver2.findElement(By.className("article-title"))).getText());
					news2.setNewsTitle((driver2.findElement(By.className("article-title"))).getText());
//					System.out.println((driver2.findElement(By.className("photo")).getAttribute("src")));
					news2.setPicFile((driver2.findElement(By.className("photo")).getAttribute("src")));
					news2.setPicTitle((driver2.findElement(By.className("photo")).getAttribute("alt")));

					List<WebElement> p = driver2.findElements(By.tagName("p"));
					String pp = "";
					for (int n = 0; n < p.size(); n++) {
						if (p.get(n).getText().contains("pic.twitter.com")||p.get(n).getText().equals("")) {
						} else {
							pp += "<p>"+p.get(n).getText()+"</p>";
						}
					}

					news2.setNewsIndex(pp);
					news2.setShortIndex(pp.substring(0, pp.indexOf("。") + 1));
					news2.setNewsClickCount(0);
					news2.setSportType("MLB");
					Date datetoday=null;
					try {
						datetoday = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<News> ex = nDao.findByNewsDate(datetoday);
					boolean c=true;
					for (News news3 : ex) {
						if(news3.getNewsTitle().equals(news2.getNewsTitle())) {
							c=false;
						}
					}
					if(c==true) {
						nDao.save(news2);
					}
					

					
				}

			}
		}
		
		
		
//		=========================
		
		
		driver.close();
		driver2.close();

	}

	public void getNBANews() {

		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriver driver2 = new ChromeDriver();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date date1 = new Date();
		String date = sdf.format(date1);

//		String date = "2022/11/04";
		WebElement title;
//         從力台新聞網爬取
		driver.get("https://www.ltsports.com.tw/category/basketball/nba/");

		List<WebElement> list = driver.findElements(By.className("post-date"));
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equals(date)) {
				title = driver.findElement(with(By.tagName("a")).above(list.get(i)));
				News news = new News();
				String dat = list.get(i).getText();
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

				try {
					Date Ddate = sdf.parse(dat);
					news.setNewsDate(Ddate);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				news.setNewsTitle(title.getText());

				driver2.get(title.getAttribute("href"));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<WebElement> text = driver2.findElements(By.tagName("p"));
				List<WebElement> pic = driver2.findElements(By.tagName("img"));
				news.setPicFile(pic.get(1).getAttribute("src"));
				news.setPicTitle(pic.get(1).getAttribute("alt"));
				String index = "";
				for (int n = 0; n < text.size(); n++) {
					if (text.get(n).getText().contains("pic.twitter.com")||text.get(n).getText().equals("")) {
					} else {
						index += "<p>"+text.get(n).getText()+"</p>";
					}

				}
				news.setNewsIndex(index);			
				news.setShortIndex(index.substring(0, index.indexOf("。") + 1));
				news.setNewsClickCount(0);
				news.setSportType("NBA");
				Date datetoday=null;
				try {
					datetoday = new SimpleDateFormat("yyyy/MM/dd").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<News> ex = nDao.findByNewsDate(datetoday);
				boolean c=true;
				for (News news2 : ex) {
					if(news2.getNewsTitle().equals(news.getNewsTitle())) {
						c=false;
					}
				}
				if(c==true) {
					nDao.save(news);
				}
				
				}

		}
//		======================從中時新聞網爬取
		driver.get("https://www.chinatimes.com/sports/basketball/?chdtv");
		List<WebElement> list2 = driver.findElements(By.className("date"));

		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i).getText().contains(date)) {
				News news2 = new News();
				
				try {
					Date Ddate = sdf.parse(date);
					news2.setNewsDate(Ddate);
				} catch (ParseException e) {

					e.printStackTrace();
				}
				
				WebElement href = driver.findElement(with(By.tagName("a")).above(list2.get(i)));
				if (href.getText().contains("NBA")) {

					
					driver2.get(href.getAttribute("href"));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

//					System.out.println((driver2.findElement(By.className("article-title"))).getText());
					news2.setNewsTitle((driver2.findElement(By.className("article-title"))).getText());
//					System.out.println((driver2.findElement(By.className("photo")).getAttribute("src")));
					news2.setPicFile((driver2.findElement(By.className("photo")).getAttribute("src")));
					news2.setPicTitle((driver2.findElement(By.className("photo")).getAttribute("alt")));

					List<WebElement> p = driver2.findElements(By.tagName("p"));
					String pp = "";
					for (int n = 0; n < p.size(); n++) {
						if (p.get(n).getText().contains("pic.twitter.com")||p.get(n).getText().equals("")) {
						} else {
							pp += "<p>"+p.get(n).getText()+"</p>";
						}
					}

					news2.setNewsIndex(pp);
					news2.setShortIndex(pp.substring(0, pp.indexOf("。") + 1));
					news2.setNewsClickCount(0);
					news2.setSportType("NBA");
					Date datetoday=null;
					try {
						datetoday = new SimpleDateFormat("yyyy/MM/dd").parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<News> ex = nDao.findByNewsDate(datetoday);
					boolean c=true;
					for (News news3 : ex) {
						if(news3.getNewsTitle().equals(news2.getNewsTitle())) {
							c=false;
						}
					}
					if(c==true) {
						nDao.save(news2);
					}
					

					
				}

			}
		}
		
		
		
//		=========================
		
		
		driver.close();
		driver2.close();

	}
	
	
	public  void download(String urlString, String filename, String savePath) throws Exception {
		// 構造URL
		URL url = new URL(urlString);
		// 開啟連線
		URLConnection con = url.openConnection();
		// 設定請求超時為5s
		con.setConnectTimeout(5 * 1000);
		// 輸入流
		InputStream is = con.getInputStream();

		// 1K的資料緩衝
		byte[] bs = new byte[1024];
		// 讀取到的資料長度
		int len;
		// 輸出的檔案流
		File sf = new File(savePath);
		if (!sf.exists()) {
			sf.mkdirs();
		}
		OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
		// 開始讀取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完畢，關閉所有連結
		os.close();
		is.close();
	}

	public List<News> findAllNews() {
		return nDao.findAll();
	}

	public Page<News> findByPage(Integer pageNumber) {
		Pageable pgb = PageRequest.of(pageNumber - 1, 10, Sort.Direction.DESC, "newsNumber");
		Page<News> page = nDao.findAll(pgb);
		return page;
	}
	

	public News findById(Integer id) {
		Optional<News> op = nDao.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
}
	public List<News> findLastThree(){
		List<News> nws = nDao.findTop3ByOrderByNewsNumberDesc();
		return nws;
	}
	
	public List<News> findTopClick(){
		List<News> news = nDao.findTop5ByOrderByNewsClickCountDesc();
		return news;
	}
	
	public void deleteNews(Integer id) {
		nDao.deleteById(id);
	}
	
	public News	insert(News news) {
		return nDao.save(news);
	}
	public Page<News> findBySearch(String word){
		Pageable pageable = PageRequest.of(0, 3, Sort.Direction.DESC, "newsNumber");
		Page<News> news =nDao.search(word, pageable);	
		return news;
	}
	
	public Page<News> findBySport(String type,Integer pageNumber){//使用SERCH之後分頁失效 自行分頁
		List<News> list = nDao.findBySportType(type);
		Collections.reverse(list);//反轉 因為SORT沒用
		List list2 = new ArrayList<>();
		Sort sort = Sort.by(Sort.Direction.DESC, "newsNumber");//sort 沒用
		Pageable pageable = PageRequest.of(pageNumber-1, 10, sort);
		if (pageable.getOffset() > list.size()) {
		    long total = 0L;
		    PageImpl<News> emptyPage = new PageImpl<>(list2, pageable, total);
		    return emptyPage;
		}

		if (pageable.getOffset() <= list.size() && pageable.getOffset() + pageable.getPageSize() > list.size()) {
		    List<News> bizPojos = list.subList((int)pageable.getOffset(), list.size());
		    PageImpl<News> pPage = new PageImpl<>(bizPojos, pageable, list.size());
		    return pPage;
		}

		List<News> newNews = list.subList((int)pageable.getOffset(), (int)(pageable.getOffset() + pageable.getPageSize()));
		
		Page<News> page = new PageImpl<>(newNews, pageable, list.size());
		return page;
	}
	

	

}
