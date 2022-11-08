package com.ispan.demo.memeber.registor.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ispan.demo.memeber.registor.model.member.Member;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Member.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors error) {
		Member member = (Member) target;

//		確認密碼
		if (!member.getPassword().equals(member.getPasswordAgain())) {
			error.rejectValue("passwordAgain", "", "請輸入相同密碼");
		}
		
//		信箱驗證
		Pattern pattern = Pattern.compile("^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$");
		Matcher matcher = pattern.matcher(member.getMail());
		if (matcher.find()==false) {
			error.rejectValue("mail", "", "請輸入正確信箱");
		}
		

			
	}
}
