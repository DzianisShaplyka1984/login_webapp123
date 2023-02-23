package com.academy;

import com.academy.model.entity.User;
import com.academy.service.AuthorService;
import com.academy.service.BookService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/authors")
public class AuthorServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter writer = resp.getWriter();

    writer.println("<html>");
    writer.println("<body>");

    var authorService = new AuthorService();

    authorService.getAuthors().forEach(author -> {
      writer.println(author.getName());
      writer.println("<br>");
    });

    writer.println("</body>");
    writer.println("</html>");
  }
}
