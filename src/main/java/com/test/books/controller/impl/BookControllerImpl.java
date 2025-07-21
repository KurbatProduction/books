package com.test.books.controller.impl;

import com.test.books.controller.BookController;
import com.test.books.dto.BookDataDto;
import com.test.books.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public ResponseEntity<Void> postBook(BookDataDto.Request body) {
        bookService.createBook(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<BookDataDto.ListResponse> getBooks() {
        return ResponseEntity.ok(bookService.getBooks());
    }

    @Override
    public ResponseEntity<BookDataDto.Response> getBook(UUID id) {
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @Override
    public ResponseEntity<Void> putBook(UUID id, BookDataDto.Request body) {
        bookService.updateBook(id, body);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteBook(UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
