package dev.tadeupinheiro.apistockinputspringboot.dtos;

import jakarta.annotation.Nullable;

public record ArticleRecordDto(
        @Nullable Integer articleCode,
        @Nullable String articleName,
        @Nullable String composition,
        @Nullable String quality,
        @Nullable String manufacturer,
        @Nullable double width
) {
}
