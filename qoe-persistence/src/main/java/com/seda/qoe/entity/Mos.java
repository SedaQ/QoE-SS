package com.seda.qoe.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mos")
public class Mos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mos")
	protected Long id;

	@Column(nullable = false, name = "mos_value")
	private String mosValue;

	@OneToOne
	//@JoinColumn(name = "mos")
	private Dotaznik id_dotaznik;

	@OneToOne
	//@JoinColumn(name = "mos")
	private Videos id_video;

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

	public Dotaznik getId_dotaznik() {
		return id_dotaznik;
	}

	public void setId_dotaznik(Dotaznik id_dotaznik) {
		this.id_dotaznik = id_dotaznik;
	}

	public Videos getId_video() {
		return id_video;
	}

	public void setId_video(Videos id_video) {
		this.id_video = id_video;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((id_dotaznik == null) ? 0 : id_dotaznik.hashCode());
		result = prime * result
				+ ((id_video == null) ? 0 : id_video.hashCode());
		result = prime * result
				+ ((mosValue == null) ? 0 : mosValue.hashCode());
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
		if (id_dotaznik == null) {
			if (other.id_dotaznik != null)
				return false;
		} else if (!id_dotaznik.equals(other.id_dotaznik))
			return false;
		if (id_video == null) {
			if (other.id_video != null)
				return false;
		} else if (!id_video.equals(other.id_video))
			return false;
		if (mosValue == null) {
			if (other.mosValue != null)
				return false;
		} else if (!mosValue.equals(other.mosValue))
			return false;
		return true;
	}

}
