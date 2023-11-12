package com.viktorhomework.lect8.controller;

import com.viktorhomework.lect8.service.ScifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ControllerMVC{
    private int counter =0;

    @Autowired
    public ScifiService scifiService;

    @GetMapping()
	public String hello() {
        System.out.println("Inside Hello, counter - "+(counter++));
        System.out.println("list = "+scifiService.getBooks());
        System.out.println(scifiService.getBooks());
		return "Hello.html";
	}    
    @GetMapping("/Hello")
	public String hello2() {
        System.out.println("Inside Hello, counter - "+(counter++));
        System.out.println("list = "+scifiService.getBooks());
        System.out.println(scifiService.getBooks());
		return "Hello.html";
	}    
    @GetMapping("/scifi")
	public String scifi() {
        System.out.println("Inside scifi, counter - "+(counter++));
		return "myScifi.html";
	}    
    @GetMapping("/romantic")
	public String romantic() {
        System.out.println("Inside romantic, counter - "+(counter++));
		return "myRomantic.html";
	}    
    @GetMapping("/historic")
	public String historic() {
        System.out.println("Inside historic, counter - "+(counter++));
		return "myHistoric.html";
	}    
    @GetMapping("/read")
    public String read() {
        System.out.println("Inside read Scifi, counter - "+(counter++));
        return "books/scifi.txt";
    }
    @GetMapping("/books/scifi.txt")
    public String read2() {
        System.out.println("Inside read Scifi, counter - "+(counter++));
        return "books/scifi.txt";
    }
}
