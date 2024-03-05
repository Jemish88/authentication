package com.demo.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.auth.AuthTokenFilter;

import jakarta.websocket.Session;
import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration{

	private final AuthTokenFilter authTokenFilter;
	
	private final AuthenticationProvider authenticationProvider;

    private static final String[] WHITE_LIST_URL = {"/welcome"};
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http//
		.csrf(AbstractHttpConfigurer :: disable)//
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//
		.authenticationProvider(authenticationProvider)//
		.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)//
		.authorizeHttpRequests(req -> req.requestMatchers(WHITE_LIST_URL).permitAll()//
				.anyRequest()
                .authenticated());
		return http.build();
	}
	
	
}
