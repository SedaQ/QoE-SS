package com.seda.qoe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seda.qoe.entity.Dotaznik;

public interface DotaznikRepository extends JpaRepository<Dotaznik, Long> {

}
