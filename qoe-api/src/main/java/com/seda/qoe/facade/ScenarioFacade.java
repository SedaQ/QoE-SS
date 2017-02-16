package com.seda.qoe.facade;

import java.util.List;

import com.seda.qoe.dto.scenario.ScenarioDTO;

public interface ScenarioFacade {

	/**
	 * finds specific Scenario by id
	 * 
	 * @param id
	 *            of a Scenario that would be returned
	 * @return specific Scenario by id
	 */
	public ScenarioDTO getScenarioById(Long id);

	/**
	 * updates given Scenario
	 * 
	 * @param ScenarioId
	 *            Scenario that has to be updated
	 * @return updated Scenario
	 */
	public ScenarioDTO update(Long scenarioId);

	/**
	 * removes given Scenario
	 * 
	 * @param ScenarioId
	 *            Scenario that has to be removed
	 * @return true, if successfully removed
	 */
	public Boolean deleteScenario(Long scenarioId);

	/**
	 * Returns all Scenario in qoe
	 * 
	 * @return List of Scenario which are in qoe DB
	 */
	public List<ScenarioDTO> getAllScenario();
}
