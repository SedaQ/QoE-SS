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
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.seda.qoe.dto.user.UserDTO;
import com.seda.qoe.facade.UserFacade;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Inject
	private UserFacade userFacade;

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		String email = auth.getName();

		UserDTO user = userFacade.getUserByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Provide valid email: " + email);
		}

		String pwd = (String) auth.getCredentials();

		UserDTO userForAuth = new UserDTO();
		userForAuth.setId(user.getId());
		userForAuth.setEmail(email);
		userForAuth.setPasswordHash(pwd);

		if (!userFacade.authenticate(userForAuth)) {
			throw new BadCredentialsException("Provide valid email or password");
		}

		List<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(userRoles(user.getRoles()));
		return new UsernamePasswordAuthenticationToken(email, pwd, authorities);
	}

	public String[] userRoles(List<String> roles) {
		if (roles == null) {
			return new String[0];
		}
		String[] r = new String[roles.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = roles.get(i);
		}
		return r;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
