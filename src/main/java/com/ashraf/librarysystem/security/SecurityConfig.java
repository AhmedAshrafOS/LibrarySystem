package com.ashraf.librarysystem.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {



    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/books").hasRole("MEMBER")
                        .requestMatchers(HttpMethod.GET, "/api/books/**").hasRole("MEMBER")
                        .requestMatchers(HttpMethod.POST, "/api/books").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/books/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/patrons").hasRole("MEMBER")
                        .requestMatchers(HttpMethod.GET, "/api/patrons/**").hasRole("MEMBER")
                        .requestMatchers(HttpMethod.POST, "/api/patrons").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/patrons/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/patrons/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/record/*/patron/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/record/*/patron/**").hasRole("ADMIN")
                );


        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf->csrf.disable());


        return http.build();
    }




}



























































//FOR REFRENCE     @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails ahmed = User.builder()
//                .username("ahmed")
//                .password("{noop}ahmedxd")
//                .roles("MEMBER","MANAGER","ADMIN")
//                .build();
//
//
//        UserDetails libirayEmployee = User.builder()
//                .username("employee")
//                .password("{noop}employee")
//                .roles("MEMBER","MANAGER")
//                .build();
//
//        UserDetails patronMember = User.builder()
//                .username("patron")
//                .password("{noop}patron")
//                .roles("MEMBER")
//                .build();
//        return new InMemoryUserDetailsManager(ahmed, libirayEmployee, patronMember);
//    }



