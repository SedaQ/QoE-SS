package com.seda.qoe.facade;

import java.util.List;

import com.seda.qoe.dto.video.VideoCreateDTO;
import com.seda.qoe.dto.video.VideoDTO;

/**
 * @author Pavel Šeda (441048)
 *
 */
public interface VideoFacade {

	/**
	 * create new video in database
	 * 
	 * @param video
	 *            specific Video to be created
	 * @return created video
	 */
	public VideoDTO create(VideoCreateDTO video);

	/**
	 * finds specific Video by id
	 * 
	 * @param id
	 *            of a Video that would be returned
	 * @return specific Video by id
	 */
	public VideoDTO getVideoById(Long id);

	/**
	 * updates given Video
	 * 
	 * @param VideoId
	 *            Video that has to be updated
	 * @return updated Video
	 */
	public VideoDTO update(Long videoId);

	/**
	 * removes given Video
	 * 
	 * @param VideoId
	 *            Video that has to be removed
	 * @return true, if successfully removed
	 */
	public Boolean deleteVideo(Long videoId);

	/**
	 * Returns all Video in qoe
	 * 
	 * @return List of Video which are in qoe DB
	 */
	public List<VideoDTO> getAllVideo(String search);
	
	/**
	 * 
	 * @return random video from DB
	 */
	public VideoDTO findRandomVideo();
}
