package com.dailyspringboot.practice.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration // To let spring know that this file need to be added to the spring context.
@EnableWebSecurity
public class SecurityConfig{

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.auth.anyRequest().permitAll();
//
//        return http.build();
//    }
}
