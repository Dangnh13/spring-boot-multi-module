package vn.woodsland.byserp.oauth2.config;

import vn.woodsland.byserp.oauth2.provider.CustomPasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Autowired
	AuthenticationFailureHandler customAuthenticationFailureHandler;

	@Autowired
	private CustomPasswordAuthenticationProvider customPasswordAuthenticationProvider;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(customPasswordAuthenticationProvider)
				.jdbcAuthentication()
				.dataSource(dataSource);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/v2/api-docs",
				"/configuration/ui",
				"/swagger-resources/**",
				"/configuration/security",
				"/swagger-ui.html",
				"/webjars/**",
				"/resources/**",
				"/css/**", "/img/**/*", "/js/**", "/webfonts/**", "/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.requestMatchers()
				.antMatchers("/actuator/**", "/login**", "/oauth/**", "/logout**")
				.and()
				.authorizeRequests()
				.antMatchers("/actuator/health", "/login**", "/oauth/authorize**").permitAll() //"/actuator/**",
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.failureHandler(customAuthenticationFailureHandler)
				.permitAll();
	}

}
