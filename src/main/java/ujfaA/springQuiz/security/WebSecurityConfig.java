package ujfaA.springQuiz.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import jakarta.servlet.DispatcherType;
import ujfaA.springQuiz.entities.Role;

@Configuration
public class WebSecurityConfig {

	@Autowired
    private LoginSuccessHandler loginSuccessHandler;

	@Bean
	public RoleHierarchy roleHierarchy(){
		var roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy( "ROLE_ADMINISTRATOR > ROLE_PROFESSOR  > ROLE_USER" );
		return roleHierarchy;
	}

	@Bean
	protected SecurityFilterChain filterChain( HttpSecurity http) throws Exception {

		http
		.csrf().disable()
		.authorizeHttpRequests()
			.shouldFilterAllDispatcherTypes(false)
			.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
			.requestMatchers("/registration","/errpage")
				.hasRole(Role.ADMINISTRATOR.name())
			.requestMatchers("/","/home", "/quiz/**")
				.authenticated()
			.requestMatchers("/questions", "/users/usersEng","/questions/new")
				.hasRole(Role.PROFESSOR.name())
			.anyRequest()
				.hasRole(Role.ADMINISTRATOR.name())

		.and()
		.formLogin()
			.loginPage("/login").permitAll()
			.successHandler(loginSuccessHandler)
			.failureUrl("/login?error=true")
		.and()
		.logout()
			.logoutSuccessUrl("/");

		return http.build();
	}

}
