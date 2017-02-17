package com.seda.qoe.controllers;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seda.qoe.facade.MosFacade;

@Controller
@RequestMapping("/mos")
public class MosController {

	@Inject
	private MosFacade mosFacade;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("mosList", mosFacade.getAllMos());
		return "mos/mosList";
	}
}
