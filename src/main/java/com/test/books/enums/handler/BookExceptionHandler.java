package com.test.books.enums.handler;

import com.test.books.dto.ExceptionDto;
import com.test.books.enums.BookExceptionEnum;
import com.test.books.exception.BookException;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
public class BookExceptionHandler {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<ExceptionDto> handleBookException(BookException exception) {
        BookExceptionEnum BookExceptionEnum = exception.getBookExceptionEnum();
        ExceptionDto exceptionDto =
                ExceptionDto.builder()
                        .errorName(BookExceptionEnum.name())
                        .errorMessage(BookExceptionEnum.getErrorMessage())
                        .build();
        return ResponseEntity.status(BookExceptionEnum.getStatusCode()).body(exceptionDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<String> fieldErrors =
                exception.getBindingResult().getFieldErrors().stream()
                        .map(
                                field ->
                                        String.format(
                                                "Field '%s': %s",
                                                field.getField(), field.getDefaultMessage()))
                        .toList();
        String errorMessage = String.join("; ", fieldErrors);
        ExceptionDto exceptionDto =
                ExceptionDto.builder()
                        .errorName(BookExceptionEnum.BAD_REQUEST.name())
                        .errorMessage(errorMessage)
                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionDto> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException exception) {
        String errorMessage =
                String.format("Required parameter '%s' is not valid", exception.getParameterName());

        ExceptionDto exceptionDto =
                ExceptionDto.builder()
                        .errorName(BookExceptionEnum.BAD_REQUEST.name())
                        .errorMessage(errorMessage)
                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDto> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException exception) {
        String errorMessage = "Invalid JSON format. " + exception.getMessage();

        ExceptionDto exceptionDto =
                ExceptionDto.builder()
                        .errorName(BookExceptionEnum.BAD_REQUEST.name())
                        .errorMessage(errorMessage)
                        .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
}
