package com.test.books.dto;

import lombok.Builder;

@Builder
public record ExceptionDto(String errorName, String errorMessage) {}
