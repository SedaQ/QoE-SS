package com.seda.qoe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "subjectiveqoe")
	public String subjectiveqoe() {
		return "subjectiveqoe";
	}

	@RequestMapping(value = "objectiveqoe")
	public String objectiveqoe() {
		return "objectiveqoe";
	}

	@RequestMapping(value = "qoemeasurement")
	public String qoemeasurement() {
		return "qoemeasurement";
	}
	
	@RequestMapping(value = "resultcorrelation")
	public String resultcorrelation() {
		return "resultcorrelation";
	}

}