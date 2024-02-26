package io.security.springsecurityoauth2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig{

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeRequests().anyRequest().authenticated();
        httpSecurity.formLogin();
        httpSecurity.apply(new CustomSecurityConfigurer().setFlag(true));//커스텀 초기클래스

        return httpSecurity.build();
    }
}
