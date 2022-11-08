package com.ispan.demo.memeber.registor.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ispan.demo.forum.model.ForumPost;
import com.ispan.demo.memeber.login.model.Login;
import com.ispan.demo.memeber.registor.model.member.Member;
import com.ispan.demo.memeber.registor.service.MemberService;

@Controller
public class emptyFormController {

    @Autowired
    MemberService mService;

    // 首頁畫面
//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }
    // 會員登入畫面
//    @GetMapping("/loginForm")
//    public String Longin(Model model) {
//        model.addAttribute("login",new Member());
//        return "member/login";
//    }

    // 空的註冊表單
    @GetMapping("/registerForm")
    // 給定一個空的模型
    public String register(Model model) {
//        Member member = new Member();
        model.addAttribute("newMember",new Member());
        
        // 建一個存放會員資料的模型(變數名稱newMember)
        return "member/register";
    }

//    查看會員資料
    @GetMapping("/personForm")
    public String preson(HttpServletRequest request, HttpServletResponse response,Member member,Model model) {
    	HttpSession session = request.getSession();
    	Login login = (Login)session.getAttribute("LoginOK");
    	member = mService.findByUserId(login.getUserId());
    	model.addAttribute("member",member);
        return "member/memberCenter";
    }
    
    
    @PostMapping("/personForm")
    public String update(@RequestParam("profilo") MultipartFile imageFile,Member member) {
    	try {
			member.setPrfilo(imageFile.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	mService.insert(member);
    	return "redirect:/";
    }
    @GetMapping("/showUserImage")
	public ResponseEntity<byte[]> showImage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Login login = (Login)session.getAttribute("LoginOK");
		System.out.println(login.getUserId()+"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		Member member = mService.findByUserId(login.getUserId());
		byte[] file = member.getPrfilo();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);
	}
	@GetMapping("/PostUserImage/{id}")
	public ResponseEntity<byte[]>  postImg(@PathVariable("id") String id) {
		
		Member member = mService.findByUserId(id);
		byte[] file = member.getPrfilo();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(file, headers, HttpStatus.OK);
	}
	
    
}
