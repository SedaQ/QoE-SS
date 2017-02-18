package com.seda.qoe.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.seda.qoe.dto.scenario.ScenarioCreateDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.entity.Scenario;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.ScenarioService;

@Service
@Transactional
public class ScenarioFacadeImpl implements ScenarioFacade {

	private ScenarioService scenarioService;
	private BeanMapping beanMapping;
	
	@Inject
	public ScenarioFacadeImpl(ScenarioService scenarioService, BeanMapping beanMapping){
		this.scenarioService = scenarioService;
		this.beanMapping = beanMapping;
	}
	
	@Override
	public ScenarioDTO getScenarioById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Id parameter is null");
		try {
			Scenario scenario = scenarioService.findById(id);
			return scenario != null ? beanMapping.mapTo(scenario, ScenarioDTO.class) : null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public ScenarioDTO update(Long scenarioId) {
		if (scenarioId == null)
			throw new IllegalArgumentException(
					"scenarioId parameter is null in update method");
		try {
			Scenario scenario = scenarioService.update(scenarioService.findById(scenarioId));
			return scenario != null ? beanMapping.mapTo(scenario, ScenarioDTO.class) : null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean deleteScenario(Long scenarioId) {
		if (scenarioId == null)
			throw new IllegalArgumentException(
					"scenarioId parameter is null in deleteUser method");
		try {
			scenarioService.remove(scenarioService.findById(scenarioId));
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public List<ScenarioDTO> getAllScenario() {
		try {
			return beanMapping.mapTo(scenarioService.findAll(), ScenarioDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}

	@Override
	public ScenarioDTO create(ScenarioCreateDTO scenario) {
		if (scenario == null)
			throw new IllegalArgumentException(
					"ScenarioCreateDTO scenario parameter is null");
		try {
			Scenario s = scenarioService.create(beanMapping.mapTo(scenario, Scenario.class));
			return s != null ? beanMapping.mapTo(s, ScenarioDTO.class): null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

}
