package cz.vutbr.feec.seda.facade;

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


import cz.vutbr.feec.seda.config.BeanMappingConfiguration;
import cz.vutbr.feec.seda.dto.scenarioparameters.ScenarioParametersCreateDTO;
import cz.vutbr.feec.seda.dto.scenarioparameters.ScenarioParametersDTO;
import cz.vutbr.feec.seda.entity.ScenarioParameters;
import cz.vutbr.feec.seda.facade.ScenarioParametersFacade;
import cz.vutbr.feec.seda.facade.ScenarioParametersFacadeImpl;
import cz.vutbr.feec.seda.mapping.BeanMapping;
import cz.vutbr.feec.seda.service.ScenarioParametersService;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ScenarioParametersFacadeTest extends
		AbstractTestNGSpringContextTests {

	@Mock
	private ScenarioParametersService scenarioParametersService;
	@Mock
	private BeanMapping beanMapping;

	private ScenarioParametersFacade scenarioParametersFacade;
	private ScenarioParametersDTO scenarioParametersDTO;
	private ScenarioParametersCreateDTO scenarioParametersCreateDTO;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		doReturn(new ScenarioParameters()).when(beanMapping).mapTo(
				any(ScenarioParametersDTO.class), eq(ScenarioParameters.class));
		scenarioParametersFacade = new ScenarioParametersFacadeImpl(scenarioParametersService, beanMapping);
	}

	@BeforeMethod
	public void beforeMethod() {
		scenarioParametersDTO = new ScenarioParametersDTO();
		scenarioParametersCreateDTO = new ScenarioParametersCreateDTO();
	}

	@AfterMethod
	public void afterMethod() {
		reset(scenarioParametersService);
	}

	@Test
	public void testCreate() {
		scenarioParametersFacade.create(scenarioParametersCreateDTO);
		verify(scenarioParametersService, times(1)).create(
				beanMapping.mapTo(scenarioParametersCreateDTO, ScenarioParameters.class));
	}

	@Test
	public void testUpdate() {
		scenarioParametersFacade.update(1L);
		verify(scenarioParametersService, times(1)).update(any(ScenarioParameters.class));
	}

	@Test
	public void testFindById() {
		scenarioParametersFacade.getScenarioParametersById(Long.MAX_VALUE);
		verify(scenarioParametersService, times(1)).findById(any(Long.class));
	}

	@Test
	public void testFindAll() {
		scenarioParametersFacade.getAllScenarioParameters("");
		verify(scenarioParametersService, times(1)).findAll(any(String.class));
	}

	@Test
	public void testRemove() {
		scenarioParametersFacade.deleteScenarioParameters(Long.MAX_VALUE);
		verify(scenarioParametersService, times(1)).remove(any(ScenarioParameters.class));
	}
}