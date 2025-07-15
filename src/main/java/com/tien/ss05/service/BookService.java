package com.tien.ss05.service;

import com.tien.ss05.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book save(Book book);
    Book getBookById(int id);
    Book update(Book book);
    boolean delete(int id);

    List<Book> getBoooksByBookName(String bookName);
}
