package com.seda.qoe.dto.mos;

import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;

public class MosCreateDTO {
	private Long id;

	private String mosValue;

	private QuestionaryDTO questionary;

	private VideoDTO video;
	
	private ScenarioDTO scenario;

	public MosCreateDTO() {
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
		if (!(obj instanceof MosCreateDTO))
			return false;
		MosCreateDTO other = (MosCreateDTO) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (mosValue == null) {
			if (other.getMosValue() != null)
				return false;
		} else if (!mosValue.equals(other.getMosValue()))
			return false;
		if (questionary == null) {
			if (other.getQuestionary() != null)
				return false;
		} else if (!questionary.equals(other.getQuestionary()))
			return false;
		return true;
	}
}
