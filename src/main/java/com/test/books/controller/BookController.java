package com.test.books.controller;

import com.test.books.dto.BookDataDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Book Controller")
@RequestMapping("/api/v1/books")
public interface BookController {

    @PostMapping("")
    @Operation(summary = "Create a book")
    @ApiResponse(responseCode = "201", description = "Book has been created successfully")
    ResponseEntity<Void> postBook(@Valid @RequestBody BookDataDto.Request body);

    @GetMapping("")
    @Operation(summary = "Get a list of existing books")
    ResponseEntity<BookDataDto.ListResponse> getBooks();
}
