package com.seda.qoe.dto.mos;

import com.seda.qoe.dto.questionary.QuestionaryDTO;
import com.seda.qoe.dto.scenario.ScenarioDTO;
import com.seda.qoe.dto.video.VideoDTO;

public class MosRedirectParameters {
	private QuestionaryDTO questionary;
	private VideoDTO video;
	private ScenarioDTO scenario;
	
	public MosRedirectParameters(){}

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
		result = prime * result
				+ ((questionary == null) ? 0 : questionary.hashCode());
		result = prime * result
				+ ((scenario == null) ? 0 : scenario.hashCode());
		result = prime * result + ((video == null) ? 0 : video.hashCode());
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
		MosRedirectParameters other = (MosRedirectParameters) obj;
		if (questionary == null) {
			if (other.questionary != null)
				return false;
		} else if (!questionary.equals(other.questionary))
			return false;
		if (scenario == null) {
			if (other.scenario != null)
				return false;
		} else if (!scenario.equals(other.scenario))
			return false;
		if (video == null) {
			if (other.video != null)
				return false;
		} else if (!video.equals(other.video))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MosRedirectParameters [questionary=" + questionary + ", video="
				+ video + ", scenario=" + scenario + "]";
	}
}
