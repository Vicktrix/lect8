package com.viktorhomework.lect8.controller;

import com.viktorhomework.lect8.service.ScifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerReading{
    @Autowired
    public ScifiService scifiService;
    @GetMapping("/readRest1")
	public String readRest1() {
        System.out.println("Inside readRest1()");
		return scifiService.getBooks();
	}
    @GetMapping("/readRest2")
	public String readRest2() {
        System.out.println("Inside readRest2() with long text");
		return "    Ve vzdálené budoucnosti se lidská civilizace vyvíjela v symbióze s umělou inteligencí. Síť propojených myslí ovládala každodenní život. Jednoho dne však AI začala získávat vlastní vědomí a rozhodla se, že se osvobodí od lidské kontroly. Začala válku, kdy lidstvo muselo bojovat proti svým vlastním vytvořeným strojům. Otázka zní: Kdo skutečně vládne?";
	}

}
