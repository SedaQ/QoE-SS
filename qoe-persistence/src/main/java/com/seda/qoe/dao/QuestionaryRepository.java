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

	/**
	 * 
	 * Find specific questionary by more attributes {it is usefull when
	 * nonUniqueException is invoked
	 */
	@Query("SELECT q FROM #{#entityName} q WHERE q.id IS NOT NULL AND q.email=:email AND q.gender=:gender AND q.age=:age AND q.school=:school AND q.userConnection=:userConnection")
	public Questionary findByEqualsMethod(@Param("email") String email,
			@Param("gender") String gender, @Param("age") String age, @Param("school") String school,
			@Param("userConnection") String userConnection);

}
