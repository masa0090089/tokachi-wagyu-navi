package com.example.tokachi_wagyu_navi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF保護を無効化
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/shops").permitAll() // 一覧取得は誰でもOK
                        .anyRequest().authenticated() // それ以外は認証が必要
                )
                .httpBasic(httpBasic -> {}); // Basic認証を有効化

        return http.build();
    }
}