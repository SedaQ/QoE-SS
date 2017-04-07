package cz.vutbr.feec.seda.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cz.vutbr.feec.seda.entity.ScenarioParameters;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface ScenarioParametersRepository extends JpaRepository<ScenarioParameters, Long>, JpaSpecificationExecutor<ScenarioParameters> {

	@Override
	public Page<ScenarioParameters> findAll(Pageable pageRequest);

}
