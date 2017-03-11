package com.seda.qoe.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.dao.QuestionaryRepository;
import com.seda.qoe.entity.Questionary;

public class QuestionaryServiceTest {
	@Mock
	private QuestionaryRepository questionaryDao;
	@Mock
	private QuestionaryService questionaryService;

	private Questionary questionary;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		questionaryService = new QuestionaryServiceImpl(questionaryDao);
	}

	@BeforeMethod
	public void beforeMethod() {
		questionary = new Questionary();
		questionary.setAge("12");
		questionary.setDate(new Date());
		questionary.setEmail("pavelseda@eeeeeeeeetest.cz");
		questionary.setGender("muz");
		questionary.setSchool("stredni_skola");
		questionary.setUserConnection("wifi_pripojeni");
	}

	@AfterMethod
	public void afterMethod() {
		reset(questionaryDao);
	}

	@Test
	public void testCreate() {
		questionaryService.create(questionary);
		verify(questionaryDao, times(1)).save(any(Questionary.class));
	}

	@Test
	public void testUpdate() {
		questionaryService.update(questionary);
		verify(questionaryDao, times(1)).save(any(Questionary.class));
	}

	@Test
	public void testFindById() {
		questionaryService.findById(1L);
		verify(questionaryDao, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindAll() {
		questionaryService.findAll("");
		verify(questionaryDao, times(1)).findAll();
	}

	@Test
	public void testFindAllWithSpec() {
		questionaryService.findAll("age==17");
		verify(questionaryDao, times(1)).findAll(any(Specification.class));
	}

	@Test
	public void testRemove() {
		questionaryService.remove(questionary);
		verify(questionaryDao, times(1)).delete(any(Questionary.class));
	}
}
