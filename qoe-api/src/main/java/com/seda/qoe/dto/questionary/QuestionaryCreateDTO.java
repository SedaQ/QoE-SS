package com.seda.qoe.dto.questionary;

import org.hibernate.validator.constraints.NotEmpty;

import com.seda.qoe.dto.mos.MosDTO;
import com.seda.qoe.dto.user.UserDTO;

public class QuestionaryCreateDTO {
	
	private Long id;
	@NotEmpty
	private String email;
	private String gender;
	@NotEmpty
	private String age;
	@NotEmpty
	private String school;
	@NotEmpty
	private String userConnection;
	
	private UserDTO user;
	private MosDTO mos;
	
	public QuestionaryCreateDTO(){}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		QuestionaryCreateDTO other = (QuestionaryCreateDTO) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
