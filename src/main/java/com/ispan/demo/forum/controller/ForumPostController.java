package com.ispan.demo.forum.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ispan.demo.forum.model.ForumPost;
import com.ispan.demo.forum.service.ForumPostService;

@Controller
public class ForumPostController {

	@Autowired
	private ForumPostService fService;

	@GetMapping("/forum/")
	public String forum(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {

		Page<ForumPost> page = fService.findByPage(pageNumber);
		model.addAttribute("page", page);

		return "/forum/forum-index";
	}

	@GetMapping("/forum/post")
	public String forumEach(@RequestParam("p") Integer id, Model model) {

		ForumPost fp = fService.findById(id);
		model.addAttribute("post", fp);

		return "/forum/forum-eachPost";
	}

	@GetMapping("/forum/add")
	public String addNewPost(Model model) {

		ForumPost fp = new ForumPost();
		model.addAttribute("forumPost", fp);

		return "forum/add-newPost";
	}

	@PostMapping("/forum/add")
	public String post(@RequestParam("teamName") String teamName,
					   @RequestParam("postArticle") String postArticle,
					   @RequestParam("postContent") String postContent,
					   @RequestParam("imageFile") MultipartFile imageFile) {

		ForumPost newPost = new ForumPost();
		try {
			newPost.setTeamName(teamName);
			newPost.setPostArticle(postArticle);
			newPost.setPostContent(postContent);
			newPost.setImageFile(imageFile.getBytes());
			fService.insert(newPost);
			return "forum/add-success";

		} catch (IOException e) {
			e.printStackTrace();
			return "redirect:/";
		}
	}

	@GetMapping("/showImage/{id}")
	public ResponseEntity<byte[]> showImage(@PathVariable("id") Integer id) {

		ForumPost fp = fService.findById(id);
		byte[] file = fp.getImageFile();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);
	}

//	@GetMapping("/forum/edit")
//	public String editPost(@ModelAttribute(name="postNo") Integer id, Model model) {
//
//		ForumPost fp = fService.findById(id);
//		model.addAttribute("forumPost", fp);
//		return "/forum/edit-post";
//	}
//	
//	@PostMapping("/forum/edit")
//	public String editForumPost(@ModelAttribute("ForumPost") ForumPost fp) {
//
//		fService.insert(fp);
//		return "redirect:/forum";
//	}

	@GetMapping("/forum/delete")
	public String deletePost(@RequestParam("p") Integer id) {
		fService.deleteById(id);
		return "redirect:/forum/";
	}

//	@ResponseBody
//	@PostMapping("/api/postMessage")
//	public List<ForumPost> postMessageApi(@RequestBody MessageDto dto){
//		String text = dto.getMsg();
//		WorkMessages newMsg = new WorkMessages();
//		newMsg.setText(text);
//		fService.insert(newMsg);
//		
//		Page<ForumPost> page = fService.findByPage(1);
//		List<ForumPost> list	= page.getContent();
//		
//		return list;
//	}
//	
//	@GetMapping("messages/ajax")
//	public String ajaxPage() {
//		return "messages/ajax-message";		
//	}

}
