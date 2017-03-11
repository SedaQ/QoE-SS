package com.seda.qoe.dto.questionary;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class QuestionaryCreateDTO {

	private Long id;
	@NotNull(message = "It's required to set email")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email must exists!")
	private String email;
	@NotNull(message = "It's required to set gender")
	private String gender;
	@NotNull(message = "It's required to set age")
	@Pattern(regexp = "^[0-9]+", message = "Field age must contains only numbers")
	private String age;
	@NotNull(message = "It's required to set school")
	private String school;
	private Date date;
	@NotNull(message = "It's required to set user connection")
	private String userConnection;

	public QuestionaryCreateDTO() {
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
		result = prime * result + ((date == null) ? 0 : date.hashCode());
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
		if (!(obj instanceof QuestionaryCreateDTO))
			return false;
		QuestionaryCreateDTO other = (QuestionaryCreateDTO) obj;
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
