package com.college.library.config;

import com.college.library.Jwtfilter;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public  PasswordEncoder ps() throws Exception{
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain sfc(HttpSecurity http, Jwtfilter jwtF) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors->cors.configurationSource(corsconf()))
                .authorizeHttpRequests((auth)->
                 auth.requestMatchers("/auth/**").permitAll().anyRequest()
                .authenticated()).addFilterBefore(jwtF, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsconf(){
        CorsConfiguration conf=new CorsConfiguration();
        conf.setAllowedOrigins(List.of("*"));
        conf.setAllowedMethods(List.of("POST","PUT","PATCH","DELETE","GET"));
        conf.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",conf);

        return source;
    }
}
