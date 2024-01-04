package com.tolgaozgun.gdscturkweb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	final private JWTUserService jwtUserService;
	final private JWTFilter jwtFilter;


	private static final String[] AUTH_WHITELIST = {
			"/v3/api-docs/**",
			"/swagger-ui/**",
			"/auth/login",
			"/email-verification/verify",
			"/email-verification/resend",
			"/auth/register",
			"/auth/register/lead",
			"/auth/register/core-team",
			"/auth/register/facilitator",
			"/auth/register/googler",
			"/auth/register/admin",
			"/universities",
	};

	private static final String[] ALLOWED_ORIGINS = {
			"https://localhost:5173",
			"http://localhost:5173",
			"https://voluntracker.app",
			"https://www.voluntracker.app",
			"http://voluntracker.com",
			"http://www.voluntracker.com",
			"www.voluntracker.com",
			"voluntracker.com",
	};


	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(ALLOWED_ORIGINS));
		configuration.setAllowedMethods(Arrays.asList("*"));
		configuration.setAllowedHeaders(Arrays.asList("*"));
		configuration.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		System.out.println("CorsConfigurationSource is created");
		return source;
	}


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.cors().configurationSource(corsConfigurationSource());
		http
				.csrf().disable()
				.authorizeHttpRequests((request) -> {
					try {
						request
								.requestMatchers(AUTH_WHITELIST)
								.permitAll()
								.anyRequest().authenticated()
								.and()
								.sessionManagement()
								.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
								.and()
								.authenticationProvider(authenticationProvider());
					} catch (Exception e) {
						e.printStackTrace();
					}

				});
		// http.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}


	@Bean
	public AuthenticationProvider authenticationProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(jwtUserService);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}

}