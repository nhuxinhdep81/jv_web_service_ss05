package com.tien.ss05.service;

import com.tien.ss05.model.entity.Book;
import com.tien.ss05.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Book not found"));
    }

    @Override
    public Book update(Book book) {
        bookRepository.findById(book.getBookId()).orElseThrow(()-> new NoSuchElementException("Book not found"));
        return bookRepository.save(book);
    }

    @Override
    public boolean delete(int id) {
        bookRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Book not found"));
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Book> getBoooksByBookName(String bookName) {
        return bookRepository.findBooksByBookNameContains(bookName);
    }

}

