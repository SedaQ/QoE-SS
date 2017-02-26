package com.seda.qoe.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.dozer.Mapping;

@Entity
@Table(name = "scenario_parameters")
public class ScenarioParameters {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scenarioparameters", nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private Long time;

	@Column(nullable = false)
	private Long length;
	
	@Column(nullable = false, name="video_quality")
	private String videoQuality;

	@ManyToMany(fetch = FetchType.EAGER)
	//@Mapping("scenario")
	private Set<Scenario> scenario = new HashSet<Scenario>();

	public ScenarioParameters() {
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

	public Set<Scenario> getScenario() {
		return scenario;
	}

	public void setScenario(Set<Scenario> scenario) {
		this.scenario = scenario;
	}
	
	public void addScenario(Scenario scenario){
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
		if (!(obj instanceof ScenarioParameters))
			return false;
		ScenarioParameters other = (ScenarioParameters) obj;
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
		if (videoQuality == null) {
			if (other.videoQuality != null)
				return false;
		} else if (!videoQuality.equals(other.videoQuality))
			return false;
		return true;
	}

	
}
