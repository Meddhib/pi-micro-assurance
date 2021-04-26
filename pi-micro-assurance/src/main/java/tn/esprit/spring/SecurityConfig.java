package tn.esprit.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/*
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true) //pour qui'il prend en consideration @secured
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{
		auth.jdbcAuthentication()
		 .dataSource(dataSource)
		 .usersByUsernameQuery("select USER_NAME as principal, USER_Password as credentials, active from User where username=?")
		 //recupere user puis compare mdp si c bon execute requette suivante
			.authoritiesByUsernameQuery("select User_username as principal, role from users_roles as ur, where user.username=? ")
			//je connais username il reccupere les roles
			.rolePrefix("ROLE_");}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http //build up pattern
		 .csrf().disable()
		 .authorizeRequests()
		 .antMatchers("/","/home").permitAll()
		  .anyRequest()
		   .authenticated()
		    .and()
		 .formLogin()
		      .loginPage("/home")
		 .defaultSuccessUrl("/index.html")
		 ;
	}
	

}*/