package com.test.books.mapper;

import com.test.books.dto.AuthorDataDto;
import com.test.books.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(AuthorDataDto.Request data);
}
