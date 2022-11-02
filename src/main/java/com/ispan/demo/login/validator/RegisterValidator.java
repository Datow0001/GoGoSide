package com.ispan.demo.login.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ispan.demo.login.model.member.Member;

public class RegisterValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "", "帳號不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "", "名字不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "", "暱稱不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "密碼不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "", "身分證不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "", "生日不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "", "信箱不可為空");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "", "電話不可為空");

//		帳號
//        if (errors.hasFieldErrors("userId")) {
//            if (member.getUserId().length() <= 6) {
//                errors.rejectValue("userId", "", "帳號不可<6字元");
//            }
//        }
//      名字
        if (errors.hasFieldErrors("userName")) {
            if (member.getUserName().matches("/[^A-Za-z0-9]/g")) {
                errors.rejectValue("userName", "", "請輸入中文姓名");
            }
        }
//		密碼
        if (errors.hasFieldErrors("password")) {
            String password = member.getPassword();
            if (password.length() <= 6) {
                errors.rejectValue("password", "", "密碼不可<6字元");
            } else if (password.matches(".*\\p{P}|\\p{S}|\\p{Z}.*")) {
                errors.rejectValue("password", "", "請勿包含特殊字元");
            } else if (password.matches("/[a-zA-Z]/")) {
                errors.rejectValue("password", "", "請包含中英文");
            } else if (password.matches("/[0-9]/")) {
                errors.rejectValue("password", "", "請包含中英文");
            }
        }

//		確認密碼
        if (errors.hasFieldErrors("passwordAgain")) {
            if (!member.getPassword().equals(member.getPasswordAgain())) {
                errors.rejectValue("passwordAgain", "", "請輸入相同密碼");
            }

//		身分證
            if (errors.hasFieldErrors("id")) {
                if (member.getId().matches("/[a-zA-Z]/")) {
                    errors.rejectValue("id", "", "請輸入相同密碼");
                }
            }
        
        
        }
    }
}
