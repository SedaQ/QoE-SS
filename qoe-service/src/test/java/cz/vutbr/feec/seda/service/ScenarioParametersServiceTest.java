package cz.vutbr.feec.seda.service;

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

import cz.vutbr.feec.seda.dao.ScenarioParametersRepository;
import cz.vutbr.feec.seda.entity.ScenarioParameters;
import cz.vutbr.feec.seda.service.ScenarioParametersService;
import cz.vutbr.feec.seda.service.ScenarioParametersServiceImpl;

public class ScenarioParametersServiceTest {
	@Mock
	private ScenarioParametersRepository scenarioparametersDao;
	@Mock
	private ScenarioParametersService scenarioparametersService;

	private ScenarioParameters scenarioparameters1;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		scenarioparametersService = new ScenarioParametersServiceImpl(
				scenarioparametersDao);
	}

	@BeforeMethod
	public void beforeMethod() {
		scenarioparameters1 = new ScenarioParameters();
		scenarioparameters1.setLength(1l);
		scenarioparameters1.setTime(123L);
	}

	@AfterMethod
	public void afterMethod() {
		reset(scenarioparametersDao);
	}

	@Test
	public void testCreate() {
		scenarioparametersService.create(scenarioparameters1);
		verify(scenarioparametersDao, times(1)).save(
				any(ScenarioParameters.class));
	}

	@Test
	public void testUpdate() {
		scenarioparametersService.update(scenarioparameters1);
		verify(scenarioparametersDao, times(1)).save(
				any(ScenarioParameters.class));
	}

	@Test
	public void testFindById() {
		scenarioparametersService.findById(1L);
		verify(scenarioparametersDao, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindAll() {
		scenarioparametersService.findAll("");
		verify(scenarioparametersDao, times(1)).findAll();
	}

	@Test
	public void testFindAllWithSpec() {
		scenarioparametersService.findAll("age==17");
		verify(scenarioparametersDao, times(1)).findAll(
				any(Specification.class));
	}

	@Test
	public void testRemove() {
		scenarioparametersService.remove(scenarioparameters1);
		verify(scenarioparametersDao, times(1)).delete(
				any(ScenarioParameters.class));
	}
}
