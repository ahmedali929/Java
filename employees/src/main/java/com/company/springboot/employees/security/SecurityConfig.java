package com.company.springboot.employees.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    // add support for JDBC - no more hardcoded users
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, password, active from system_users where user_id=?");

        // define query to retrieve the roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filerChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer -> configurer
                .requestMatchers("/docs/**","/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                .requestMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/h2-console/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole("ADMIN"));

        http.httpBasic(httpBasicCustomizer -> httpBasicCustomizer.disable());

        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        http.exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint(authenticationEntryPoint()));

        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {


        return (request, response, authException) -> {
            // Sends 401 unauthorized status without triggering a basic auth on browser
            response.setStatus(HttpStatus.UNAUTHORIZED.value());

            // Sets the response type to JSON
            response.setContentType("application/json");

            // Prevents browser's authentication popup
            response.setHeader("WWW-Authenticate", "");

            // Writes the error message
            response.getWriter().write("{\"error\": \"Unauthorized Access\"}");
        };
    }

}
