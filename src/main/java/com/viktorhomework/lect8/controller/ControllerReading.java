package com.viktorhomework.lect8.controller;

import com.viktorhomework.lect8.service.JoiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ControllerReading{

    @Autowired 
    public JoiningService joining;
    
    @GetMapping("/scifi")
	public String scifi() {
        return joining.injectToHTML("classpath:static/books/scifi.txt");
	}
    @GetMapping("/historic")
	public String historic() {
        return joining.injectToHTML("classpath:static/books/historic.txt");
	}
    @GetMapping("/romantic")
	public String romantic() {
        return joining.injectToHTML("classpath:static/books/romantic.txt");
	}
}