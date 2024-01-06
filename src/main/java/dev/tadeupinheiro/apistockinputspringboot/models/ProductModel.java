package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS_IN_STOCK")
public class ProductModel {

    @Id
    private UUID rollNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_article", nullable = false)
    private ArticleModel articleModel;

    @Nullable
    private double weigth;

    @Nullable
    private String treatment;

    @Nullable
    private double costPrice;

    @Nullable
    private String orderNumber;

    @Nullable
    private String invoiceNumber;

    @Nullable
    private String invoiceDate;
}
