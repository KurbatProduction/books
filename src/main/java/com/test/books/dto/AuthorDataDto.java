package com.test.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

public record AuthorDataDto() {

    @Builder
    @Schema(
            name = "AuthorDataRequest",
            example =
                    """
                    {
                      "name": "Alan Wake"
                    }
                    """)
    public record Request(@Size(min = 1, max = 50) @NotBlank String name) {}

    @Builder
    @Schema(
            name = "AuthorDataRequest",
            example =
                    """
                    {
                      "id": "8b0b1f7d-c646-4704-b31c-c7e5a09e2c83",
                      "name": "Alan Wake"
                    }
                    """)
    public record Response(UUID id, String name) {}
}
