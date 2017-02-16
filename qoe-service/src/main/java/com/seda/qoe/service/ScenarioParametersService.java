package com.seda.qoe.service;

import java.util.List;

import com.seda.qoe.entity.ScenarioParameters;

/**
 * @author Pavel Šeda
 *
 */
public interface ScenarioParametersService {

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
	public List<ScenarioParameters> findAll();

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
