package com.academy.service;

import com.academy.model.entity.Book;
import java.util.ArrayList;
import java.util.List;

public class BookService {

  public List<Book> getBooks() {
    List<Book> books = new ArrayList<>();

    Book book = new Book("Title1", 2000, null);
    Book book1 = new Book("Title2", 2010, null);
    Book book2 = new Book("Title3", 1990, null);

    books.add(book);
    books.add(book1);
    books.add(book2);

    return books;
  }
}
