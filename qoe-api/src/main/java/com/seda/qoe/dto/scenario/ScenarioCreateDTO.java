package com.seda.qoe.dto.scenario;

import java.util.ArrayList;
import java.util.List;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.dto.video.VideoDTO;

public class ScenarioCreateDTO {
	private Long id;
	private String scenario;
	private List<VideoDTO> video = new ArrayList<VideoDTO>();
	private List<ScenarioParametersDTO> scenarioparameters = new ArrayList<ScenarioParametersDTO>();
	private MosDTO mos;

	public ScenarioCreateDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public List<VideoDTO> getVideo() {
		return video;
	}

	public void setVideo(List<VideoDTO> video) {
		this.video = video;
	}

	public List<ScenarioParametersDTO> getScenarioparameters() {
		return scenarioparameters;
	}

	public void setScenarioparameters(
			List<ScenarioParametersDTO> scenarioparameters) {
		this.scenarioparameters = scenarioparameters;
	}

	public void addScenarioparameters(ScenarioParametersDTO scenarioparameters) {
		this.scenarioparameters.add(scenarioparameters);
	}

	public void addVideo(VideoDTO video) {
		this.video.add(video);
	}

	public MosDTO getMos() {
		return mos;
	}

	public void setMos(MosDTO mos) {
		this.mos = mos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((scenario == null) ? 0 : scenario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScenarioCreateDTO))
			return false;
		ScenarioCreateDTO other = (ScenarioCreateDTO) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (scenario == null) {
			if (other.getScenario() != null)
				return false;
		} else if (!scenario.equals(other.getScenario()))
			return false;
		return true;
	}
}
