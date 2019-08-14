package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    @Query("SELECT x FROM Book x WHERE " +
            "(x.status, x.publishDate) in " +
            "(SELECT j.status, j.publishDate FROM Book j WHERE j.status=?1) " +
            "or (x.status, x.publishDate) in " +
            "(SELECT k.status, k.publishDate FROM Book k WHERE k.publishDate >= sysdate-1) ")
    List<Book> findAllWithStatusAndPublishedInYear(String status);
}
