package com.seda.qoe.dto.video;

import java.util.HashSet;
import java.util.Set;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;

public class VideoDTO {
	private Long id;

	private String name;

	private String videoSource;

	private MosDTO mos;

	private Set<ScenarioDTO> scenario = new HashSet<ScenarioDTO>();

	public VideoDTO() {
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

	public String getVideoSource() {
		return videoSource;
	}

	public void setVideoSource(String videoSource) {
		this.videoSource = videoSource;
	}

	public MosDTO getMos() {
		return mos;
	}

	public void setMos(MosDTO mos) {
		this.mos = mos;
	}

	public Set<ScenarioDTO> getScenario() {
		return scenario;
	}

	public void setScenario(Set<ScenarioDTO> scenario) {
		this.scenario = scenario;
	}

	public void addScenario(ScenarioDTO scenario) {
		this.scenario.add(scenario);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mos == null) ? 0 : mos.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((scenario == null) ? 0 : scenario.hashCode());
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
		if (getClass() != obj.getClass())
			return false;
		VideoDTO other = (VideoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mos == null) {
			if (other.mos != null)
				return false;
		} else if (!mos.equals(other.mos))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (scenario == null) {
			if (other.scenario != null)
				return false;
		} else if (!scenario.equals(other.scenario))
			return false;
		if (videoSource == null) {
			if (other.videoSource != null)
				return false;
		} else if (!videoSource.equals(other.videoSource))
			return false;
		return true;
	}

}
