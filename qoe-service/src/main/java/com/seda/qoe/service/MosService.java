package com.seda.qoe.service;

import java.util.List;

import com.seda.qoe.entity.Mos;

/**
 * @author Pavel Šeda
 *
 */
public interface MosService {

	/**
	 * create new mos in database
	 * 
	 * @param mos
	 *            specific Mos to be created
	 * @return created mos
	 */
	public Mos create(Mos mos);
	
	/**
	 * finds specific mos by id
	 * 
	 * @param id
	 *            of a mos that would be returned
	 * @return specific mos by id
	 */
	public Mos findById(Long id);

	/**
	 * Returns all mos in language school
	 * 
	 * @return List of mos which are in language school
	 */
	public List<Mos> findAll(String search);

	/**
	 * updates given mos
	 * 
	 * @param c
	 *            mos that has to be updated
	 * @return updated mos
	 */
	public Mos update(Mos c);

	/**
	 * removes given mos
	 * 
	 * @param c
	 *            mos that has to be removed
	 */
	public void remove(Mos c);
	
}
