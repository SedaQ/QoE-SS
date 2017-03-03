package com.seda.qoe.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.dozer.Mapping;

import com.seda.qoe.comparator.StringComparator;
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

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "video_source")
	@Column(nullable = false, name = "video_src")
	private Set<String> videoSource = new HashSet<String>();//new TreeSet<String>(new StringComparator());

	@OneToMany(mappedBy = "video", fetch = FetchType.EAGER)
	private Set<Mos> mos = new HashSet<Mos>();

	@ManyToMany(mappedBy = "video", fetch = FetchType.EAGER)
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

	public Set<String> getVideoSource() {
		return videoSource;
	}

	public void setVideoSource(Set<String> videoSource) {
		this.videoSource = videoSource;
	}

	public void addVideoSource(String videoSource) {
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
		if (!(obj instanceof Video))
			return false;
		Video other = (Video) obj;
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
