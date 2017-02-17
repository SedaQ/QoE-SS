package com.seda.qoe.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.dozer.Mapping;

@Entity
@Table(name = "scenario")
public class Scenario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scenarion", nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private String scenario;

	@ManyToMany(fetch = FetchType.LAZY)
	@Mapping("video")
	// @JsonBackReference
	private Set<Video> video = new HashSet<Video>();

	@OneToOne(fetch = FetchType.LAZY)
	// @JsonBackReference
	private ScenarioParameters scenarioparameters;

	public Scenario() {
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

	public Set<Video> getVideo() {
		return video;
	}

	public void setVideo(Set<Video> video) {
		this.video = video;
	}

	public void addVideo(Video video) {
		this.video.add(video);
	}

	public ScenarioParameters getScenarioparameters() {
		return scenarioparameters;
	}

	public void setScenarioparameters(ScenarioParameters scenarioparameters) {
		this.scenarioparameters = scenarioparameters;
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
		if (!(obj instanceof Scenario))
			return false;
		Scenario other = (Scenario) obj;
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
