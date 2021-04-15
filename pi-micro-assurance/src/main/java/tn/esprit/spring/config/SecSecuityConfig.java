package tn.esprit.spring.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import tn.esprit.spring.service.MyUserDetailService;
import tn.esprit.spring.service.UserDetailServiceImpl;
import tn.esprit.spring.service.UserService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecSecuityConfig<T> extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Autowired
	private MyUserDetailService myUserDetailService;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		// Setting Service to find User in the database.
		// And Setting PassswordEncoder
		auth.userDetailsService(userDetailsService())
		//.passwordEncoder(passwordEncoder())
		;

	}
/*
		@Override
     	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
			
			auth.inMemoryAuthentication().withUser("root")
					.password("root")
					//.roles("CUSTOMER")
					.and().withUser("admin")
					.password("admin")
					//.roles("USER", "ADMIN")
					;
		}*/
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	// We don't need CSRF for this example
	httpSecurity.csrf().disable()
	// dont authenticate this particular request
	.authorizeRequests()
	.antMatchers("/authenticate")
	.permitAll().
	// all other requests need to be authenticated
	anyRequest().authenticated().and().
	// make sure we use stateless session; session won't be used to
	// store user's state.
	exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
		

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		}

	}


