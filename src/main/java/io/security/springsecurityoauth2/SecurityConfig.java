package io.security.springsecurityoauth2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@Configuration
public class SecurityConfig{

//    @Bean
//    SecurityFilterChain securityFilterChain1(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeRequests().anyRequest().authenticated();
//        httpSecurity.formLogin();
////        httpSecurity.apply(new CustomSecurityConfigurer().setFlag(true));//커스텀 초기클래스
//        return httpSecurity.build();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain2(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.authorizeRequests().anyRequest().authenticated();
//        httpSecurity.httpBasic();
//        //커스텀하게 필터체인을 만드는경우 default필터체인을 타지않는다 이렇게 하면 securityFilterChain에 2개가 생성되면서
//        //filterChainProxy에서 모든 권한을 가지고 관리하게된다.
//
//        return httpSecurity.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().anyRequest().authenticated();//해당것만 실행한다면 어떠한 인증방식도 하지않아서, 403에러발생한다.
        //formlogin인증방식
        httpSecurity.formLogin();//login창 노출되는데 해당 창으로 이동을 시켜주느것이 authenticationEntryPoint의 역할이다.
        //httpBasic인증방식
        httpSecurity.httpBasic();//팝업창뜨면서 httpBasic에서 로그인할수있도록 해준다 이것도 EntryPoint가 해준 행동
        //위 상태로만 실행한다면, formLogin방식을 실행시켜준다.

//        httpSecurity.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
//            @Override
//            public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                System.out.println("custom entryPoint");
//            }
//        });//custom하게 설정한 authenticationEntryPoint를 가장먼저 실행시켜준다.
        return httpSecurity.build();
    }
}
