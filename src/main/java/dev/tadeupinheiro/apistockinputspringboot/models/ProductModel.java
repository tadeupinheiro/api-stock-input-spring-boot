package dev.tadeupinheiro.apistockinputspringboot.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCTS_IN_STOCK")
public class ProductModel {

    public ArticleModel articleModel;
    public RollModel rollModel;
    public ColorModel colorModel;

    @Id
    private UUID rollProductNumber = rollModel.getRollNumber();
}
