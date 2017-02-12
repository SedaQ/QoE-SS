package com.seda.qoe.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "scenarions")
public class Scenarions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_scenarion")
	protected Long id;

	@Column(nullable = false)
	private String scenarions;

	@ManyToMany
	private Set<Videos> videos = new HashSet<Videos>();

	@OneToOne
	private ScenarioParameters values;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScenarions() {
		return scenarions;
	}

	public void setScenarions(String scenarions) {
		this.scenarions = scenarions;
	}

	public Set<Videos> getVideos() {
		return videos;
	}

	public void setVideos(Set<Videos> videos) {
		this.videos = videos;
	}

	public ScenarioParameters getValues() {
		return values;
	}

	public void setValues(ScenarioParameters values) {
		this.values = values;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((scenarions == null) ? 0 : scenarions.hashCode());
		result = prime * result + ((values == null) ? 0 : values.hashCode());
		result = prime * result + ((videos == null) ? 0 : videos.hashCode());
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
		Scenarions other = (Scenarions) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (scenarions == null) {
			if (other.scenarions != null)
				return false;
		} else if (!scenarions.equals(other.scenarions))
			return false;
		if (values == null) {
			if (other.values != null)
				return false;
		} else if (!values.equals(other.values))
			return false;
		if (videos == null) {
			if (other.videos != null)
				return false;
		} else if (!videos.equals(other.videos))
			return false;
		return true;
	}

}
