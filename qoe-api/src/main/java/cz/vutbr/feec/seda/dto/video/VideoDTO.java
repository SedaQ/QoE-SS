package cz.vutbr.feec.seda.dto.video;

import java.util.ArrayList;
import java.util.List;

import cz.vutbr.feec.seda.dto.mos.MosDTO;
import cz.vutbr.feec.seda.dto.scenario.ScenarioDTO;

/**
 * @author Pavel Šeda (441048)
 *
 */
public class VideoDTO {

	private Long id;
	private String name;
	private List<String> videoSource = new ArrayList<String>();
	private List<MosDTO> mos = new ArrayList<MosDTO>();
	private List<ScenarioDTO> scenario = new ArrayList<ScenarioDTO>();

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

	public List<String> getVideoSource() {
		return videoSource;
	}

	public void setVideoSource(List<String> videoSource) {
		this.videoSource = videoSource;
	}

	public void addVideoSource(String videoSource) {
		this.videoSource.add(videoSource);
	}

	public List<MosDTO> getMos() {
		return mos;
	}

	public void setMos(List<MosDTO> mos) {
		this.mos = mos;
	}

	public void addMos(MosDTO mos) {
		this.mos.add(mos);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VideoDTO))
			return false;
		VideoDTO other = (VideoDTO) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}

}
