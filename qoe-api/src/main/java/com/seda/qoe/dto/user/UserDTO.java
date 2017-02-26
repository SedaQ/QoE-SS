package com.seda.qoe.dto.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.seda.qoe.enums.UserRoles;

public class UserDTO {

	protected Long id;
	private String email;
	private String passwordHash;
	private List<UserRoles> roles = new ArrayList<UserRoles>();

	public UserDTO() {
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public Collection<UserRoles> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRoles> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof UserDTO))
			return false;
		UserDTO other = (UserDTO) obj;
		if (email == null) {
			if (other.getEmail() != null)
				return false;
		} else if (!email.equals(other.getEmail()))
			return false;
		return true;
	}


}
