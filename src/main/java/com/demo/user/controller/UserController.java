package com.demo.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/user")
public class UserController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}
}
