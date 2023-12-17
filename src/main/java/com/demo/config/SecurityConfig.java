package com.demo.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> 
				// request List
				authorize.requestMatchers("admin").permitAll()
					.requestMatchers("/public/**").permitAll()
					.anyRequest().authenticated())
				// formLogin
				.formLogin(formLogin -> formLogin
						.loginPage("/loginPage") // Login URL
						.defaultSuccessUrl("/main") // 인증 후 URL -> default : 이전 URL
						.failureUrl("/error/401")
						.usernameParameter("userId") // ID parameter name
						.passwordParameter("passwd") // PWD parameter name
						.loginProcessingUrl("/login_proc") // Login Form Action URL
						.successHandler(new AuthenticationSuccessHandler() {
							@Override
							public void onAuthenticationSuccess(HttpServletRequest request,
									HttpServletResponse response, Authentication authentication)
									throws IOException, ServletException {
								System.out.println("authentication : " + authentication.getName());
								response.sendRedirect("/main");
							}
						})
						.failureHandler(new AuthenticationFailureHandler() {
							@Override
							public void onAuthenticationFailure(HttpServletRequest request,
									HttpServletResponse response, AuthenticationException exception)
									throws IOException, ServletException {
								System.out.println("exception : " + exception.getMessage());
								response.sendRedirect("/error/401");
							}
						})
						.permitAll());

		return http.build();

	}

}
