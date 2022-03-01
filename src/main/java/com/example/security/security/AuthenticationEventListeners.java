package com.example.security.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthenticationEventListeners {

  @EventListener
  public void handleAuthenticationEvent(AbstractAuthenticationEvent event) {
    log.debug("handleAuthenticationEvent : {}", event);
    log.debug("handleAuthenticationEvent : {}", event.getAuthentication());
    log.debug("handleAuthenticationEvent : {}", event.getSource());
  }

  @EventListener
  public void handleBadCredentials(AuthenticationFailureBadCredentialsEvent event) {
    log.debug("handleBadCredentials");
  }

  @EventListener
  public void handleAuthenticationSuccess(AuthenticationSuccessEvent event) {
    log.debug("handleAuthenticationSuccess");
  }
}
