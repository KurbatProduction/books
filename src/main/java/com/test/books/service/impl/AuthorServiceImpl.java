package com.test.books.service.impl;

import com.test.books.dto.AuthorDataDto;
import com.test.books.entity.Author;
import com.test.books.mapper.AuthorMapper;
import com.test.books.repository.AuthorRepository;
import com.test.books.service.AuthorService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public Author getOrCreateAuthor(AuthorDataDto.Request dto) {
        Optional<Author> authorOptional = authorRepository.findByName(dto.name());
        Author author = null;
        if (authorOptional.isEmpty()) {
            author = authorMapper.toAuthor(dto);
            authorRepository.save(author);
        } else author = authorOptional.get();
        return author;
    }
}
