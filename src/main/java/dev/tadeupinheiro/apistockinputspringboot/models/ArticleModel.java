package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_ARTICLE_MODEL")
public class ArticleModel {

    @Id
    private UUID articleCode;

    @Nullable
    private String articleName;

    @OneToMany(mappedBy = "articleRelationship")
    private List<ProductModel> productModel;

    @Nullable
    private String composition;

    @Nullable
    private String quality;

    @Nullable
    private String manufacturer;

    @Nullable
    private double width;

    public UUID getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(UUID articleCode) {
        this.articleCode = articleCode;
    }

    @Nullable
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(@Nullable String articleName) {
        this.articleName = articleName;
    }


    @Nullable
    public String getComposition() {
        return composition;
    }

    public void setComposition(@Nullable String composition) {
        this.composition = composition;
    }

    @Nullable
    public String getQuality() {
        return quality;
    }

    public void setQuality(@Nullable String quality) {
        this.quality = quality;
    }

    @Nullable
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(@Nullable String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
