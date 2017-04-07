package cz.vutbr.feec.seda.facade;

import java.util.List;

import cz.vutbr.feec.seda.dto.questionary.QuestionaryCreateDTO;
import cz.vutbr.feec.seda.dto.questionary.QuestionaryDTO;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface QuestionaryFacade {

	/**
	 * create new questionary in database
	 * 
	 * @param questionary
	 *            specific Questionary to be created
	 * @return created questionary
	 */
	public QuestionaryDTO create(QuestionaryCreateDTO questionary);

	/**
	 * finds specific Questionary by id
	 * 
	 * @param id
	 *            of a Questionary that would be returned
	 * @return specific Questionary by id
	 */
	public QuestionaryDTO getQuestionaryById(Long id);

	/**
	 * updates given Questionary
	 * 
	 * @param QuestionaryId
	 *            Questionary that has to be updated
	 * @return updated Questionary
	 */
	public QuestionaryDTO update(Long questionaryId);

	/**
	 * removes given Questionary
	 * 
	 * @param QuestionaryId
	 *            Questionary that has to be removed
	 * @return true, if successfully removed
	 */
	public Boolean deleteQuestionary(Long questionaryId);

	/**
	 * Returns all Questionary in qoe
	 * 
	 * @return List of Questionary which are in qoe DB
	 */
	public List<QuestionaryDTO> getAllQuestionary(String search);
	
	/**
	 * 
	 * @param searchTerm
	 * @return
	 */
	public List<QuestionaryDTO> findBySearchTerm(String searchTerm);
}
