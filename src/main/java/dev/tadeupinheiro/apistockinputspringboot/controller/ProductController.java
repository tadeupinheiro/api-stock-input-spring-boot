package dev.tadeupinheiro.apistockinputspringboot.controller;


import dev.tadeupinheiro.apistockinputspringboot.dtos.ProductRecordDto;
import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.models.ProductModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ColorRepository;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ProductRepository;
import dev.tadeupinheiro.apistockinputspringboot.service.ArticleService;
import dev.tadeupinheiro.apistockinputspringboot.service.ColorService;
import dev.tadeupinheiro.apistockinputspringboot.service.ProductService;
import jakarta.validation.Valid;
import org.hibernate.dialect.function.array.JsonArrayViaElementArgumentReturnTypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stockproducts")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ColorService colorService;
    @Autowired
    ColorRepository colorRepository;

    @PostMapping
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        productModel.rollModel.setRollNumber(productRecordDto.rollNumber());
        productModel.rollModel.setCostPrice(productRecordDto.costPrice());
        productModel.rollModel.setTreatment(productRecordDto.treatment());
        productModel.rollModel.setWeigth(productRecordDto.weigth());
        productModel.rollModel.setInvoiceDate(productRecordDto.invoiceDate());
        productModel.rollModel.setInvoiceNumber(productRecordDto.invoiceNumber());
        productModel.rollModel.setOrderNumber(productRecordDto.orderNumber());
        productModel.rollModel.setSize(productRecordDto.size());
        if(articleService.existsArticleCode(productRecordDto.articleCode())){
            Optional<ArticleModel> articleTemp = articleRepository.findById(productRecordDto.articleCode());
            productModel.articleModel.setArticleCode(articleTemp.get().getArticleCode());
            productModel.articleModel.setArticleName(articleTemp.get().getArticleName());
            productModel.articleModel.setComposition(articleTemp.get().getComposition());
            productModel.articleModel.setManufacturer(articleTemp.get().getManufacturer());

            productModel.articleModel.setQuality(productRecordDto.quality());
            productModel.articleModel.setWidth(articleService.settingWidthByPattern(productRecordDto.articleCode(), productRecordDto.size(), productRecordDto.weigth()));
        } else {
            productModel.articleModel.setArticleCode(productRecordDto.articleCode());
            productModel.articleModel.setArticleName("DEFAULT");
            productModel.articleModel.setComposition("DEFAULT");
            productModel.articleModel.setManufacturer("DEFAULT");
        }
        productModel.colorModel.setColorCode(productRecordDto.colorCode());
        if(colorService.existsColorCode(productRecordDto.colorCode())){
            productModel.colorModel.setColorName(colorRepository.findById(productRecordDto.colorCode()).get().getColorName().toString());
        } else {
            productModel.colorModel.setColorName("DEFAULT"); //Introduzir método para configurar a cor na hora depois
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
}
