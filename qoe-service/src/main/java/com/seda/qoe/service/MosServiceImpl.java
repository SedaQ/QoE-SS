package com.seda.qoe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.seda.qoe.dao.MosRepository;
import com.seda.qoe.entity.Mos;
import com.seda.qoe.exceptions.ServiceLayerException;

/**
 * @author Pavel Šeda
 *
 */
@Service
public class MosServiceImpl implements MosService{

	private MosRepository mosDao;
	
	@Inject
	public MosServiceImpl(MosRepository mosDao){
		this.mosDao = mosDao;
	}
	
	@Override
	public Mos findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return mosDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Mos, see inner exception.", ex);
		}
	}

	@Override
	public List<Mos> findAll() {
		try {
			return mosDao.findAll();
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Mos, see inner exception.", ex);
		}
	}

	@Override
	public Mos update(Mos c) {
		if (c == null)
			throw new IllegalArgumentException("Mos c parameter is null");
		try {
			return mosDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating Mos, see inner exception.", ex);
		}
	}

	@Override
	public void remove(Mos c) {
		if (c == null)
			throw new IllegalArgumentException("Mos c parameter is null");
		try {
			mosDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting Mos, see inner exception.", ex);
		}
	}

	@Override
	public Mos create(Mos mos) {
		if (mos == null)
			throw new IllegalArgumentException("mos parameter is null");
		try {
			mosDao.save(mos);
			return mos;
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating mos, see inner exception.", ex);
		}
	}

}
