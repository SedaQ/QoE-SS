package cz.vutbr.feec.seda.dto.mos;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import cz.vutbr.feec.seda.dto.questionary.QuestionaryDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;
import cz.vutbr.feec.seda.dto.video.VideoDTO;

/**
 * @author Pavel Šeda (441048)
 *
 */
public class MosCreateDTO {
	private Long id;

	@NotEmpty(message = "It's required to set value or mos")
	private String mosValue;
	@NotNull(message = "It's required to assign this mos to some questionary")
	private QuestionaryDTO questionary;
	@NotNull(message = "It's required to assign this mos to some video")
	private VideoDTO video;
	@NotNull(message = "It's required to assign this mos to some scenario")
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
			if (other.id != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (mosValue == null) {
			if (other.mosValue != null)
				return false;
		} else if (!mosValue.equals(other.getMosValue()))
			return false;
		return true;
	}
}
