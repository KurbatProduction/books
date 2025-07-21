package com.test.books.service;

import com.test.books.dto.BookDataDto;

import java.util.UUID;

public interface BookService {

    void createBook(BookDataDto.Request dto);

    BookDataDto.ListResponse getBooks();

    BookDataDto.Response getBook(UUID id);

    void updateBook(UUID id, BookDataDto.Request dto);

    void deleteBook(UUID id);
}
