package com.seda.qoe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mos")
public class Mos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mos")
	protected Long id;

	@Column(nullable = false)
	private String mos_value;

	@OneToOne
	private Questionary id_questionary;

	@OneToOne
	private Video id_video;

	public Mos() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMosValue() {
		return mos_value;
	}

	public void setMosValue(String mosValue) {
		this.mos_value = mosValue;
	}

	public Questionary getId_questionary() {
		return id_questionary;
	}

	public void setId_questionary(Questionary id_questionary) {
		this.id_questionary = id_questionary;
	}

	public Video getId_video() {
		return id_video;
	}

	public void setId_video(Video id_video) {
		this.id_video = id_video;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_questionary == null) ? 0 : id_questionary.hashCode());
		result = prime * result
				+ ((id_video == null) ? 0 : id_video.hashCode());
		result = prime * result
				+ ((mos_value == null) ? 0 : mos_value.hashCode());
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
		Mos other = (Mos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (id_questionary == null) {
			if (other.id_questionary != null)
				return false;
		} else if (!id_questionary.equals(other.id_questionary))
			return false;
		if (id_video == null) {
			if (other.id_video != null)
				return false;
		} else if (!id_video.equals(other.id_video))
			return false;
		if (mos_value == null) {
			if (other.mos_value != null)
				return false;
		} else if (!mos_value.equals(other.mos_value))
			return false;
		return true;
	}

}
