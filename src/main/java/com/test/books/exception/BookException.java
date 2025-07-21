package com.test.books.exception;

import com.test.books.enums.BookExceptionEnum;
import lombok.Getter;

@Getter
public class BookException extends RuntimeException {

    private final BookExceptionEnum bookExceptionEnum;

    public BookException(BookExceptionEnum bookExceptionEnum) {
        super(bookExceptionEnum.getErrorMessage());
        this.bookExceptionEnum = bookExceptionEnum;
    }
}
