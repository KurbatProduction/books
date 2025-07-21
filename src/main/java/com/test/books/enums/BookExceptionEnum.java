package com.test.books.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BookExceptionEnum {
    BAD_REQUEST(400, "Request body is not valid"),
    NOT_FOUND_BOOK(404, "Book wasn't found by id");

    private final int statusCode;
    private final String errorMessage;
}
