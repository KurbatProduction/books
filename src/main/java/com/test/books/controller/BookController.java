package com.test.books.controller;

import com.test.books.dto.BookDataDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Book Controller")
@RequestMapping("/api/v1/books")
public interface BookController {

    @PostMapping
    @Operation(summary = "Create a book")
    @ApiResponse(responseCode = "201", description = "Book has been created successfully")
    ResponseEntity<Void> postBook(@Valid @RequestBody BookDataDto.Request body);

    @GetMapping
    @Operation(summary = "Get a list of existing books")
    ResponseEntity<BookDataDto.ListResponse> getBooks();

    @GetMapping("/{id}")
    @Operation(summary = "Get an existing books by id")
    ResponseEntity<BookDataDto.Response> getBook(@RequestParam("id") UUID id);

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing books by id")
    ResponseEntity<Void> putBook(
            @RequestParam("id") UUID id, @Valid @RequestBody BookDataDto.Request body);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an existing books by id")
    ResponseEntity<Void> deleteBook(@RequestParam("id") UUID id);

}
