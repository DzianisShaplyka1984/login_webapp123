package com.academy;

import com.academy.model.entity.User;
import com.academy.service.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String login = req.getParameter("login");
    String password = req.getParameter("password");

    User user = new User(login, password);

    PrintWriter writer = resp.getWriter();

    writer.println("<html>");
    writer.println("<body>");

    LoginService loginService = new LoginService();

    if (loginService.checkCredentials(login, password)) {

      writer.println("Hello " + login + "!");

      HttpSession session = req.getSession();

      session.setAttribute("user", user);

      Cookie cookie = new Cookie("login", login);
      cookie.setMaxAge(100000);
      Cookie cookie1 = new Cookie("password", password);

      resp.addCookie(cookie);
      resp.addCookie(cookie1);

    } else {
      writer.println("Access denied");
    }

    writer.println("</body>");
    writer.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String body = req.getReader().lines().collect(Collectors.joining());

    String[] parameters = body.split("&");

    String login = parameters[0].substring(parameters[0].indexOf("=")+1);
    String password = parameters[1].substring(parameters[1].indexOf("=")+1);

    PrintWriter writer = resp.getWriter();

    resp.setContentType("text/html");

    writer.println("<html>");
    writer.println("<body>");

    if ("qwerty".equalsIgnoreCase(login) && "12345".equalsIgnoreCase(password)) {
      writer.println("Hello " + login + "!");
    } else {
      writer.println("Access denied");
    }

    writer.println("</body>");
    writer.println("</html>");
  }
}
