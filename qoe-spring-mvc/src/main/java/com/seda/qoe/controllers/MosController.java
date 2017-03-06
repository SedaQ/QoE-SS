package com.seda.qoe.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.seda.qoe.dto.mos.MosCreateDTO;
import com.seda.qoe.dto.mos.MosCreateDTOValue;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.MosFacade;

/**
 * @author Pavel Šeda (441048)
 * 
 */
@Controller
@RequestMapping("/mos")
public class MosController {

	@Inject
	private MosFacade mosFacade;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, @RequestParam("search") String search) {
		model.addAttribute("mosList", mosFacade.getAllMos(search));
		return "mos/mosList";
	}

	@RequestMapping(value = "/evaluate", method = RequestMethod.POST)
	public String evaluate(Model model) {
		return "testvidea/mos";
	}

	@RequestMapping(value = "/sendevaluation", method = RequestMethod.POST)
	public String sendEvaluation(
			@Valid @ModelAttribute("mosCreateDTO") MosCreateDTOValue mosCreateDTO,
			Model model, HttpSession session) {
		try {
			MosCreateDTO mos = new MosCreateDTO();
			mos.setMosValue(mosCreateDTO.getMosValue());
			mos.setQuestionary((QuestionaryDTO) session
					.getAttribute("questionaryObj"));
			mos.setVideo((VideoDTO) session.getAttribute("videoObj"));
			mos.setScenario((ScenarioDTO) session.getAttribute("scenarioObj"));
			mosFacade.create(mos);
			return "testvidea/thanking";
		} catch (Exception ex) {
			return "testvidea/thanking";
		}
	}

	@RequestMapping(value = "/evaluatemobile", method = RequestMethod.POST)
	public String evaluateMobile(Model model) {
		return "videa/mos";
	}

	@RequestMapping(value = "/sendevaluationmobile", method = RequestMethod.POST)
	public String sendEvaluationMobile(@Valid MosCreateDTOValue mosCreateDTO,
			Model model, HttpSession session) {
		try {
			MosCreateDTO mos = new MosCreateDTO();
			mos.setMosValue(mosCreateDTO.getMosValue());
			mos.setQuestionary((QuestionaryDTO) session
					.getAttribute("questionaryObj"));
			mos.setVideo((VideoDTO) session.getAttribute("videoObj"));
			mos.setScenario((ScenarioDTO) session.getAttribute("scenarioObj"));
			mosFacade.create(mos);
			return "videa/thanking";
		} catch (Exception ex) {
			return "videa/thanking";
		}
	}

}
