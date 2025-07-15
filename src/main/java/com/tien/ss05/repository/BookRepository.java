package com.tien.ss05.repository;

import com.tien.ss05.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByBookNameContains(String bookName);
}