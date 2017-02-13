package com.seda.qoe.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seda.qoe.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
