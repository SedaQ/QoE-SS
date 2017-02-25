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

	@RequestMapping(value = "/videa/aspenvidea")
	public String videaAspenVidea() {
		return "videa/aspenvidea";
	}

	@RequestMapping(value = "/videa/controlledBurn")
	public String videaControlledBurn() {
		return "videa/controlledburn";
	}

	@RequestMapping(value = "/testvidea/questionnaire")
	public String testVideaAspen() {
		return "testvidea/questionnaire";
	}

	@RequestMapping(value = "/presentation")
	public String presentation() {
		return "presentation";
	}

	@RequestMapping(value = "/fullthesis")
	public String fullthesis() {
		return "fullthesis";
	}

	@RequestMapping(value = "/contact")
	public String contact() {
		return "contact";
	}

	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}

	@RequestMapping(value = "/statistics")
	public String statistics() {
		return "statistics";
	}

}