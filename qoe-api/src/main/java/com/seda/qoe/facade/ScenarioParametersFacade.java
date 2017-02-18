package com.seda.qoe.facade;

import java.util.List;

import com.seda.qoe.dto.scenarioparameters.ScenarioParametersCreateDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;

public interface ScenarioParametersFacade {

	/**
	 * create new scenarioparameters in database
	 * 
	 * @param scenarioparameters
	 *            specific ScenarioParameters to be created
	 * @return created scenarioparameters
	 */
	public ScenarioParametersDTO create(ScenarioParametersCreateDTO scenarioparameters);

	
	/**
	 * finds specific ScenarioParameters by id
	 * 
	 * @param id
	 *            of a ScenarioParameters that would be returned
	 * @return specific ScenarioParameters by id
	 */
	public ScenarioParametersDTO getScenarioParametersById(Long id);

	/**
	 * updates given ScenarioParameters
	 * 
	 * @param ScenarioParametersId
	 *            ScenarioParameters that has to be updated
	 * @return updated ScenarioParameters
	 */
	public ScenarioParametersDTO update(Long scenarioParametersId);

	/**
	 * removes given ScenarioParameters
	 * 
	 * @param ScenarioParametersId
	 *            ScenarioParameters that has to be removed
	 * @return true, if successfully removed
	 */
	public Boolean deleteScenarioParameters(Long scenarioParametersId);

	/**
	 * Returns all ScenarioParameters in qoe
	 * 
	 * @return List of ScenarioParameters which are in qoe DB
	 */
	public List<ScenarioParametersDTO> getAllScenarioParameters();
}
