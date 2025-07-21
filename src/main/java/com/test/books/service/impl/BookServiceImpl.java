package com.test.books.service.impl;

import com.test.books.dto.BookDataDto;
import com.test.books.entity.Author;
import com.test.books.entity.Book;
import com.test.books.mapper.BookMapper;
import com.test.books.repository.BookRepository;
import com.test.books.service.AuthorService;
import com.test.books.service.BookService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public void createBook(BookDataDto.Request dto) {
        Author author = authorService.getOrCreateAuthor(dto.author());
        Book newBook = bookMapper.toBook(dto, author);
        bookRepository.save(newBook);
    }

    @Override
    public BookDataDto.ListResponse getBooks() {
        List<Book> bookList = bookRepository.findAllBooks();
        return BookDataDto.ListResponse.builder()
                .books(bookMapper.toBookDataDtoResponseList(bookList))
                .build();
    }
}
