package com.example.demo;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hi")
public class Hello {
	
	
	 private void initializeModel(Model model, OAuth2AuthenticationToken token) {
	        if (token != null) {
	            final OAuth2User user = token.getPrincipal();

	            model.addAttribute("grant_type", user.getAuthorities());
	            model.addAllAttributes(user.getAttributes());
	        }
	    }
	

	@GetMapping("/welcome")

	public String HelloApplication(Model model, OAuth2AuthenticationToken token) {
		
		initializeModel(model, token);

		return "hello";
	}
    
	@GetMapping("/hello")
	public String HelloApplication2() {
		
		return "hello2";
	}
	


}
