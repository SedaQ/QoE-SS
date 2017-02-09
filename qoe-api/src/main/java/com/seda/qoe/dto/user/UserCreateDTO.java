package com.seda.qoe.dto.user;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCreateDTO {
	protected Long id;
	@NotEmpty
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email must exists!")
	private String email;

	@NotEmpty
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",  message = "Minimum 8 characters at least 1 Alphabet and 1 Number") // Minimum 8 characters at least 1 Alphabet and 1 Number
	private String password;

	@NotEmpty(message = "User role couldn't be empty")
	private String userRole;


	public UserCreateDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public int hashCode() {
		int result = 31 * 1 + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserCreateDTO))
			return false;
		UserCreateDTO other = (UserCreateDTO) obj;
		if (email == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!email.equals(other.getEmail()))
			return false;
		return true;
	}

}
