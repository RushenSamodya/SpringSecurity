package com.rushen.SpringSecurity.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){

        UserDetails admin = User.withUsername("admin")
                                .password(encoder.encode("admin123"))
                                .authorities("ROLE_ADMIN")
                                .build();

        UserDetails user = User.withUsername("user")
                                .password(encoder.encode("user123"))
                                .authorities("ROLE_USER")
                                .build();

        return new InMemoryUserDetailsManager(admin,user);

    }


    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/api/v1/auth/admin/login").hasAuthority("ROLE_ADMIN")
                        .requestMatchers("/api/v1/auth/user/login").hasAuthority("ROLE_USER")
                        .anyRequest().authenticated()
                )
        .httpBasic(Customizer.withDefaults());


        return http.build();
    }
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
