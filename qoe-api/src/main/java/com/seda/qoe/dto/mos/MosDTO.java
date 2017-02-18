package com.seda.qoe.dto.mos;

import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;

public class MosDTO {
	private Long id;

	private String mosValue;

	private QuestionaryDTO questionary;
	
	private VideoDTO video;
	
	private ScenarioDTO scenario;

	public MosDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMosValue() {
		return mosValue;
	}

	public void setMosValue(String mosValue) {
		this.mosValue = mosValue;
	}

	public QuestionaryDTO getQuestionary() {
		return questionary;
	}

	public void setQuestionary(QuestionaryDTO questionary) {
		this.questionary = questionary;
	}

	public VideoDTO getVideo() {
		return video;
	}

	public void setVideo(VideoDTO video) {
		this.video = video;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mosValue == null) ? 0 : mosValue.hashCode());
		result = prime * result
				+ ((questionary == null) ? 0 : questionary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof MosDTO))
			return false;
		MosDTO other = (MosDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mosValue == null) {
			if (other.mosValue != null)
				return false;
		} else if (!mosValue.equals(other.mosValue))
			return false;
		if (questionary == null) {
			if (other.questionary != null)
				return false;
		} else if (!questionary.equals(other.questionary))
			return false;
		return true;
	}

	
}
