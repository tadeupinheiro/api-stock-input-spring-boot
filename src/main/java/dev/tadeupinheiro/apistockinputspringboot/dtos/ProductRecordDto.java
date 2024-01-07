package dev.tadeupinheiro.apistockinputspringboot.dtos;

import jakarta.annotation.Nullable;

import java.util.UUID;

public record ProductRecordDto(
        @Nullable UUID rollNumber,
        @Nullable UUID articleCode,
        @Nullable UUID colorCode,
        @Nullable double size,
        @Nullable String quality,
        @Nullable double weigth,
        String treatment, //COLOCAR DEFAULT
        @Nullable double costPrice,
        @Nullable String orderNumber,
        @Nullable String invoiceNumber,
        @Nullable String invoiceDate
) {
}
