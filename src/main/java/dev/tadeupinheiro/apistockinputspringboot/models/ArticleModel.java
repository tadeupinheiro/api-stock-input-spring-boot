package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ARTICLE_MODEL")
public class ArticleModel {

    @Id
    private String articleCode;

    @Nullable
    private String articleName;

    @Nullable
    private String colorCode;

    @Nullable
    private String colorName;

    @Nullable
    private String composition;

    @Nullable
    private String quality;

    @Nullable
    private String manufacturer;

    @Nullable
    private double width;
}
