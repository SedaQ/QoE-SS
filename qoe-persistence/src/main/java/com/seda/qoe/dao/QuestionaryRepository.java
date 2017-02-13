package com.seda.qoe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seda.qoe.entity.Questionary;

public interface QuestionaryRepository extends JpaRepository<Questionary, Long> {

}
