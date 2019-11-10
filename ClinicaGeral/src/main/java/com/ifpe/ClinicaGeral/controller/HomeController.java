package com.ifpe.ClinicaGeral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String novo() {
		return "home";
	}
	
	
}
