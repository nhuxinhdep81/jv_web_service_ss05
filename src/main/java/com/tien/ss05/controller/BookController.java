package com.tien.ss05.controller;

import com.tien.ss05.model.dto.response.DataResponse;
import com.tien.ss05.model.entity.Book;
import com.tien.ss05.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Book>>> getAllBooks() {
        return new ResponseEntity<>(new DataResponse<>(bookService.getAllBooks(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<DataResponse<Book>> getBookById(@PathVariable Integer bookId) {
        return new ResponseEntity<>(new DataResponse<>(bookService.getBookById(bookId), HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Book>> addBook(@RequestBody Book book) {
        return new ResponseEntity<>(new DataResponse<>(bookService.save(book), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DataResponse<Book>> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(new DataResponse<>(bookService.update(book), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        return new ResponseEntity<>(new DataResponse<>(bookService.delete(bookId), HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
    }

    @GetMapping("books-by-name/{bookName}")
    public ResponseEntity<DataResponse<List<Book>>> getBooksByBookName(@PathVariable String bookName) {
        return new ResponseEntity<>(new DataResponse<>(bookService.getBoooksByBookName(bookName), HttpStatus.OK), HttpStatus.OK);
    }


}
