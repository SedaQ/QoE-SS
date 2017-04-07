package cz.vutbr.feec.seda.dto.scenario;

import java.util.ArrayList;
import java.util.List;

import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.dto.scenarioparameters.ScenarioParametersDTO;
import cz.vutbr.feec.seda.dto.video.VideoDTO;

/**
 * @author Pavel Šeda (441048)
 *
 */
public class ScenarioDTO {
	private Long id;
	private String scenario;
	private List<VideoDTO> video = new ArrayList<VideoDTO>();
	private List<ScenarioParametersDTO> scenarioparameters = new ArrayList<ScenarioParametersDTO>();
	private MosDTO mos;

	public ScenarioDTO() {
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

	public void setScenarioparameters(List<ScenarioParametersDTO> scenarioparameters) {
		this.scenarioparameters = scenarioparameters;
	}
	
	public void addScenarioparameters(ScenarioParametersDTO scenarioparameters){
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
		if (!(obj instanceof ScenarioDTO))
			return false;
		ScenarioDTO other = (ScenarioDTO) obj;
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
