package com.seda.qoe.dto.scenarioparameters;

import com.seda.qoe.dto.scenario.ScenarioDTO;

public class ScenarioParametersDTO {
	private Long id;
	private Long time;
	private Long length;
	private ScenarioDTO scenario;

	public ScenarioParametersDTO() {
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

	public ScenarioDTO getScenario() {
		return scenario;
	}

	public void setScenario(ScenarioDTO scenario) {
		this.scenario = scenario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((length == null) ? 0 : length.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScenarioParametersDTO))
			return false;
		ScenarioParametersDTO other = (ScenarioParametersDTO) obj;
		if (length == null) {
			if (other.length != null)
				return false;
		} else if (!length.equals(other.length))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}


}
