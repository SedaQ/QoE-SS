package com.seda.qoe.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dozer.Mapping;

import com.seda.qoe.enums.UserRole;

@Entity
@Table(name = "video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_video", nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
	@Column(nullable = false, name = "video_src")
	private Collection<String> videoSource;

	@OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
	// @JsonManagedReference
	private Set<Mos> mos = new HashSet<Mos>();

	@ManyToMany(mappedBy = "video", fetch = FetchType.LAZY)
	@Mapping("scenario")
	// @JsonManagedReference
	private Set<Scenario> scenario = new HashSet<Scenario>();

	public Video() {
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

	public Collection<String> getVideoSource() {
		return videoSource;
	}

	public void setVideoSource(Collection<String> videoSource) {
		this.videoSource = videoSource;
	}
	
	public void addVideoSource(String videoSource){
		this.videoSource.add(videoSource);
	}

	public Set<Mos> getMos() {
		return mos;
	}

	public void setMos(Set<Mos> mos) {
		this.mos = mos;
	}

	public void addMos(Mos mos) {
		this.mos.add(mos);
	}

	public Set<Scenario> getScenario() {
		return scenario;
	}

	public void setScenario(Set<Scenario> scenario) {
		this.scenario = scenario;
	}

	public void addScenarion(Scenario scenario) {
		this.scenario.add(scenario);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Video))
			return false;
		Video other = (Video) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (videoSource == null) {
			if (other.videoSource != null)
				return false;
		} else if (!videoSource.equals(other.videoSource))
			return false;
		return true;
	}

}
