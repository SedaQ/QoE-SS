package com.seda.qoe.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.seda.qoe.dto.questionary.QuestionaryCreateDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.QuestionaryFacade;
import com.seda.qoe.facade.VideoFacade;

@Controller
@RequestMapping("/video")
@SessionAttributes({ "questionaryObj", "videoObj", "scenarioObj" })
public class VideoController {

	@Inject
	private QuestionaryFacade questionaryFacade;
	@Inject
	private VideoFacade videoFacade;

	@RequestMapping(value = "/questionnairefilled", method = RequestMethod.POST)
	public String startTesting(
			@Valid @ModelAttribute("questionaryCreate") QuestionaryCreateDTO formBean,
			BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes,
			UriComponentsBuilder uriBuilder) {
		QuestionaryCreateDTO q = new QuestionaryCreateDTO();
		q.setAge(formBean.getAge());
		q.setEmail(formBean.getEmail());
		q.setGender(formBean.getGender());
		q.setSchool(formBean.getSchool());
		q.setUserConnection(formBean.getUserConnection());
		
		QuestionaryDTO questionary = null;
		try {
//			questionary = questionaryFacade.findByEqualsMethod(formBean.getEmail(), formBean.getGender(), formBean.getAge(), formBean.getSchool(), formBean.getUserConnection());
//			if(questionary == null){
				questionary = questionaryFacade.create(q);
//			}
		} catch (Exception ex) {
			//questionary = questionaryFacade.findByEqualsMethod(formBean.getEmail(), formBean.getGender(), formBean.getAge(), formBean.getSchool(), formBean.getUserConnection());
		}
		VideoDTO video = videoFacade.findRandomVideo();
		model.addAttribute("questionaryObj", questionary);
		model.addAttribute("videoObj", video);
		model.addAttribute(
				"scenarioObj",
				video.getScenario().get(
						(int) Math.random() * video.getScenario().size()));
		model.addAttribute("videoSources", video.getVideoSource());
		//
		// System.out.println("Questionary id:" + questionary.getId());
		// System.out.println("ID videa je: " + video.getId());
		// System.out.println("Scenario id je: " + video.getScenario().get((int)
		// Math.random() * video.getScenario().size()).getId());
		return "testvidea/video";
	}

	@RequestMapping(value = "/startReTesting", method = RequestMethod.GET)
	public String startReTesting(Model model, HttpSession session) {
		VideoDTO video = videoFacade.findRandomVideo();
		session.removeAttribute("videoObj");
		session.removeAttribute("scenarioObj");
		model.addAttribute("videoObj", video);
		model.addAttribute(
				"scenarioObj",
				video.getScenario().get(
						(int) Math.random() * video.getScenario().size()));

		// System.out.println("Atributy po redirection");
		// System.out.println("Questionary id:" + ((QuestionaryDTO)
		// session.getAttribute("questionaryObj")).getId());
		// System.out.println("ID videa je: " + video.getId());
		// System.out.println("Scenario id je: " + video.getScenario().get((int)
		// Math.random() * video.getScenario().size()).getId());
		return "testvidea/video";
	}
}
