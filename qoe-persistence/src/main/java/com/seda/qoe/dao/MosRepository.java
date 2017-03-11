package com.seda.qoe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.seda.qoe.entity.Mos;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface MosRepository extends JpaRepository<Mos, Long>, JpaSpecificationExecutor<Mos>{

}
