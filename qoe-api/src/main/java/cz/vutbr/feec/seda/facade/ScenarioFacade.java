package cz.vutbr.feec.seda.facade;

import java.util.List;

import cz.vutbr.feec.seda.dto.scenario.ScenarioCreateDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface ScenarioFacade {

	/**
	 * create new scenario in database
	 * 
	 * @param scenario
	 *            specific Scenario to be created
	 * @return created scenario
	 */
	public ScenarioDTO create(ScenarioCreateDTO scenario);

	
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
	public List<ScenarioDTO> getAllScenario(String search);
}
