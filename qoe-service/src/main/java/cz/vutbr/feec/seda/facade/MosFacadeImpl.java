package cz.vutbr.feec.seda.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import cz.vutbr.feec.seda.dto.mos.MosCreateDTO;
import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.entity.Mos;
import cz.vutbr.feec.seda.exceptions.ServiceLayerException;
import cz.vutbr.feec.seda.facade.MosFacade;
import cz.vutbr.feec.seda.mapping.BeanMapping;
import cz.vutbr.feec.seda.service.MosService;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Service
@Transactional
public class MosFacadeImpl implements MosFacade {

	private MosService mosService;
	private BeanMapping beanMapping;

	@Inject
	public MosFacadeImpl(MosService mosService, BeanMapping beanMapping) {
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
	public List<MosDTO> getAllMos(String search) {
		try {
			return beanMapping.mapTo(mosService.findAll(search), MosDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}

	@Override
	public MosDTO create(MosCreateDTO mos) {
		if (mos == null)
			throw new IllegalArgumentException(
					"MosCreateDTO mos parameter is null");
		try {
			Mos mosTemp = mosService.create(beanMapping.mapTo(mos, Mos.class));
			return mosTemp != null ? beanMapping.mapTo(mosTemp, MosDTO.class): null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

}
