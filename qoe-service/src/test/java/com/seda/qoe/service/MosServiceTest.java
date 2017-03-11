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

import com.seda.qoe.dao.MosRepository;
import com.seda.qoe.entity.Mos;

public class MosServiceTest {
	@Mock
	private MosRepository mosDao;
	@Mock
	private MosService mosService;

	private Mos mos;

	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
		mosService = new MosServiceImpl(mosDao);
	}

	@BeforeMethod
	public void beforeMethod() {
		mos = new Mos();
		mos.setMosValue("5");
	}

	@AfterMethod
	public void afterMethod() {
		reset(mosDao);
	}

	@Test
	public void testCreate() {
		mosService.create(mos);
		verify(mosDao, times(1)).save(any(Mos.class));
	}

	@Test
	public void testUpdate() {
		mosService.update(mos);
		verify(mosDao, times(1)).save(any(Mos.class));
	}

	@Test
	public void testFindById() {
		mosService.findById(1L);
		verify(mosDao, times(1)).findOne(any(Long.class));
	}

	@Test
	public void testFindAll() {
		mosService.findAll("");
		verify(mosDao, times(1)).findAll();
	}

	@Test
	public void testFindAllWithSpec() {
		mosService.findAll("age==17");
		verify(mosDao, times(1)).findAll(any(Specification.class));
	}

	@Test
	public void testRemove() {
		mosService.remove(mos);
		verify(mosDao, times(1)).delete(any(Mos.class));
	}
}
