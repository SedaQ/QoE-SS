package com.seda.qoe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {

	@RequestMapping(value = "/home")
	public String index() {
		return "home";
	}

	@RequestMapping(value = "/videa/aspen")
	public String videaAspen() {
		return "videa/aspen";
	}

	@RequestMapping(value = "/videa/controlledBurn")
	public String videaControlledBurn() {
		return "videa/controlledburn";
	}

	@RequestMapping(value = "/presentation")
	public String presentation() {
		return "presentation";
	}

	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}

}