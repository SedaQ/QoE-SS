package com.seda.qoe.security;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.facade.UserFacade;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Inject
	private UserFacade userFacade;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String email = auth.getName();

		UserDTO user = userFacade.getUserByEmail(email);

		String pwd = (String) auth.getCredentials();

		UserDTO userForAuth = new UserDTO();
		userForAuth.setId(user.getId());
		userForAuth.setEmail(email);
		userForAuth.setPasswordHash(pwd);

		if (!userFacade.authenticate(userForAuth)) {
			throw new BadCredentialsException("Provide valid email or password");
		}

		List<GrantedAuthority> authorities = null;
		AuthorityUtils.createAuthorityList(user.getRoles());
		return new UsernamePasswordAuthenticationToken(email, pwd, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
