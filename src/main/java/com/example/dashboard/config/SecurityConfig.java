package com.example.dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/api/**", "/actuator/**").permitAll()
        .anyRequest().permitAll()
      )
      .httpBasic(Customizer.withDefaults()); // optional; doesn’t require JwtDecoder

    // IMPORTANT: Do NOT call http.oauth2ResourceServer().jwt() here until Keycloak is ready
    return http.build();
  }
}
