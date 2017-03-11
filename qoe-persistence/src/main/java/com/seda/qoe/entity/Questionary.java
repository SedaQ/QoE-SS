package com.seda.qoe.entity;

import java.util.Date;

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
@Table(name = "questionary")
public class Questionary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_questionary", nullable = false, unique = true)
	private Long id;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private String age;

	@Column(nullable = false)
	private String school;

	@Column(nullable = false, name = "user_connection")
	private String userConnection;

	@Column(nullable = false)
	private Date date;

	@ManyToOne(fetch = FetchType.EAGER)
	private User user;

	@OneToOne(mappedBy = "questionary", fetch = FetchType.EAGER)
	private Mos mos;

	public Questionary() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Mos getMos() {
		return mos;
	}

	public void setMos(Mos mos) {
		this.mos = mos;
	}

	public String getUserConnection() {
		return userConnection;
	}

	public void setUserConnection(String userConnection) {
		this.userConnection = userConnection;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result
				+ ((userConnection == null) ? 0 : userConnection.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof Questionary)
			return false;
		Questionary other = (Questionary) obj;
		if (id == null) {
			if (other.getId() != null)
				return false;
		} else if (!id.equals(other.getId()))
			return false;
		if (age == null) {
			if (other.getAge() != null)
				return false;
		} else if (!age.equals(other.getAge()))
			return false;
		if (email == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!email.equals(other.getEmail()))
			return false;
		if (gender == null) {
			if (other.getGender() != null)
				return false;
		} else if (!gender.equals(other.getGender()))
			return false;
		if (school == null) {
			if (other.getSchool() != null)
				return false;
		} else if (!school.equals(other.getSchool()))
			return false;
		if (date == null) {
			if (other.getDate() != null)
				return false;
		} else if (!date.equals(other.getDate()))
			return false;
		if (userConnection == null) {
			if (other.getUserConnection() != null)
				return false;
		} else if (!userConnection.equals(other.getUserConnection()))
			return false;
		return true;
	}

}
