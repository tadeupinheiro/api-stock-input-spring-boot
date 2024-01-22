package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.models.ProductModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public boolean existsByRollNumber(Integer rollNumber) {
        return this.productRepository.existsById(rollNumber);
    }

    @Transactional
    public ProductModel saveProduct(ProductModel productModel) {
        this.productRepository.save(productModel);
        return productModel;
    }

    public List<ProductModel> findAllProducts() {
        List<ProductModel> productModelList = productRepository.findAll();
        return productModelList;
    }

    public Optional<ProductModel> findProduct(Integer rollNumber) {
        Optional<ProductModel> productModelOptional = this.productRepository.findById(rollNumber);
        return productModelOptional;
    }

    public void deleteProduct(ProductModel productModel) {
        this.productRepository.delete(productModel);
    }
}
