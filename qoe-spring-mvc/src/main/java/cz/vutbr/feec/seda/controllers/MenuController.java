package cz.vutbr.feec.seda.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cz.vutbr.feec.seda.dto.questionary.QuestionaryCreateDTO;
import cz.vutbr.feec.seda.dto.questionary.QuestionaryDTO;
import cz.vutbr.feec.seda.facade.QuestionaryFacade;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Controller
public class MenuController {
	
	@Inject
	private QuestionaryFacade questionariesFacade;
	
	@RequestMapping(value = "/home")
	public String index() {
		return "home";
	}

	@RequestMapping(value = "/testvidea/questionnaire")
	public String testVideaAspen(Model model) {
		model.addAttribute("questionaryCreate", new QuestionaryCreateDTO());
		return "testvidea/questionnaire";
	}
	
	@RequestMapping(value="/searchtesters")
	public String searchTesters(@RequestParam("searchTerm") String searchTerm, Model model){
		List<QuestionaryDTO> questionaries = questionariesFacade.findBySearchTerm(searchTerm.trim());
		model.addAttribute("questionaries", questionaries);
		return "users/usersList";
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