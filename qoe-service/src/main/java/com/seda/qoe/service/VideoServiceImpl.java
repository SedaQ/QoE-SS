package com.seda.qoe.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.seda.qoe.dao.VideoRepository;
import com.seda.qoe.entity.Video;
import com.seda.qoe.exceptions.ServiceLayerException;

/**
 * @author Pavel Šeda
 *
 */
@Service
public class VideoServiceImpl implements VideoService{

	private VideoRepository videoDao;
	
	@Inject
	public VideoServiceImpl(VideoRepository videoDao){
		this.videoDao = videoDao;
	}
	
	@Override
	public Video findById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Long id parameter is null");

		try {
			return videoDao.findOne(id);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Video, see inner exception.", ex);
		}
	}

	@Override
	public List<Video> findAll() {
		try {
			return videoDao.findAll();
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with finding Video, see inner exception.", ex);
		}
	}

	@Override
	public Video update(Video c) {
		if (c == null)
			throw new IllegalArgumentException("Video c parameter is null");
		try {
			return videoDao.save(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with updating Video, see inner exception.", ex);
		}
	}

	@Override
	public void remove(Video c) {
		if (c == null)
			throw new IllegalArgumentException("Video c parameter is null");
		try {
			videoDao.delete(c);
		} catch (Exception ex) {
			throw new ServiceLayerException("Problem with deleting Video, see inner exception.", ex);
		}
	}

	@Override
	public Video create(Video video) {
		if (video == null)
			throw new IllegalArgumentException("video parameter is null");
		try {
			return videoDao.save(video);
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating video, see inner exception.", ex);
		}
	}

	@Override
	public Video findRandomVideo() {
		try {
			return videoDao.getRandomVideo();
		} catch (DataAccessException ex) {
			throw new ServiceLayerException("Problem with creating video, see inner exception.", ex);
		}
	}
	
	private Pageable createPageRequest(Integer firstPosition, Integer secondPosition){
		return new PageRequest(firstPosition, secondPosition);
	}
}
