package cz.vutbr.feec.seda.facade;

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
import cz.vutbr.feec.seda.dto.mos.MosCreateDTO;
import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.entity.Mos;
import cz.vutbr.feec.seda.facade.MosFacade;
import cz.vutbr.feec.seda.facade.MosFacadeImpl;
import cz.vutbr.feec.seda.mapping.BeanMapping;
import cz.vutbr.feec.seda.service.MosService;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ContextConfiguration(classes = BeanMappingConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MosFacadeTest extends AbstractTestNGSpringContextTests {

	@Mock
	private MosService mosService;
	@Mock
	private BeanMapping beanMapping;

	private MosFacade mosFacade;
	private MosDTO mosDTO;
	private MosCreateDTO mosCreateDTO;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		doReturn(new Mos()).when(beanMapping).mapTo(any(MosDTO.class),
				eq(Mos.class));

		mosFacade = new MosFacadeImpl(mosService, beanMapping);
	}

	@BeforeMethod
	public void beforeMethod() {
		mosDTO = new MosDTO();
		mosCreateDTO = new MosCreateDTO();
	}

	@AfterMethod
	public void afterMethod() {
		reset(mosService);
	}

	@Test
	public void testCreate() {
		mosFacade.create(mosCreateDTO);
		verify(mosService, times(1)).create(any(Mos.class));
	}

	@Test
	public void testUpdate() {
		mosFacade.update(1L);
		verify(mosService, times(1)).update(any(Mos.class));
	}

	@Test
	public void testFindById() {
		mosFacade.getMosById(Long.MAX_VALUE);
		verify(mosService, times(1)).findById(any(Long.class));
	}

	@Test
	public void testFindAll() {
		mosFacade.getAllMos("");
		verify(mosService, times(1)).findAll(any(String.class));
	}

	@Test
	public void testRemove() {
		mosFacade.deleteMos(Long.MAX_VALUE);
		verify(mosService, times(1)).remove(any(Mos.class));
	}
}