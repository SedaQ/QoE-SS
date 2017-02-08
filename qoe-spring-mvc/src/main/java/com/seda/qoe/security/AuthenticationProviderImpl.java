package com.seda.qoe.security;

import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String email = auth.getName();

		// LSUserDTO user = userFacade.getUserByEmail(email)
		// .orElseThrow(() -> new UsernameNotFoundException("Provide valid
		// email: " + email));

		String pwd = (String) auth.getCredentials();

		// LSUserDTO userForAuth = new LSUserDTO();
		// userForAuth.setId(user.getId());
		// userForAuth.setEmail(email);
		// userForAuth.setPasswordHash(pwd);
		//
		// if (!userFacade.authenticate(userForAuth)) {
		// throw new BadCredentialsException("Provide valid email or password");
		// }
		//
		//
		List<GrantedAuthority> authorities = null;
		// AuthorityUtils.createAuthorityList(user.getUserRole());
		return new UsernamePasswordAuthenticationToken(email, pwd, authorities);
	}

	@Override
	public boolean supports(Class<?> arg0) {
		return true;
	}

}
