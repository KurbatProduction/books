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
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public BookDataDto.Response getBook(UUID id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new NoSuchElementException("Book wasn't found");
        }
        return bookMapper.toBookDataDtoResponse(bookOptional.get());
    }

    @Override
    @Transactional
    public void updateBook(UUID id, BookDataDto.Request dto) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new NoSuchElementException("Book wasn't found");
        }
        Book book = bookOptional.get();
        Author author = book.getAuthorId();
        if (!dto.author().name().equals(author.getName())) {
            author = authorService.getOrCreateAuthor(dto.author());
        }
        bookMapper.updateBook(book, dto, author);
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
