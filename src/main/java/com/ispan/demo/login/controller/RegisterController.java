package com.ispan.demo.login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ispan.demo.login.model.member.Member;
import com.ispan.demo.login.repository.MemberRepository;
import com.ispan.demo.login.service.MemberService;
import com.ispan.demo.login.validator.RegisterValidator;

@Controller
public class RegisterController {

    MemberService mService;
    MemberRepository mRepository;

    @Autowired
    public RegisterController(MemberService mService, MemberRepository mRepository) {
        super();
        this.mService = mService;
        this.mRepository = mRepository;
    }

    @PostMapping("/addMember")
    public String insertMember(@Valid @ModelAttribute("newMember") Member member, BindingResult bindingResult, Model model) {
        RegisterValidator registerValidator = new RegisterValidator();
        registerValidator.validate(member, bindingResult);
        if (bindingResult.hasErrors()) {
//            List<ObjectError> errorsList = bindingResult.getAllErrors();
//            for (ObjectError error : errorsList) {
//                System.out.println(error.getDefaultMessage());
//            }
            return "member/register";
        }
        mRepository.save(member);
        return "member/login";

    }

//    修改個人資料
//    @PostMapping("/personData/Upload")
//    public String showPersonData(Model model) {
//        mService.findByUserId(null)
//        model.addAttribute("member",)
//    }

}
