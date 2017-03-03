package com.seda.qoe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.seda.qoe.entity.Scenario;
import com.seda.qoe.entity.ScenarioParameters;

public interface ScenarioRepository extends JpaRepository<Scenario, Long>, JpaSpecificationExecutor<Scenario>{

	@Override
	public Page<Scenario> findAll(Pageable pageRequest);
}
