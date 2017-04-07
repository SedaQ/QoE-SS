package cz.vutbr.feec.seda.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import cz.vutbr.feec.seda.entity.Mos;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface MosRepository extends JpaRepository<Mos, Long>, JpaSpecificationExecutor<Mos>{

}
