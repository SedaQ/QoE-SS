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
import com.seda.qoe.dto.scenario.ScenarioCreateDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.entity.Scenario;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.ScenarioService;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ScenarioFacadeTest extends AbstractTestNGSpringContextTests {

	@Mock
	private ScenarioService mosService;
	@Mock
	private BeanMapping beanMapping;

	private ScenarioFacade mosFacade;
	private ScenarioDTO mosDTO;
	private ScenarioCreateDTO mosCreateDTO;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		doReturn(new Scenario()).when(beanMapping).mapTo(
				any(ScenarioDTO.class), eq(Scenario.class));

		mosFacade = new ScenarioFacadeImpl(mosService, beanMapping);
	}

	@BeforeMethod
	public void beforeMethod() {
		mosDTO = new ScenarioDTO();
		mosCreateDTO = new ScenarioCreateDTO();
	}

	@AfterMethod
	public void afterMethod() {
		reset(mosService);
	}

	@Test
	public void testCreate() {
		mosFacade.create(mosCreateDTO);
		verify(mosService, times(1)).create(
				beanMapping.mapTo(mosCreateDTO, Scenario.class));
	}

	@Test
	public void testUpdate() {
		mosFacade.update(1L);
		verify(mosService, times(1)).update(any(Scenario.class));
	}

	@Test
	public void testFindById() {
		mosFacade.getScenarioById(Long.MAX_VALUE);
		verify(mosService, times(1)).findById(any(Long.class));
	}

	@Test
	public void testFindAll() {
		mosFacade.getAllScenario("");
		verify(mosService, times(1)).findAll(any(String.class));
	}

	@Test
	public void testRemove() {
		mosFacade.deleteScenario(Long.MAX_VALUE);
		verify(mosService, times(1)).remove(any(Scenario.class));
	}
}
