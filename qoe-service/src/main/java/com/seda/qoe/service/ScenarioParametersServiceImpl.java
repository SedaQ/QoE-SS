package com.seda.qoe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.seda.qoe.dao.ScenarioParametersRepository;
import com.seda.qoe.entity.ScenarioParameters;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.specification.RsqlVisitor;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;


/**
 * @author Pavel Šeda (441048)
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
	public List<ScenarioParameters> findAll(String search) {
		try {
			if(search !=null && !search.isEmpty()){
				final Node rootNode = new RSQLParser().parse(search);
	            Specification<ScenarioParameters> spec = rootNode.accept(new RsqlVisitor<ScenarioParameters>());
	            return scenarioParametersDao.findAll(spec);
			} else{
				return scenarioParametersDao.findAll();
			}
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

	@Override
	public ScenarioParameters create(ScenarioParameters scenarioparameters) {
		if (scenarioparameters == null)
			throw new IllegalArgumentException("scenarioparameters parameter is null");
		try {
			scenarioParametersDao.save(scenarioparameters);
			return scenarioparameters;
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating scenarioparameters, see inner exception.", ex);
		}
	}

}
