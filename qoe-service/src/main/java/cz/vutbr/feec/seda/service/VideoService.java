package cz.vutbr.feec.seda.service;

import java.util.List;

import cz.vutbr.feec.seda.entity.Video;


/**
 * @author Pavel Šeda (441048)
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
	public List<Video> findAll(String search);

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
	
	/**
	 * returns random video from DB
	 * @return random video from DB
	 */
	public Video findRandomVideo();
	
}
