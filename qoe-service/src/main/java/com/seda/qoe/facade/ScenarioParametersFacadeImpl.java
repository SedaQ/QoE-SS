package com.seda.qoe.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.seda.qoe.dto.scenarioparameters.ScenarioParametersCreateDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.entity.ScenarioParameters;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.ScenarioParametersService;

@Service
@Transactional
public class ScenarioParametersFacadeImpl implements ScenarioParametersFacade {

	private ScenarioParametersService scenarioParametersService;
	private BeanMapping beanMapping;

	@Inject
	public ScenarioParametersFacadeImpl(
			ScenarioParametersService scenarioParametersService,
			BeanMapping beanMapping) {
		this.scenarioParametersService = scenarioParametersService;
		this.beanMapping = beanMapping;
	}

	@Override
	public ScenarioParametersDTO getScenarioParametersById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Id parameter is null");
		try {
			ScenarioParameters scenarioParameters = scenarioParametersService.findById(id);
			return scenarioParameters != null ? beanMapping.mapTo(scenarioParameters, ScenarioParametersDTO.class) : null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public ScenarioParametersDTO update(Long scenarioParametersId) {
		if (scenarioParametersId == null)
			throw new IllegalArgumentException(
					"scenarioParametersId parameter is null in update method");
		try {
			ScenarioParameters scenarioParameters = scenarioParametersService.update(scenarioParametersService.findById(scenarioParametersId));
			return scenarioParameters != null ? beanMapping.mapTo(scenarioParameters, ScenarioParametersDTO.class) : null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean deleteScenarioParameters(Long scenarioParametersId) {
		if (scenarioParametersId == null)
			throw new IllegalArgumentException("scenarioParametersId parameter is null in deleteUser method");
		try {
			scenarioParametersService.remove(scenarioParametersService.findById(scenarioParametersId));
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public List<ScenarioParametersDTO> getAllScenarioParameters(String search) {
		try {
			return beanMapping.mapTo(scenarioParametersService.findAll(search), ScenarioParametersDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}

	@Override
	public ScenarioParametersDTO create(
			ScenarioParametersCreateDTO scenarioparameters) {
		if (scenarioparameters == null)
			throw new IllegalArgumentException(
					"ScenarioParametersCreateDTO scenarioparameters parameter is null");
		try {
			ScenarioParameters s = scenarioParametersService.create(beanMapping.mapTo(scenarioparameters, ScenarioParameters.class));
			return s != null ? beanMapping.mapTo(s, ScenarioParametersDTO.class): null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

}
