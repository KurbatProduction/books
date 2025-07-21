package com.test.books.service;

import com.test.books.dto.BookDataDto;

public interface BookService {

    void createBook(BookDataDto.Request dto);

    BookDataDto.ListResponse getBooks();
}
