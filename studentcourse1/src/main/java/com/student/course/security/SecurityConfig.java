///*
// * Copyright (c) 2020, Liberty Mutual
// * Proprietary and Confidential
// * All Rights Reserved
// */
//
//package com.student.course.security;
//
//import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * Security config class
// * The configure method will define which endpoints has what authorizations set on them
// *
// * @author DNA Generator, version 1.87.38
// *
// */
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Value("${spring.profiles.active:}")
//	private String env;
//	@Value("${security.user.name:}")
//	private String user;
//	@Value("${security.user.password:}")
//	private String password;
//
//	@Override
//	@SuppressWarnings({"PMD.SignatureDeclareThrowsException"})
//	@SuppressFBWarnings(value = "SECSPRCSRFPD", justification = "Needs to be disabled due to not handling the " +
//			"token header requirement")
//	protected void configure(final HttpSecurity http) throws Exception {
//		http.headers().frameOptions().disable();
//		http.csrf().disable();
//		if (!("mock").equals(env)) {
//			http.authorizeRequests()
//			.antMatchers("/*").permitAll()
//			.antMatchers("/weather").permitAll()
//			.antMatchers("/actuator/health").permitAll()
//			.anyRequest().hasRole("ADMIN").and()
//				.httpBasic();
//		}
//		else {
//			http.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/weather").permitAll();
//		}
//	}
//	@Override
//	@SuppressWarnings({"PMD.SignatureDeclareThrowsException"})
//	@SuppressFBWarnings(value = "SECSPRCSRFPD", justification = "Needs to be disabled due to not handling the " +
//			"token header requirement")
//	public void configure(AuthenticationManagerBuilder auth) throws Exception	{
//		if (!("mock").equals(env)) {
//			auth.inMemoryAuthentication()
//			.withUser(user)
//			.password("{noop}" + password)
//				.roles("ADMIN");
//		}
//	}
//
//}
