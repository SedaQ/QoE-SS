package com.seda.qoe.service;

import java.util.List;

import com.seda.qoe.entity.Questionary;

/**
 * @author Pavel Šeda
 *
 */
public interface QuestionaryService {
	
	/**
	 * finds specific Questionary by id
	 * 
	 * @param id
	 *            of a Questionary that would be returned
	 * @return specific Questionary by id
	 */
	public Questionary findById(Long id);

	/**
	 * Returns all Questionary in language school
	 * 
	 * @return List of Questionary which are in language school
	 */
	public List<Questionary> findAll();

	/**
	 * updates given Questionary
	 * 
	 * @param c
	 *            Questionary that has to be updated
	 * @return updated Questionary
	 */
	public Questionary update(Questionary c);

	/**
	 * removes given Questionary
	 * 
	 * @param c
	 *            Questionary that has to be removed
	 */
	public void remove(Questionary c);
}
