package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloWorld {
	
	public HelloWorld(){
		System.out.println("++++++++++++++++++++++++++++++++++++++++========");
	}

	@RequestMapping("hello")
	public String hello(){
		return "index";
	}
	
	@RequestMapping("login")
	public String nihao(){
		return "index";
	}
}
