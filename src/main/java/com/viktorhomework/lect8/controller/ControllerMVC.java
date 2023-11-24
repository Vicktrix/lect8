package com.viktorhomework.lect8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerMVC{

    @GetMapping()
	public String hello() {
		return "Hello.html";
	}    
    @GetMapping("/Hello")
	public String hello2() {
		return "Hello.html";
	}    
}
