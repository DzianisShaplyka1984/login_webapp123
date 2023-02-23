package com.academy.filter;

import com.academy.model.entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    var httpServletRequest = (HttpServletRequest) servletRequest;

    var url = httpServletRequest.getRequestURL().toString();

    var session = httpServletRequest.getSession();

    User user = (User) session.getAttribute("user");

    if ((user != null) || url.contains("/login") || url.contains("/loginForm")) {
      filterChain.doFilter(servletRequest, servletResponse);
    } else {
      servletRequest.getRequestDispatcher("/loginForm").forward(servletRequest, servletResponse);
    }
  }
}
