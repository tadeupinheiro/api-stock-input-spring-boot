package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS_IN_STOCK")
public class ProductModel {

    @Id
    private Integer rollNumber;

    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false) //Define o nome da coluna da chave estrangeira
    private ArticleModel articleRelationship;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false) //Define o nome da coluna da chave estrangeira
    private ColorModel colorRelationship;

    @Nullable
    private double size;

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

    public Integer getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(Integer rollNumber) {
        this.rollNumber = rollNumber;
    }
    @Nullable
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    @Nullable
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(@Nullable String treatment) {
        this.treatment = treatment;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    @Nullable
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(@Nullable String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Nullable
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(@Nullable String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Nullable
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(@Nullable String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public ArticleModel getArticleRelationship() {
        return articleRelationship;
    }

    public void setArticleRelationship(ArticleModel articleRelationship) {
        this.articleRelationship = articleRelationship;
    }

    public ColorModel getColorRelationship() {
        return colorRelationship;
    }

    public void setColorRelationship(ColorModel colorRelationship) {
        this.colorRelationship = colorRelationship;
    }
}
