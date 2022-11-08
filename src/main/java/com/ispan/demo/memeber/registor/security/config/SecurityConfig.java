//package com.ispan.demo.memeber.registor.security.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//	@Autowired
//	@Qualifier("userServiceImpl")
//	private UserDetailsService userDetailsService;
////
////	@Autowired
////	private CorsFilter corsFilter;
////	@Autowired
////	@Qualifier("securityProblemSupport")
////	private SecurityProblemSupport securityProblemSupport;
//	
//	
//
//	
////	密碼編碼處理
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
////	@Bean
////	public UserDetailsService userDetailsService(BCryptPasswordEncoder bcryptPasswordEncoder) {
////		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////		manager.createUser(
////				User.withUsername("user").password(bcryptPasswordEncoder.encode("userPassword")).roles("USER").build());
////		manager.createUser(
////				User.withUsername("admin").password(bcryptPasswordEncoder.encode("adminPassword")).roles("USER","ADMIN").build());
////		return manager;
////	}
//	
////定義安全策略，設置HTTP訪問規則
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
////		.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
////		.exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
////		.accessDeniedHandler(SecurityProblemSupport)
////		.headers().frameOptions().disable()
////		.and().logout().logoutUrl("/index")
////		.and()
//		.authorizeRequests()							//開啟配置，指定路徑下資源驗證後才可訪問
//		.antMatchers("/").permitAll()
////		.antMatchers(HttpMethod.POST,SecurityConstraint.ROLE_ALL_AUTHENTICATED_USERS).permitAll()
//		.antMatchers(HttpMethod.GET,"/user/**").authenticated()			//url必須有ADMIN角色
//		.antMatchers(HttpMethod.GET).permitAll()			//url必須有ADMIN角色
//		.antMatchers(HttpMethod.POST,"/user").permitAll()			//url必須有ADMIN角色
////		.antMatchers(HttpMethod.POST,"/member/register").permitAll()			//url必須有ADMIN角色
//		.anyRequest().authenticated() 						// 其他都需登入才可訪問
////		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and().csrf().disable()// 關閉對CSRF(跨站請求偽造)攻擊的防護，才不會拒絕外部對API
//		.formLogin().loginProcessingUrl("/login")
////		.and()
////		.apply(securityConfigurerAdapter())
//		;
//		return httpSecurity.build();
//	}
//
//	//傳回加密後的密碼
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth
//		.userDetailsService(userDetailsService)
//		.passwordEncoder(new BCryptPasswordEncoder());
//	}
////	   private JwtConfigurer securityConfigurationAdapter() throws Exception{
////	        return new JwtConfigurer(new JwtAuthorizationFilter(authenticationManager()));
////	    }
//
//}