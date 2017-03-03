package com.seda.qoe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.seda.qoe.entity.Mos;
import com.seda.qoe.entity.Questionary;
import com.seda.qoe.entity.ScenarioParameters;

public interface ScenarioParametersRepository extends JpaRepository<ScenarioParameters, Long>, JpaSpecificationExecutor<ScenarioParameters> {

	@Override
	public Page<ScenarioParameters> findAll(Pageable pageRequest);

}
