package com.seda.qoe.facade;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.config.BeanMappingConfiguration;
import com.seda.qoe.dto.questionary.QuestionaryCreateDTO;
import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.entity.Questionary;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.QuestionaryService;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class QuestionaryFacadeTest extends AbstractTestNGSpringContextTests {

	@Mock
	private QuestionaryService questionaryService;
	@Mock
	private BeanMapping beanMapping;

	private QuestionaryFacade questionaryFacade;
	private QuestionaryDTO questionaryDTO;
	private QuestionaryCreateDTO questionaryCreateDTO;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		doReturn(new Questionary()).when(beanMapping).mapTo(
				any(QuestionaryDTO.class), eq(Questionary.class));

		questionaryFacade = new QuestionaryFacadeImpl(questionaryService,
				beanMapping);
	}

	@BeforeMethod
	public void beforeMethod() {
		questionaryDTO = new QuestionaryDTO();
		questionaryCreateDTO = new QuestionaryCreateDTO();
	}

	@AfterMethod
	public void afterMethod() {
		reset(questionaryService);
	}

	@Test
	public void testCreate() {
		questionaryFacade.create(questionaryCreateDTO);
		verify(questionaryService, times(1)).create(
				beanMapping.mapTo(questionaryCreateDTO, Questionary.class));
	}

	@Test
	public void testUpdate() {
		questionaryFacade.update(1L);
		verify(questionaryService, times(1)).update(any(Questionary.class));
	}

	@Test
	public void testFindById() {
		questionaryFacade.getQuestionaryById(Long.MAX_VALUE);
		verify(questionaryService, times(1)).findById(any(Long.class));
	}

	@Test
	public void testFindAll() {
		questionaryFacade.getAllQuestionary("");
		verify(questionaryService, times(1)).findAll(any(String.class));
	}

	@Test
	public void testRemove() {
		questionaryFacade.deleteQuestionary(Long.MAX_VALUE);
		verify(questionaryService, times(1)).remove(any(Questionary.class));
	}
}