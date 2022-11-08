//package com.ispan.demo.memeber.registor.security.config;
//
//import java.util.Optional;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.domain.AuditorAware;
//
//import com.ispan.demo.memeber.registor.security.utils.SecurityUtil;
//
//	@Configuration
//	public class SecurityAuditorAware implements AuditorAware<String> {
//
//	    @Override
//	    public Optional<String> getCurrentAuditor() {
//	        Optional<String> userLogin = SecurityUtil.getCurrentUserLogin();
//	        if (userLogin.isPresent()) {
//	            return userLogin;
//	        }
//	        return Optional.of("system");
//	    }
//}
