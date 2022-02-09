package com.example.security.security;

import java.net.URLDecoder;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {

    log.debug("onAuthenticateionSuccess");

    User user = (User) authentication.getPrincipal();
    log.debug("user: {}, password: {}", user.getUsername(), user.getPassword());

    RequestCache requestCache = new HttpSessionRequestCache();
    SavedRequest savedRequest = requestCache.getRequest(request, response);

    log.debug("authentication : {}", authentication);
    log.debug("requestCache : {}", requestCache);
    log.debug("savedRequest : {}", savedRequest);
    Enumeration<String> enumeration = request.getParameterNames();

    while (enumeration.hasMoreElements()){
      log.debug("parameterName : {} ", enumeration.nextElement());
    }

    clearAuthenticationAttribute(request);

    String redirectUrl = request.getParameter("returnUrl");
    String savedRedirectUrl = (savedRequest == null) ? "/" : savedRequest.getRedirectUrl();
    log.debug("redirectUrl : {}", redirectUrl);
    response.sendRedirect(
        (redirectUrl != null && !"".equals(redirectUrl)) ? URLDecoder.decode(redirectUrl, "utf-8") : savedRedirectUrl);
  }

  private void clearAuthenticationAttribute(HttpServletRequest request) {
    HttpSession httpSession = request.getSession(false);
    if (httpSession == null) {
      return;
    }
    httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }
}
