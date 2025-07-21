package com.test.books.mapper;

import com.test.books.dto.BookDataDto;
import com.test.books.entity.Author;
import com.test.books.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "authorId", source = "author")
    Book toBook(BookDataDto.Request data, Author author);

    List<BookDataDto.Response> toBookDataDtoResponseList(List<Book> bookList);

    @Mapping(target = "author", source = "authorId")
    BookDataDto.Response toBookDataDtoResponse(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    @Mapping(target = "updateDate", ignore = true)
    @Mapping(target = "authorId", source = "author")
    void updateBook(@MappingTarget Book book, BookDataDto.Request dto, Author author);
}
