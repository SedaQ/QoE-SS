package com.seda.qoe.facade;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.seda.qoe.dto.video.VideoCreateDTO;
import com.seda.qoe.dto.video.VideoDTO;
import com.seda.qoe.entity.Video;
import com.seda.qoe.exceptions.ServiceLayerException;
import com.seda.qoe.mapping.BeanMapping;
import com.seda.qoe.service.VideoService;

@Service
@Transactional
public class VideoFacadeImpl implements VideoFacade {

	private VideoService videoService;
	private BeanMapping beanMapping;
	
	@Inject
	public VideoFacadeImpl(VideoService videoService, BeanMapping beanMapping) {
		this.videoService = videoService;
		this.beanMapping = beanMapping;
	}
	
	@Override
	public VideoDTO getVideoById(Long id) {
		if (id == null)
			throw new IllegalArgumentException("Id parameter is null");
		try {
			Video video = videoService.findById(id);
			return video != null ? beanMapping.mapTo(video, VideoDTO.class) : null;
		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public VideoDTO update(Long videoId) {
		if (videoId == null)
			throw new IllegalArgumentException(
					"videoId parameter is null in update method");
		try {
			Video video = videoService.update(videoService.findById(videoId));
			return video != null ? beanMapping.mapTo(video, VideoDTO.class) : null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public Boolean deleteVideo(Long videoId) {
		if (videoId == null)
			throw new IllegalArgumentException(
					"videoId parameter is null in deleteUser method");
		try {
			videoService.remove(videoService.findById(videoId));
			return true;
		} catch (ServiceLayerException ex) {
			return false;
		}
	}

	@Override
	public List<VideoDTO> getAllVideo() {
		try {
			return beanMapping.mapTo(videoService.findAll(), VideoDTO.class);
		} catch (ServiceLayerException ex) {
			return Collections.emptyList();
		}
	}
	

	@Override
	public VideoDTO findRandomVideo() {
		try {
			return beanMapping.mapTo(videoService.findRandomVideo(), VideoDTO.class);
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

	@Override
	public VideoDTO create(VideoCreateDTO video) {
		if (video == null)
			throw new IllegalArgumentException(
					"VideoCreateDTO video parameter is null");
		try {
			Video v = videoService.create(beanMapping.mapTo(video, Video.class));
			return v != null ? beanMapping.mapTo(v, VideoDTO.class): null;
		} catch (ServiceLayerException ex) {
			return null;
		}
	}

}
