package com.academy.service;

import com.academy.model.entity.Author;
import com.academy.model.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class AuthorService {
  public List<Author> getAuthors() {
    var authors = new ArrayList<Author>();

    var author = new Author("Ivan");
    var author1 = new Author("Petya");
    var author2 = new Author("Sergei");

    authors.add(author);
    authors.add(author1);
    authors.add(author2);

    return authors;
  }
}
