package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class RollModel {

    @Id
    private UUID rollNumber;

    @Nullable
    private double size;

    @Nullable
    private double weigth;

    @Nullable
    private String treatment;

    @ManyToOne
    private ArticleModel article;


    public UUID getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(UUID rollNumber) {
        this.rollNumber = rollNumber;
    }

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

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public ArticleModel getArticle() {
        return article;
    }

    public void setArticle(ArticleModel article) {
        this.article = article;
    }
}
