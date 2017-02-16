package com.seda.qoe.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.entity.Mos;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.MosService;

@Service
@Transactional
public class MosFacadeImpl implements MosFacade {

	private MosService mosService;
	private BeanMapping beanMapping;
	
	@Inject
	public MosFacadeImpl(MosService mosService, BeanMapping beanMapping){
		this.mosService = mosService;
		this.beanMapping = beanMapping;
	}
	
	@Override
	public MosDTO getMosById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Id parameter is null");
		try {
			Mos mos = mosService.findById(id);
			return mos != null ? beanMapping.mapTo(mos, MosDTO.class) : null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public MosDTO update(Long mosId) {
		if (mosId == null)
			throw new IllegalArgumentException(
					"userId parameter is null in update method");
		try {
			Mos mos = mosService.update(mosService.findById(mosId));
			return mos != null ? beanMapping.mapTo(mos, MosDTO.class) : null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean deleteMos(Long mosId) {
		if (mosId == null)
			throw new IllegalArgumentException(
					"userId parameter is null in deleteUser method");
		try {
			mosService.remove(mosService.findById(mosId));
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public List<MosDTO> getAllMos() {
		try {
			return beanMapping.mapTo(mosService.findAll(), MosDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}

}
