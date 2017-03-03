package com.seda.qoe.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.seda.qoe.dao.QuestionaryRepository;
import com.seda.qoe.entity.Mos;
import com.seda.qoe.entity.Questionary;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.specification.RsqlVisitor;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;

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
	public Questionary findByEqualsMethod(String email, String gender, String age, String school,
			String userConnection) {
		if(email == null || gender == null || age == null || school == null || userConnection == null)
			throw new IllegalArgumentException("findByEqualsMethod some parameters is null");
		try {
			return questionaryDao.findByEqualsMethod(email, gender, age, school, userConnection);
		} catch(DataAccessException ex){
			throw new ServiceLayerException("Problem with findByEqualsMethod search.", ex);
		}
		
	}

}
