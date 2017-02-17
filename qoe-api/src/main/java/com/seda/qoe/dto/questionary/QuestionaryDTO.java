package com.seda.qoe.dto.questionary;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.user.UserDTO;

public class QuestionaryDTO {
	private Long id;

	private String gender;

	private String age;

	private String school;
	
	private String userConnection;

	private UserDTO user;
	private MosDTO mos;
	
	public QuestionaryDTO(){}

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

	public String getUserConnection() {
		return userConnection;
	}

	public void setUserConnection(String userConnection) {
		this.userConnection = userConnection;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public MosDTO getMos() {
		return mos;
	}

	public void setMos(MosDTO mos) {
		this.mos = mos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((school == null) ? 0 : school.hashCode());
		result = prime * result
				+ ((userConnection == null) ? 0 : userConnection.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof QuestionaryDTO))
			return false;
		QuestionaryDTO other = (QuestionaryDTO) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (school == null) {
			if (other.school != null)
				return false;
		} else if (!school.equals(other.school))
			return false;
		if (userConnection == null) {
			if (other.userConnection != null)
				return false;
		} else if (!userConnection.equals(other.userConnection))
			return false;
		return true;
	}


}
