package dev.tadeupinheiro.apistockinputspringboot.controller;


import dev.tadeupinheiro.apistockinputspringboot.service.ArticleService;
import dev.tadeupinheiro.apistockinputspringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ArticleService articleService;
}
