package com.seda.qoe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mos")
public class Mos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mos", nullable = false, unique = true)
	private Long id;

	@Column(nullable = false, name = "mos_value")
	private String mosValue;

	@OneToOne(fetch = FetchType.LAZY)
	// @JsonBackReference
	private Questionary questionary;

	@ManyToOne(fetch = FetchType.LAZY)
	// @JsonBackReference
	private Video video;

	public Mos() {
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

	public Questionary getQuestionary() {
		return questionary;
	}

	public void setQuestionary(Questionary questionary) {
		this.questionary = questionary;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((mosValue == null) ? 0 : mosValue.hashCode());
		result = prime * result
				+ ((questionary == null) ? 0 : questionary.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Mos))
			return false;
		Mos other = (Mos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mosValue == null) {
			if (other.mosValue != null)
				return false;
		} else if (!mosValue.equals(other.mosValue))
			return false;
		if (questionary == null) {
			if (other.questionary != null)
				return false;
		} else if (!questionary.equals(other.questionary))
			return false;
		return true;
	}

}
