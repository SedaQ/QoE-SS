package com.seda.qoe.dto.video;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;

public class VideoCreateDTO {
	
	private Long id;
	@NotEmpty
	private String name;
	@NotEmpty
	private List<String> videoSource = new ArrayList<String>();
	private List<MosDTO> mos = new ArrayList<MosDTO>();
	private List<ScenarioDTO> scenario = new ArrayList<ScenarioDTO>();

	public VideoCreateDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getVideoSource() {
		return videoSource;
	}

	public void setVideoSource(List<String> videoSource) {
		this.videoSource = videoSource;
	}

	public void addVideoSource(String videoSource) {
		this.videoSource.add(videoSource);
	}

	public List<MosDTO> getMos() {
		return mos;
	}

	public void setMos(List<MosDTO> mos) {
		this.mos = mos;
	}

	public void addMos(MosDTO mos) {
		this.mos.add(mos);
	}

	public List<ScenarioDTO> getScenario() {
		return scenario;
	}

	public void setScenario(List<ScenarioDTO> scenario) {
		this.scenario = scenario;
	}

	public void addScenario(ScenarioDTO scenario) {
		this.scenario.add(scenario);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((videoSource == null) ? 0 : videoSource.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VideoCreateDTO))
			return false;
		VideoCreateDTO other = (VideoCreateDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (videoSource == null) {
			if (other.videoSource != null)
				return false;
		} else if (!videoSource.equals(other.videoSource))
			return false;
		return true;
	}
}