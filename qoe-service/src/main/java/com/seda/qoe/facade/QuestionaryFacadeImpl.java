package com.seda.qoe.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.entity.Questionary;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.QuestionaryService;

@Service
@Transactional
public class QuestionaryFacadeImpl implements QuestionaryFacade {

	private QuestionaryService questionaryService;
	private BeanMapping beanMapping;
	
	@Inject
	public QuestionaryFacadeImpl(QuestionaryService questionaryService, BeanMapping beanMapping){
		this.questionaryService = questionaryService;
		this.beanMapping = beanMapping;
	}
	
	@Override
	public QuestionaryDTO getQuestionaryById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Id parameter is null");
		try {
			Questionary questionary = questionaryService.findById(id);
			return questionary != null ? beanMapping.mapTo(questionary, QuestionaryDTO.class) : null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public QuestionaryDTO update(Long questionaryId) {
		if (questionaryId == null)
			throw new IllegalArgumentException(
					"questionaryId parameter is null in update method");
		try {
			Questionary questionary = questionaryService.update(questionaryService.findById(questionaryId));
			return questionary != null ? beanMapping.mapTo(questionary, QuestionaryDTO.class) : null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean deleteQuestionary(Long questionaryId) {
		if (questionaryId == null)
			throw new IllegalArgumentException(
					"questionaryId parameter is null in deleteUser method");
		try {
			questionaryService.remove(questionaryService.findById(questionaryId));
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public List<QuestionaryDTO> getAllQuestionary() {
		try {
			return beanMapping.mapTo(questionaryService.findAll(), QuestionaryDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}

}
