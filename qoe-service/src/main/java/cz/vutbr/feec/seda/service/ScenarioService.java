package cz.vutbr.feec.seda.service;

import java.util.List;

import cz.vutbr.feec.seda.entity.Scenario;


/**
 * @author Pavel Šeda (441048)
 *
 */
public interface ScenarioService {

	/**
	 * create new scenario in database
	 * 
	 * @param scenario
	 *            specific Scenario to be created
	 * @return created scenario
	 */
	public Scenario create(Scenario scenario);
	
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
	public List<Scenario> findAll(String search);

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
