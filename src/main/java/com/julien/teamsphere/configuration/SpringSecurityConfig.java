package com.julien.teamsphere.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {

    private DataSource dataSource;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);
//                .authorizeHttpRequests((authorizeHttpRequests) -> {
//                    authorizeHttpRequests
//                            .requestMatchers(
//                                    new AntPathRequestMatcher("api/private/user/register")
//                            ).permitAll()
//                            .requestMatchers(
//                                    new AntPathRequestMatcher("api/private/user/get/**"),
//                                    new AntPathRequestMatcher("api/private/user/delete/**"),
//                                    new AntPathRequestMatcher("api/private/user/update/**")
//                            )
//                                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
//                            .requestMatchers(
//                                    new AntPathRequestMatcher("api/user/get")
//                            )
//                            .hasAuthority("ROLE_ADMIN");
//                })
        return http.build();
    }}
