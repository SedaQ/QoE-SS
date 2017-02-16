package com.seda.qoe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.seda.qoe.dao.ScenarioParametersRepository;
import com.seda.qoe.entity.ScenarioParameters;
import com.seda.qoe.exceptions.ServiceLayerException;

/**
 * @author Pavel Šeda
 *
 */
@Service
public class ScenarioParametersServiceImpl implements ScenarioParametersService {

	private ScenarioParametersRepository scenarioParametersDao;
	
	@Inject
	public ScenarioParametersServiceImpl(ScenarioParametersRepository scenarioParametersDao){
		this.scenarioParametersDao = scenarioParametersDao;
	}
	
	@Override
	public ScenarioParameters findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return scenarioParametersDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding ScenarioParameters, see inner exception.", ex);
		}
	}

	@Override
	public List<ScenarioParameters> findAll() {
		try {
			return scenarioParametersDao.findAll();
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding ScenarioParameters, see inner exception.", ex);
		}
	}

	@Override
	public ScenarioParameters update(ScenarioParameters c) {
		if (c == null)
			throw new IllegalArgumentException("ScenarioParameters c parameter is null");
		try {
			return scenarioParametersDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating ScenarioParameters, see inner exception.", ex);
		}
	}

	@Override
	public void remove(ScenarioParameters c) {
		if (c == null)
			throw new IllegalArgumentException("ScenarioParameters c parameter is null");
		try {
			scenarioParametersDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting ScenarioParameters, see inner exception.", ex);
		}
	}

}
