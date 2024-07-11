package me.gijung.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/actuator/**").permitAll() // Actuator 엔드포인트 허용
                                .anyRequest().authenticated() // 다른 모든 요청은 인증 필요
                )
                .csrf(csrf -> csrf.disable()); // CSRF 비활성화

        return http.build();
    }

}