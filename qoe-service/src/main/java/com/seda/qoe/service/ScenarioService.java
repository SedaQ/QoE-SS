package com.seda.qoe.service;

import java.util.List;

import com.seda.qoe.entity.Scenario;

/**
 * @author Pavel Šeda
 *
 */
public interface ScenarioService {

	/**
	 * finds specific Scenario by id
	 * 
	 * @param id
	 *            of a Scenario that would be returned
	 * @return specific Scenario by id
	 */
	public Scenario findById(Long id);

	/**
	 * Returns all Scenario in language school
	 * 
	 * @return List of Scenario which are in language school
	 */
	public List<Scenario> findAll();

	/**
	 * updates given Scenario
	 * 
	 * @param c
	 *            Scenario that has to be updated
	 * @return updated Scenario
	 */
	public Scenario update(Scenario c);

	/**
	 * removes given Scenario
	 * 
	 * @param c
	 *            Scenario that has to be removed
	 */
	public void remove(Scenario c);
	
}
