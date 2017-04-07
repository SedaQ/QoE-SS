package cz.vutbr.feec.seda.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import cz.vutbr.feec.seda.dao.QuestionaryRepository;
import cz.vutbr.feec.seda.entity.Questionary;
import cz.vutbr.feec.seda.exceptions.ServiceLayerException;
import cz.vutbr.feec.seda.specification.RsqlVisitor;


/**
 * @author Pavel Šeda (441048)
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
	public List<Questionary> findAll(String search) {
		try {
			if(search !=null && !search.isEmpty()){
				final Node rootNode = new RSQLParser().parse(search);
	            Specification<Questionary> spec = rootNode.accept(new RsqlVisitor<Questionary>());
	            return questionaryDao.findAll(spec);
			} else{
				return questionaryDao.findAll();
			}
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
			questionary.setDate(new Date());
			return questionaryDao.save(questionary);
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating questionary, see inner exception.", ex);
		}
	}

	@Override
	public List<Questionary> findBySearchTerm(String searchTerm) {
		if(searchTerm == null)
			throw new IllegalArgumentException("searchTerm parameters is null");
		try{
			if(searchTerm.isEmpty())
				return questionaryDao.findAll();
			else
				return questionaryDao.findAllBySearchTerm(searchTerm);
		}catch(DataAccessException ex){
			throw new ServiceLayerException("Problem with findByEqualsMethod search.", ex);
		}
	}

}
