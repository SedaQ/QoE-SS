package com.seda.qoe.dto.scenario;

import java.util.HashSet;
import java.util.Set;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.scenarioparameters.ScenarioParametersDTO;
import com.seda.qoe.dto.video.VideoDTO;

public class ScenarioCreateDTO {
	private Long id;
	private String scenario;
	private Set<VideoDTO> video = new HashSet<VideoDTO>();
	private ScenarioParametersDTO scenarioParameters;
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

	public Set<VideoDTO> getVideo() {
		return video;
	}

	public void setVideo(Set<VideoDTO> video) {
		this.video = video;
	}

	public void addVideo(VideoDTO video) {
		this.video.add(video);
	}

	public ScenarioParametersDTO getScenarioParameters() {
		return scenarioParameters;
	}

	public void setScenarioParameters(ScenarioParametersDTO scenarioParameters) {
		this.scenarioParameters = scenarioParameters;
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
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scenario == null) {
			if (other.scenario != null)
				return false;
		} else if (!scenario.equals(other.scenario))
			return false;
		return true;
	}
}
