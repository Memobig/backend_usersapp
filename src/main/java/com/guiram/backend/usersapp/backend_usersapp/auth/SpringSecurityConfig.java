package com.guiram.backend.usersapp.backend_usersapp.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /*return http.authorizeHttpRequests()
        .requestMatchers(HttpMethod.GET, "/users").permitAll()
        .anyRequest().authenticated()
        .and()
        .csrf(config -> config.disable())
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();*/

        http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(HttpMethod.GET, "/users").permitAll()
            .anyRequest().authenticated()
        );

    return http.build();
    }
}