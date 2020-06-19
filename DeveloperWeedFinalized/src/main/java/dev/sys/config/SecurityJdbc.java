package dev.sys.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityJdbc extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/BL/insert","/BL/delete","/createUser","/BL/list" ,"/BL/get", "/Administrador_users").permitAll()
		.antMatchers("/BL/insert", "/BL/update").permitAll()
		.antMatchers("/BL/list" ,"/BL/get","home").permitAll()
		.antMatchers("/css/loginstyle.css","/js/*").permitAll()
		.antMatchers("/images/logo.png").permitAll() 
		.antMatchers( "/favicon.ico").permitAll()
		.antMatchers("/","BL" ,"home").permitAll()
		;
		
		http
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login").permitAll() //todos pueden ingresar a la página login
			.and()
			.logout()
				.permitAll() //todos pueden des loggearse
	
		; 
	
		http.exceptionHandling().accessDeniedPage("/403")
		;
	
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery("SELECT username,password,enabled FROM users WHERE username=?")
			.authoritiesByUsernameQuery(
					"SELECT u.username, r.rol " +
					"FROM users_rol ur, users u , rol r " +
					"WHERE u.user_id = ur.user_id and r.rol_id = ur.rol_id and u.username=?"
			);	
		
	}
		
		
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }


	 
	
		
}
