package com.test.books.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Book Controller")
@RequestMapping("/api/v1/books")
public interface BookController {

    @PostMapping("/test")
    @Operation(summary = "Test handler")
    ResponseEntity<String> test();
}
