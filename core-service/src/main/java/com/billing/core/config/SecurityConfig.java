package com.billing.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.csrf().disable()
      .authorizeHttpRequests(a -> a.requestMatchers("/actuator/**","/api/tenants/**","/api/auth/**", "/api/health").permitAll()
                                         .anyRequest().authenticated())
      .addFilterBefore(new JwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)
      ;
    return http.build();
  }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}
