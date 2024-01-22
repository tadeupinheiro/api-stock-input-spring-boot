package dev.tadeupinheiro.apistockinputspringboot.dtos;

import jakarta.annotation.Nullable;

public record ProductRecordDto(
        @Nullable Integer rollNumber,
        @Nullable double size,
        @Nullable double weigth,
        @Nullable String treatment,
        @Nullable double costPrice,
        @Nullable String orderNumber,
        @Nullable String invoiceNumber,
        @Nullable String invoiceDate,
        @Nullable Integer colorId,
        @Nullable Integer articleId

) {
}
