package com.example.config;


import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity        //spring security 를 적용한다는 Annotation
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //requestMatchers : 특정 요청과 일치하는 url에 대해 액세스 설정함
        //permitAll() : 누구나 접근이 가능하게 설정
        //anyRequest() : 설정한 url 이외에 요청에 대해 더 설정하겠다.
        //authenticated() : 별도의 인가는 필요하지 않고 인증이 성공된 상태여야 접근이 가능하다.
        //loginPage() : 로그인 페이지 경로 설정
        //defaultSuccessUrl() : 로그인이 성공했을때 경로 설정
        //logoutSuccessUrl() : 로그아웃이 완료되었을때 이동할 경로 설정
        //invalidateHttpSession(): 로그아웃 완료 후 해당 세션을 전체 삭제할지 여부 설정

        http
                .authorizeRequests()
                .requestMatchers().permitAll()   //특정 요청과 일치하는 url에 대해 액세스 설정함   //설정이안됨 물어봐야됨 /
                .antMatchers( "/login", "/signUp", "/access_denied", "/resources/**").permitAll() // 로그인 권한은 누구나, resources파일도 모든권한
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/user_access")
                .failureUrl("/access_denied") // 인증에 실패했을 때 보여주는 화면 url, 로그인 form으로 파라미터값 error=true로 보낸다.
                .and()
                .csrf().disable();		//로그인 창
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }    //로그인 처리 인증 메소드

}
