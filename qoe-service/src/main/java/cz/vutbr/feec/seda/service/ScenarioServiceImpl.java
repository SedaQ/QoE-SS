package cz.vutbr.feec.seda.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.vutbr.feec.seda.dao.ScenarioRepository;
import cz.vutbr.feec.seda.entity.Scenario;
import cz.vutbr.feec.seda.exceptions.ServiceLayerException;
import cz.vutbr.feec.seda.specification.RsqlVisitor;


/**
 * @author Pavel Šeda (441048)
 *
 */
@Service
public class ScenarioServiceImpl implements ScenarioService{

	private ScenarioRepository scenarioDao;
	
	@Inject
	public ScenarioServiceImpl(ScenarioRepository scenarioDao){
		this.scenarioDao = scenarioDao;
	}
	
	@Override
	public Scenario findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return scenarioDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Scenario, see inner exception.", ex);
		}
	}

	@Override
	public List<Scenario> findAll(String search) {
		try {
			if(search !=null && !search.isEmpty()){
				final Node rootNode = new RSQLParser().parse(search);
	            Specification<Scenario> spec = rootNode.accept(new RsqlVisitor<Scenario>());
				return scenarioDao.findAll(spec);
			} else{
				return scenarioDao.findAll();
			}
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Scenario, see inner exception.", ex);
		}
	}

	@Override
	public Scenario update(Scenario c) {
		if (c == null)
			throw new IllegalArgumentException("Scenario c parameter is null");
		try {
			return scenarioDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating Scenario, see inner exception.", ex);
		}
	}

	@Override
	public void remove(Scenario c) {
		if (c == null)
			throw new IllegalArgumentException("Scenario c parameter is null");
		try {
			scenarioDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting Scenario, see inner exception.", ex);
		}
	}

	@Override
	public Scenario create(Scenario scenario) {
		if (scenario == null)
			throw new IllegalArgumentException("scenario parameter is null");
		try {
			scenarioDao.save(scenario);
			return scenario;
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating scenario, see inner exception.", ex);
		}
	}

}
