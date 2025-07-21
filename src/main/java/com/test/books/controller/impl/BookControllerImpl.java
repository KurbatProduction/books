package com.test.books.controller.impl;

import com.test.books.controller.BookController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerImpl implements BookController {

    @Override
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello book");
    }
}
