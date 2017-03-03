package com.seda.qoe.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.seda.qoe.entity.Mos;

public interface MosRepository extends JpaRepository<Mos, Long>, JpaSpecificationExecutor<Mos>{

}
