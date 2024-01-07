package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.respositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
}
