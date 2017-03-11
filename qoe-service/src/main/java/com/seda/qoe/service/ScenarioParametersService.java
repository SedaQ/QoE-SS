package com.seda.qoe.service;

import java.util.List;

import com.seda.qoe.entity.ScenarioParameters;


/**
 * @author Pavel Šeda (441048)
 *
 */
public interface ScenarioParametersService {

	/**
	 * create new scenarioparameters in database
	 * 
	 * @param scenarioparameters
	 *            specific ScenarioParameters to be created
	 * @return created scenarioparameters
	 */
	public ScenarioParameters create(ScenarioParameters scenarioparameters);
	
	/**
	 * finds specific ScenarioParameters by id
	 * 
	 * @param id
	 *            of a ScenarioParameters that would be returned
	 * @return specific ScenarioParameters by id
	 */
	public ScenarioParameters findById(Long id);

	/**
	 * Returns all ScenarioParameters in language school
	 * 
	 * @return List of ScenarioParameters which are in language school
	 */
	public List<ScenarioParameters> findAll(String search);

	/**
	 * updates given ScenarioParameters
	 * 
	 * @param c
	 *            ScenarioParameters that has to be updated
	 * @return updated ScenarioParameters
	 */
	public ScenarioParameters update(ScenarioParameters c);

	/**
	 * removes given ScenarioParameters
	 * 
	 * @param c
	 *            ScenarioParameters that has to be removed
	 */
	public void remove(ScenarioParameters c);
	
}
