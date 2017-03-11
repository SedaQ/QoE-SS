package com.seda.qoe.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.jpa.domain.Specification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seda.qoe.dao.ScenarioRepository;
import com.seda.qoe.entity.Scenario;
import com.seda.qoe.entity.ScenarioParameters;

public class ScenarioServiceTest {

	@Mock
	private ScenarioRepository scenarioDao;
	@Mock
	private ScenarioService scenarioService;

	private Scenario scenario1;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		scenarioService = new ScenarioServiceImpl(scenarioDao);
	}

	@BeforeMethod
	public void beforeMethod() {
		scenario1 = new Scenario();
		scenario1.setScenario("scenario1");
		scenario1.addScenarioParameter(new ScenarioParameters());
	}

	@AfterMethod
	public void afterMethod() {
		reset(scenarioDao);
	}

	@Test
	public void testCreate() {
		scenarioService.create(scenario1);
		verify(scenarioDao, times(1)).save(any(Scenario.class));
	}

	@Test
	public void testUpdate() {
		scenarioService.update(scenario1);
		verify(scenarioDao, times(1)).save(any(Scenario.class));
	}

	@Test
	public void testFindById() {
		scenarioService.findById(1L);
		verify(scenarioDao, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindAll() {
		scenarioService.findAll("");
		verify(scenarioDao, times(1)).findAll();
	}

	@Test
	public void testFindAllWithSpec() {
		scenarioService.findAll("age==17");
		verify(scenarioDao, times(1)).findAll(any(Specification.class));
	}

	@Test
	public void testRemove() {
		scenarioService.remove(scenario1);
		verify(scenarioDao, times(1)).delete(any(Scenario.class));
	}
}
