package com.example.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  //  final LoginUserDetailsServiceImpl loginUserDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests(
            (authorize) ->
                authorize
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                    .permitAll()
                    .antMatchers("/", "/index", "/user/**", "/h2-console/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .formLogin();
    //        .formLogin(
    //            (formLogin) ->
    // formLogin.loginPage("/user/login").failureUrl("/user/login-error"));
    http.csrf().disable();
    http.headers().frameOptions().disable();
  }


  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    UserDetails userDetails =
        User.withUsername("test")
            .password(passwordEncoder().encode("test1234"))
            .roles("USER")
            .build();
    return new InMemoryUserDetailsManager(userDetails);
  }

  //  @Bean
  //  public DaoAuthenticationProvider authenticationProvider() {
  //    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
  //    authenticationProvider.setUserDetailsService(userDetailsService());
  //    authenticationProvider.setPasswordEncoder(passwordEncoder());
  //    return authenticationProvider;
  //  }
  //
  //  @Bean
  //  public UserDetailsService userDetailsService() {
  //    return loginUserDetailsService;
  //  }
  //
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
