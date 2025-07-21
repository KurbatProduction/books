package com.test.books.repository;

import com.test.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {

    @Query(
            "SELECT b FROM Book b "
                    + "JOIN FETCH Author a ON a = b.authorId "
                    + "ORDER BY b.createDate")
    List<Book> findAllBooks();
}
