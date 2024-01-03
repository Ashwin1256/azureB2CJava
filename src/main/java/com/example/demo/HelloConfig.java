package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.azure.spring.cloud.autoconfigure.implementation.aadb2c.security.AadB2cOidcLoginConfigurer;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
public class HelloConfig {
	
	
    private final AadB2cOidcLoginConfigurer configurer;

    public HelloConfig(AadB2cOidcLoginConfigurer configurer) {
        this.configurer = configurer;
    }


	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.apply(configurer).and().authorizeHttpRequests()
				.anyRequest().authenticated();
		// Do some custom configuration.
		return http.build();
	}

}
