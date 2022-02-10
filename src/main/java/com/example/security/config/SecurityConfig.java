package com.example.security.config;

import com.example.security.domain.user.LoginUserDetailsServiceImpl;
import com.example.security.security.CustomLoginFailureHandler;
import com.example.security.security.CustomLoginSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  final LoginUserDetailsServiceImpl loginUserDetailsService;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(loginUserDetailsService).passwordEncoder(passwordEncoder());
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
                    .successHandler(authenticationSuccessHandler())
                    .failureHandler(authenticationFailureHandler())
                    .loginPage("/user/login")
                    .failureUrl("/user/login-error")
                    .loginProcessingUrl("/user/login-process")
                    .usernameParameter("userid")
                    .passwordParameter("password"));
    http.csrf().disable();
    http.headers().frameOptions().disable();
    http.logout().logoutUrl("/user/logout").logoutSuccessUrl("/").permitAll();
  }

  //  @Bean
  //  @Override
  //  public UserDetailsService userDetailsService() {
  //    UserDetails userDetails =
  //        User.withUsername("test")
  //            .password(passwordEncoder().encode("test1234"))
  //            .roles("USER")
  //            .build();
  //    return new InMemoryUserDetailsManager(userDetails);
  //  }

  //  @Bean
  //  public DaoAuthenticationProvider authenticationProvider() {
  //    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
  //    authenticationProvider.setUserDetailsService(userDetailsService());
  //    authenticationProvider.setPasswordEncoder(passwordEncoder());
  //    return authenticationProvider;
  //  }
  //
  @Bean
  public UserDetailsService userDetailsService() {
    return loginUserDetailsService;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationSuccessHandler authenticationSuccessHandler() {
    return new CustomLoginSuccessHandler();
  }

  @Bean
  public AuthenticationFailureHandler authenticationFailureHandler() {
    return new CustomLoginFailureHandler();
  }
}
