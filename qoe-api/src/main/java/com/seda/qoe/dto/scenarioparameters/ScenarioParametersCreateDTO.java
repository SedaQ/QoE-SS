package com.seda.qoe.dto.scenarioparameters;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.seda.qoe.dto.scenario.ScenarioDTO;

public class ScenarioParametersCreateDTO {
	private Long id;
	@NotEmpty(message="It's required to fill time in scenario parameters")
	private Long time;
	@NotEmpty(message="It's required to fill length in scenario parameters")
	private Long length;
	@NotEmpty(message="It's required to fill videoQuality in scenario parameters")
	@Size(min=3, max=20, message="Video quality length must be between 3 and 20 characters")
	private String videoQuality;
	private List<ScenarioDTO> scenario = new ArrayList<ScenarioDTO>();

	public ScenarioParametersCreateDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
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

	public String getVideoQuality() {
		return videoQuality;
	}

	public void setVideoQuality(String videoQuality) {
		this.videoQuality = videoQuality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((videoQuality == null) ? 0 : videoQuality.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScenarioParametersCreateDTO))
			return false;
		ScenarioParametersCreateDTO other = (ScenarioParametersCreateDTO) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.getLength()))
			return false;
		if (time == null) {
			if (other.getTime() != null)
				return false;
		} else if (!time.equals(other.getTime()))
			return false;
		if (videoQuality == null) {
			if (other.videoQuality != null)
				return false;
		} else if (!videoQuality.equals(other.getVideoQuality()))
			return false;
		return true;
	}
}
