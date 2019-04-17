package com.better.piglatin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.piglatin.service.TranslatorService;

@RestController
public class TranslatorController {
	
	@Autowired
	TranslatorService translator;
	@RequestMapping(value= {"/translate"}, method = RequestMethod.GET)
    public String translateReqHandler(@RequestParam(value="reqstring") String english){
        
		
		if(english==null||english.length()<1)
			return "No input";
		String response=translator.translate(english);
		
				
        return response;
    }
}
