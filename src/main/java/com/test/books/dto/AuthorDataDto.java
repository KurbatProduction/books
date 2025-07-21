package com.test.books.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AuthorDataDto(
        @Pattern(regexp = "^\\S+$", message = "Author's name must not contain whitespace")
                @Size(min = 1, max = 50)
                @NotBlank
                String username) {}
