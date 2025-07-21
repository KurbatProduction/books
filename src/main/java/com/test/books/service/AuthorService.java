package com.test.books.service;

import com.test.books.dto.AuthorDataDto;
import com.test.books.entity.Author;

public interface AuthorService {

    Author getOrCreateAuthor(AuthorDataDto.Request name);
}
