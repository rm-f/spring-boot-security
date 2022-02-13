package com.example.security.config;

import com.example.security.security.CustomAuthenticationProvider;
import com.example.security.security.CustomUsernamePasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  final CustomAuthenticationProvider provider;
  final AuthenticationSuccessHandler authenticationSuccessHandler;
  final AuthenticationFailureHandler authenticationFailureHandler;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(provider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests(
            (authorize) ->
                authorize
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                    .permitAll()
                    .antMatchers("/", "/v1/**", "/index", "/user/**", "/h2-console/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin(
            (formLogin) ->
                formLogin
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(authenticationFailureHandler)
                    .loginPage("/user/login")
                    .failureUrl("/user/login-error")
                    .loginProcessingUrl("/user/login-process")
                    .usernameParameter("userid")
                    .passwordParameter("password"));
    http.csrf().disable();
    http.headers().frameOptions().disable();
    http.rememberMe().key("2ror220201012").tokenValiditySeconds(60 * 60 * 24);
    http.logout().logoutUrl("/user/logout").logoutSuccessUrl("/").permitAll();

    http.addFilterAt(
        new CustomUsernamePasswordAuthenticationFilter(authenticationManager()),
        UsernamePasswordAuthenticationFilter.class);
  }

}
