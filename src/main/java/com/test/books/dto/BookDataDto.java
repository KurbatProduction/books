package com.test.books.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

public record BookDataDto() {

    @Builder
    @Schema(
            name = "BookDataRequest",
            example =
                    """
                    {
                      "title": "new title",
                      "description": "new description",
                      "price": 10,
                      "author": {
                        "name": "Alan Wake"
                      }
                    }
                    """)
    public record Request(
            @Size(min = 1, max = 50) @NotBlank String title,
            String description,
            @NotNull @Positive @Max(value = Integer.MAX_VALUE) Integer price,
            @NotNull @Valid AuthorDataDto.Request author) {}

    @Builder(toBuilder = true)
    @Schema(
            name = "BookDataResponse",
            example =
                    """
                    {
                      "id": "8350eec6-a3fb-458a-9c29-f6c2c541a24b",
                      "title": "new title",
                      "description": "new description",
                      "price": 10,
                      "author": {
                        "id": "8b0b1f7d-c646-4704-b31c-c7e5a09e2c83",
                        "name": "Alan Wake"
                      }
                    }
                    """)
    public record Response(
            UUID id,
            String title,
            Integer price,
            AuthorDataDto.Response author,
            ZonedDateTime createDate,
            ZonedDateTime updateDate) {}

    @Builder(toBuilder = true)
    @Schema(
            name = "BookDataListResponse",
            example =
                    """
                    {
                      "books": [
                        "id": "8350eec6-a3fb-458a-9c29-f6c2c541a24b",
                        "title": "new title",
                        "description": "new description",
                        "price": 10,
                        "author": {
                          "id": "8b0b1f7d-c646-4704-b31c-c7e5a09e2c83",
                          "name": "Alan Wake"
                        }
                      ]
                    }
                    """)
    public record ListResponse(List<Response> books) {}
}
