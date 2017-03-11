package com.seda.qoe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seda.qoe.entity.User;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	/**
	 * Find specific user by his email
	 * 
	 * @param email
	 *            email to search in String format
	 * @return return specific user by his email
	 */
	@Query("SELECT u FROM #{#entityName} u WHERE u.email=:email")
	public User findByEmail(@Param("email") String email);
	
	@Override
	public Page<User> findAll(Pageable pageRequest);
	
}
