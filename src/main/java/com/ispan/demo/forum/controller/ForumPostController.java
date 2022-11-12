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

import com.ispan.demo.forum.model.ForumComment;
import com.ispan.demo.forum.model.ForumPost;
import com.ispan.demo.forum.service.ForumCommentService;
import com.ispan.demo.forum.service.ForumPostService;

@Controller
public class ForumPostController {

	@Autowired
	private ForumPostService fService;
	
    @Autowired
    private ForumCommentService fcService;

	@GetMapping("/forum/search")
	public String searchForumPost(@RequestParam(name="word") String word, Model model) {
		Page<ForumPost> page = fService.findBySearch(word);	
		model.addAttribute("page", page);
		
		List<ForumPost> top = fService.findMostViews();
		model.addAttribute("top", top);

		return "/forum/ViewSearchResult"; 
	}
    
	@GetMapping("/forum/")
	public String forum(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {

		Page<ForumPost> page = fService.findByPage(pageNumber);
		model.addAttribute("page", page);
		
		List<ForumPost> top = fService.findMostViews();
		model.addAttribute("top", top);

		return "/forum/forum-index";
	}
	
	@GetMapping("/forum/orderbyteam")
	public String searchTeamForum(@RequestParam(name="team")String teamName,@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {

		Page<ForumPost> page = fService.findByTeamName(teamName,pageNumber);
		model.addAttribute("page", page);
		
		return "/forum/forum-index";
	}
	
	
	@GetMapping("/forum/ViewEachPost")
	public String viewForumPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		ForumPost post = fService.findById(pageNumber);
		post.setPostViews(post.getPostViews()+1);
		model.addAttribute("ForumPost", post);
		
		Page<ForumComment> page = fcService.findByPage(pageNumber);
		model.addAttribute("page", page);
		
		ForumComment comment = new ForumComment();
		model.addAttribute("forumComment", comment);
		
		List<ForumPost> top = fService.findMostViews();
		model.addAttribute("top", top);
		
		return "/forum/forum-eachPost";
	}
	
	@PostMapping("/forum/ViewEachPost")
	public String postComment(@ModelAttribute(name = "forumComment") ForumComment comment, Model model) {
		fcService.insert(comment);
		ForumComment fc = new ForumComment();
		model.addAttribute("forumComment", fc);
		
		return "redirect:/forum/ViewEachPost?p=" + comment.getPostNo();
	}
	
	@GetMapping("/forum/add")
	public String addNewPost(Model model) {

		ForumPost fp = new ForumPost();
		model.addAttribute("forumPost", fp);

		return "forum/add-newPost";
	}

	@PostMapping("/forum/add")
	public String post(
		   @RequestParam("userId") String userId,
		   @RequestParam("sportType") String sportType,
		   @RequestParam("teamArea") String teamArea,
           @RequestParam("teamName") String teamName,
           @RequestParam("postArticle") String postArticle,
		   @RequestParam("postContent") String postContent,
		   @RequestParam("imageFile") MultipartFile imageFile) {

		ForumPost newPost = new ForumPost();
		try {
			newPost.setUserId(userId);
			newPost.setSportType(sportType);
		    newPost.setTeamArea(teamArea);
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

	@GetMapping("/forum/edit")
	public String editPost(@RequestParam("p") Integer id, Model model) {

		ForumPost fp = fService.findById(id);
		model.addAttribute("forumPost", fp);
		return "/forum/edit-post";
	}
	
	@PostMapping("/forum/edit")
	public String editForumPost(
	        @RequestParam("postNo") Integer postNo,
	        @RequestParam("userId") String userId,
	        @RequestParam("sportType") String sportType,
	        @RequestParam("teamArea") String teamArea,
	        @RequestParam("teamName") String teamName,
            @RequestParam("postArticle") String postArticle,
            @RequestParam("postContent") String postContent,
            @RequestParam(value = "photo", required = false) MultipartFile imageFile) {
	    
	    byte[] photo;
	    if(!imageFile.isEmpty()) {
	        try {
	            photo = imageFile.getBytes();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
	    }else {
	        ForumPost post = fService.findById(postNo);
	        photo = post.getImageFile();
	    }
	    ForumPost fp = fService.findById(postNo);
	    fp.setPostNo(postNo);
	    fp.setUserId(userId);
	    fp.setSportType(sportType);
	    fp.setTeamArea(teamArea);
	    fp.setTeamName(teamName);
	    fp.setPostArticle(postArticle);
	    fp.setPostContent(postContent);
	    fp.setImageFile(photo);	    
	    
	    fService.insert(fp);
	    return "redirect:/forum/";
	}

	@GetMapping("/forum/delete")
	public String deletePost(@RequestParam("p") Integer id) {
		fService.deleteById(id);
		return "redirect:/forum/";
	}
//  @GetMapping("/forum/cmmtEdit")
//  public String editComment(@RequestParam("id") Integer cmmtNo, Model model) {
//      
//      ForumComment fc = fcService.findById(cmmtNo);
//      model.addAttribute("forumComment", fc);
//      return "/forum/each-post";
//  }
//  
//  @PostMapping("/forum/cmmtEdit")
//  public String postEditComment(@ModelAttribute ("forumComment") ForumComment fc) {
//      fcService.insert(fc);
//      return "redirect:/forum/page";
//  }

	@GetMapping("/forum/cmmtDelete")
	public String deleteComment(@ModelAttribute(name="delid") Integer cmmtNo) {
		Integer idP = fcService.findById(cmmtNo).getPostNo();
		fcService.deleteById(cmmtNo);		
		return "redirect:/forum/ViewEachPost?p=" + idP;
	}
  
}
