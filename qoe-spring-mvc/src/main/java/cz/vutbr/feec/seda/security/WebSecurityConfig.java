package cz.vutbr.feec.seda.security;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Pavel Šeda (441048)
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Inject
	private AuthenticationProviderImpl authProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/rest/**").authenticated()
				.antMatchers("/auth/**").authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/home", false)
				.and()
			.logout()
				.deleteCookies("JSSESSIONID")
				.logoutSuccessUrl("/home")
				.invalidateHttpSession(true)
				.and()
			.exceptionHandling()
				.accessDeniedPage("/errorpage");
			//.csrf().enable();
	}
}
