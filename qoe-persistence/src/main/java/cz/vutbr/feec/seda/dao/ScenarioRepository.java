package cz.vutbr.feec.seda.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cz.vutbr.feec.seda.entity.Scenario;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface ScenarioRepository extends JpaRepository<Scenario, Long>, JpaSpecificationExecutor<Scenario>{

	@Override
	public Page<Scenario> findAll(Pageable pageRequest);
}
