package com.seda.qoe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seda.qoe.entity.Questionary;

public interface QuestionaryRepository extends JpaRepository<Questionary, Long> {

	/**
	 * Find specific questionary by email
	 * 
	 * @param email
	 *            email to search in String format
	 * @return return specific user by his email
	 */
	@Query("SELECT q FROM #{#entityName} q WHERE q.email=:email")
	public Questionary findByEmail(@Param("email") String email);
	
}
