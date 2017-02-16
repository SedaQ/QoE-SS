package com.seda.qoe.facade;

import java.util.List;

import com.seda.qoe.dto.mos.MosDTO;

public interface MosFacade {

	/**
	 * finds specific mos by id
	 * 
	 * @param id
	 *            of a mos that would be returned
	 * @return specific mos by id
	 */
	public MosDTO getMosById(Long id);

	/**
	 * updates given mos
	 * 
	 * @param mosId
	 *            mos that has to be updated
	 * @return updated mos
	 */
	public MosDTO update(Long mosId);

	/**
	 * removes given mos
	 * 
	 * @param mosId
	 *            mos that has to be removed
	 * @return true, if successfully removed
	 */
	public Boolean deleteMos(Long mosId);

	/**
	 * Returns all mos in qoe
	 * 
	 * @return List of mos which are in qoe DB
	 */
	public List<MosDTO> getAllMos();
}
