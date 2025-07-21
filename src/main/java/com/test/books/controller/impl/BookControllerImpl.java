package com.test.books.controller.impl;

import com.test.books.controller.BookController;
import com.test.books.dto.BookDataDto;
import com.test.books.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

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
}
