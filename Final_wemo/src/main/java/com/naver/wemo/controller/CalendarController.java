package com.naver.wemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalendarController {
	
	/*
	 * @Autowired Calendar calendar;
	 * 
	 * @Autowired CalendarDAO calendardao;
	 */
	
	@RequestMapping("/Calendar")
	public String newCalendar() {
		return "Calendar";
	}
	
	
	
}
