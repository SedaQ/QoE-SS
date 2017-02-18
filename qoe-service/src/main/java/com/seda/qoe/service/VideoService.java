package com.seda.qoe.service;

import java.util.List;

import com.seda.qoe.entity.Video;

/**
 * @author Pavel Šeda
 *
 */
public interface VideoService {
	
	/**
	 * create new video in database
	 * 
	 * @param video
	 *            specific Video to be created
	 * @return created video
	 */
	public Video create(Video video);
	
	/**
	 * finds specific Video by id
	 * 
	 * @param id
	 *            of a Video that would be returned
	 * @return specific Video by id
	 */
	public Video findById(Long id);

	/**
	 * Returns all Video in language school
	 * 
	 * @return List of Video which are in language school
	 */
	public List<Video> findAll();

	/**
	 * updates given Video
	 * 
	 * @param c
	 *            Video that has to be updated
	 * @return updated Video
	 */
	public Video update(Video c);

	/**
	 * removes given Video
	 * 
	 * @param c
	 *            Video that has to be removed
	 */
	public void remove(Video c);
	
}
