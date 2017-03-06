package com.seda.qoe.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.seda.qoe.dto.questionary.QuestionaryCreateDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.facade.QuestionaryFacade;
import com.seda.qoe.facade.VideoFacade;
import com.seda.qoe.utils.SortVideoSources;

/**
 * @author Pavel Šeda (441048)
 * 
 */
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
		QuestionaryDTO questionary = null;
		try {
			questionary = questionaryFacade.create(formBean);
		} catch (Exception ex) {
		}
		VideoDTO video = videoFacade.findRandomVideo();
		model.addAttribute("questionaryObj", questionary);
		model.addAttribute("videoObj", video);
		model.addAttribute("videoSources", video.getVideoSource());
		ScenarioDTO scenario = video.getScenario().get(
				(int) Math.random() * video.getScenario().size());
		model.addAttribute("scenarioObj", scenario);
		model.addAttribute("videoSources",
				SortVideoSources.sortVideoSources(video.getVideoSource()));
		model.addAttribute("videoScenarioParameters",
				scenario.getScenarioparameters());
		// System.out.println("Sourted video sources are..: " +
		// Arrays.toString(SortVideoSources.sortVideoSources(video.getVideoSource()).toArray()));
		// System.out.println("Questionary id:" + questionary.getId());
		// System.out.println("ID videa je: " + video.getId());
		// System.out.println("Scenario id je: "
		// + video.getScenario()
		// .get((int) Math.random() * video.getScenario().size())
		// .getId());
		return "testvidea/video";
	}

	@RequestMapping(value = "/retesting", method = RequestMethod.GET)
	public String retesting(Model model, HttpSession session) {
		VideoDTO video = videoFacade.findRandomVideo();
		session.removeAttribute("videoObj");
		session.removeAttribute("scenarioObj");
		model.addAttribute("videoObj", video);
		ScenarioDTO scenario = video.getScenario().get(
				(int) Math.random() * video.getScenario().size());
		model.addAttribute("scenarioObj", scenario);
		model.addAttribute("videoSources", video.getVideoSource());
		model.addAttribute("videoScenarioParameters",
				scenario.getScenarioparameters());

		// System.out.println("Id videa je: " + video.getId());
		// System.out.println("Name scenaria je: " + scenario.getScenario());
		return "testvidea/video";
	}

	@RequestMapping(value = "/mobilevideo/{id}", method = RequestMethod.GET)
	public String mobileVideo(@PathVariable("id") long id, Model model) {
		VideoDTO video = videoFacade.findRandomVideo();
		model.addAttribute("questionaryObj",
				questionaryFacade.getQuestionaryById(id));
		model.addAttribute("videoObj", video);
		model.addAttribute("videoSources", video.getVideoSource());
		ScenarioDTO scenario = video.getScenario().get(
				(int) Math.random() * video.getScenario().size());
		model.addAttribute("scenarioObj", scenario);
		model.addAttribute("videoSources",
				SortVideoSources.sortVideoSources(video.getVideoSource()));
		model.addAttribute("videoScenarioParameters",
				scenario.getScenarioparameters());
		return "videa/video";
	}

	@RequestMapping(value = "/mobileretesting", method = RequestMethod.GET)
	public String mobileRetesting(Model model, HttpSession session) {
		VideoDTO video = videoFacade.findRandomVideo();
		session.removeAttribute("videoObj");
		session.removeAttribute("scenarioObj");
		model.addAttribute("videoObj", video);
		ScenarioDTO scenario = video.getScenario().get(
				(int) Math.random() * video.getScenario().size());
		model.addAttribute("scenarioObj", scenario);
		model.addAttribute("videoSources", video.getVideoSource());
		model.addAttribute("videoScenarioParameters",
				scenario.getScenarioparameters());

		return "videa/video";
	}
}
