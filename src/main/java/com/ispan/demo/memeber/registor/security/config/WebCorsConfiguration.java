//package com.ispan.demo.memeber.registor.security.config;
//
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//	public class WebCorsConfiguration implements WebMvcConfigurer {
//
//	    @Bean
//	    public CorsFilter corsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowCredentials(true);
//	        config.setAllowedOrigins(Collections.singletonList("*"));
//	        config.setAllowedMethods(Collections.singletonList("*"));
//	        config.setAllowedHeaders(Collections.singletonList("*"));
//	        // 暴露 header 中的其他属性给客户端应用程序
//	        config.setExposedHeaders(Arrays.asList(
//	                "Authorization", "X-Total-Count", "Link",
//	                "Access-Control-Allow-Origin",
//	                "Access-Control-Allow-Credentials"
//	        ));
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter(source);
//	    }
//}
