package com.seda.qoe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.seda.qoe.dao.QuestionaryRepository;
import com.seda.qoe.entity.Questionary;
import com.seda.qoe.exceptions.ServiceLayerException;

/**
 * @author Pavel Šeda
 *
 */
@Service
public class QuestionaryServiceImpl implements QuestionaryService {

	private QuestionaryRepository questionaryDao;
	
	@Inject
	public QuestionaryServiceImpl(QuestionaryRepository questionaryDao){
		this.questionaryDao = questionaryDao;
	}
	
	@Override
	public Questionary findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return questionaryDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Questionary, see inner exception.", ex);
		}
	}

	@Override
	public List<Questionary> findAll() {
		try {
			return questionaryDao.findAll();
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Questionary, see inner exception.", ex);
		}
	}

	@Override
	public Questionary update(Questionary c) {
		if (c == null)
			throw new IllegalArgumentException("Questionary c parameter is null");
		try {
			return questionaryDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating Questionary, see inner exception.", ex);
		}
	}

	@Override
	public void remove(Questionary c) {
		if (c == null)
			throw new IllegalArgumentException("Questionary c parameter is null");
		try {
			questionaryDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting Questionary, see inner exception.", ex);
		}
	}

	@Override
	public Questionary create(Questionary questionary) {
		if (questionary == null)
			throw new IllegalArgumentException("questionary parameter is null");
		try {
			Questionary q = questionaryDao.save(questionary);
			return questionaryDao.findByEmail(q.getEmail());
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating questionary, see inner exception.", ex);
		}
	}

}
