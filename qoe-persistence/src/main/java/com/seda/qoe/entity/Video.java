package com.seda.qoe.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_video")
	protected Long id;

	@Column
	private String name;

	@Column(nullable = false, name = "video_src")
	private String video_source;

	@OneToOne(mappedBy = "id_video")
	private Mos mos;

	@ManyToMany(mappedBy = "video")
	private Set<Scenario> scenario = new HashSet<Scenario>();

	public Video(){}
	
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

	public String getVideoSource() {
		return video_source;
	}

	public void setVideoSource(String videoSource) {
		this.video_source = videoSource;
	}

	public Mos getMos() {
		return mos;
	}

	public void setMos(Mos mos) {
		this.mos = mos;
	}

	public Set<Scenario> getScenarions() {
		return scenario;
	}

	public void setScenarions(Set<Scenario> scenarions) {
		this.scenario = scenarions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mos == null) ? 0 : mos.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((scenario == null) ? 0 : scenario.hashCode());
		result = prime * result
				+ ((video_source == null) ? 0 : video_source.hashCode());
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
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mos == null) {
			if (other.mos != null)
				return false;
		} else if (!mos.equals(other.mos))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (scenario == null) {
			if (other.scenario != null)
				return false;
		} else if (!scenario.equals(other.scenario))
			return false;
		if (video_source == null) {
			if (other.video_source != null)
				return false;
		} else if (!video_source.equals(other.video_source))
			return false;
		return true;
	}

}
