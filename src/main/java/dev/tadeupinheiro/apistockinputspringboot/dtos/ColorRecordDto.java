package dev.tadeupinheiro.apistockinputspringboot.dtos;

import jakarta.annotation.Nullable;

public record ColorRecordDto(
        @Nullable Integer colorCode,
        @Nullable String colorName
) {
}
