package com.seda.qoe.rest.controllers;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.seda.qoe.config.SpringMVCConfig;
import com.seda.qoe.dto.questionary.QuestionaryCreateDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.facade.QuestionaryFacade;
import com.seda.qoe.rest.controllers.hateos.QuestionariesRestHateosController;
import com.seda.qoe.rest.endpoints.ApiEndPoints;

@WebAppConfiguration
@ContextConfiguration(classes = { SpringMVCConfig.class })
public class QuestionariesRestHateosControllerTest extends
		AbstractTestNGSpringContextTests {

	@Mock
	private QuestionaryFacade questionaryFacade;

	@Autowired
	@InjectMocks
	private QuestionariesRestHateosController questionariesRestHateosController;

	private QuestionaryDTO questionaryDTO;

	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(questionariesRestHateosController)
				.setMessageConverters(new MappingJackson2HttpMessageConverter())
				.build();
		questionaryDTO = new QuestionaryDTO();
		questionaryDTO.setId(1L);
		questionaryDTO.setDate(new Date());
		questionaryDTO.setEmail("testrest@seznam.cz");
		questionaryDTO.setGender("muz");
		questionaryDTO.setSchool("zakladni_skola");
		questionaryDTO.setUserConnection("mobilni_data");
	}

	@Test
	public void createQuestionary() throws Exception {
		QuestionaryCreateDTO questionary = new QuestionaryCreateDTO();
		questionary.setEmail("pavelseda@email.cz");

		doReturn(questionaryDTO).when(questionaryFacade).create(
				any(QuestionaryCreateDTO.class));

		String json = convertObjectToJsonBytes(questionary);

		mockMvc.perform(
				post(ApiEndPoints.ROOT_URI_QUESTIONARY_HATEOS).contentType(
						MediaType.APPLICATION_JSON).content(json))
				.andExpect(status().isOk())
				.andExpect(
						content().contentTypeCompatibleWith(
								MediaType.APPLICATION_JSON_VALUE))
				.andExpect(
						jsonPath("$.[?(@.id==1)].email").value(
								"testrest@seznam.cz"));
	}

	@Test
	public void getAllQuestionaries() throws Exception {
		doReturn(Collections.unmodifiableList(this.createQuestionaries()))
				.when(questionaryFacade).getAllQuestionary(any(String.class));

		mockMvc.perform(get(ApiEndPoints.ROOT_URI_QUESTIONARY_HATEOS))
				.andExpect(status().isOk())
				.andExpect(
						content().contentTypeCompatibleWith(
								MediaType.APPLICATION_JSON_VALUE));
	}

	private List<QuestionaryDTO> createQuestionaries() {
		QuestionaryDTO questionary1 = new QuestionaryDTO();
		questionary1.setId(1L);
		questionary1.setAge("26");
		questionary1.setDate(new Date());
		questionary1.setEmail("testemailRestTests@seznam.cz");
		questionary1.setGender("muz");
		questionary1.setSchool("zakladni_skola");
		questionary1.setUserConnection("mobilni_data");

		QuestionaryDTO questionary2 = new QuestionaryDTO();
		questionary2.setId(2L);
		questionary2.setAge("21");
		questionary2.setDate(new Date());
		questionary2.setEmail("testemailRestTests@seznam.cz");
		questionary2.setGender("muz");
		questionary2.setSchool("zakladni_skola");
		questionary2.setUserConnection("mobilni_data");

		return Arrays.asList(questionary1, questionary2);
	}

	private static String convertObjectToJsonBytes(Object object)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}

	/**
	 * Registering the GlobalExceptionController if @ControllerAdvice is used
	 * this can be used in SetHandlerExceptionResolvers() standaloneSetup() Note
	 * that new Spring version from 4.2 has already a setControllerAdvice()
	 * method on MockMVC builders, so in that case it is only needed to pass one
	 * or more
	 * 
	 * @ControllerAdvice(s) configured within the application
	 * 
	 * @return
	 */
	private ExceptionHandlerExceptionResolver createExceptionResolver() {
		ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
			protected ServletInvocableHandlerMethod getExceptionHandlerMethod(
					HandlerMethod handlerMethod, Exception exception) {
				Method method = new ExceptionHandlerMethodResolver(
						GlobalExceptionController.class)
						.resolveMethod(exception);
				return new ServletInvocableHandlerMethod(
						new GlobalExceptionController(), method);
			}
		};
		exceptionResolver.getMessageConverters().add(
				new MappingJackson2HttpMessageConverter());
		exceptionResolver.afterPropertiesSet();
		return exceptionResolver;
	}

}
