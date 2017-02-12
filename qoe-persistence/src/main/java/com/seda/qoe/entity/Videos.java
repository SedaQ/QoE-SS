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
@Table(name = "videos")
public class Videos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_videos")
	protected Long id;

	@Column
	private String name;

	@Column(nullable = false, name = "video_src")
	private String videoSource;

	@OneToOne(mappedBy = "id_video")
	private Mos mos;

	@ManyToMany(mappedBy = "videos")
	private Set<Scenarions> scenarions = new HashSet<Scenarions>();

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
		return videoSource;
	}

	public void setVideoSource(String videoSource) {
		this.videoSource = videoSource;
	}

	public Mos getMos() {
		return mos;
	}

	public void setMos(Mos mos) {
		this.mos = mos;
	}

	public Set<Scenarions> getScenarions() {
		return scenarions;
	}

	public void setScenarions(Set<Scenarions> scenarions) {
		this.scenarions = scenarions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mos == null) ? 0 : mos.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((scenarions == null) ? 0 : scenarions.hashCode());
		result = prime * result
				+ ((videoSource == null) ? 0 : videoSource.hashCode());
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
		Videos other = (Videos) obj;
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
		if (scenarions == null) {
			if (other.scenarions != null)
				return false;
		} else if (!scenarions.equals(other.scenarions))
			return false;
		if (videoSource == null) {
			if (other.videoSource != null)
				return false;
		} else if (!videoSource.equals(other.videoSource))
			return false;
		return true;
	}

}
