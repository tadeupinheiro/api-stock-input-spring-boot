package dev.tadeupinheiro.apistockinputspringboot.controller;


import dev.tadeupinheiro.apistockinputspringboot.dtos.ProductRecordDto;
import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.models.ColorModel;
import dev.tadeupinheiro.apistockinputspringboot.models.ProductModel;
import dev.tadeupinheiro.apistockinputspringboot.service.ArticleService;
import dev.tadeupinheiro.apistockinputspringboot.service.ColorService;
import dev.tadeupinheiro.apistockinputspringboot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ColorService colorService;

    @PostMapping
    public ResponseEntity saveColor (@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        if(productService.existsByRollNumber(productRecordDto.rollNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Product already exists");
        }
        BeanUtils.copyProperties(productRecordDto, productModel);
        Optional<ArticleModel> articleModelOptional = articleService.findArticle(productRecordDto.articleId());
        productModel.setArticleRelationship(articleModelOptional.get());
        Optional<ColorModel> colorModelOptional = colorService.findColor(productRecordDto.colorId());
        productModel.setColorRelationship(colorModelOptional.get());

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(productModel));
    }

    @GetMapping
        public ResponseEntity<List<ProductModel>> getAllProducts (){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAllProducts());
    }

    @GetMapping("/{rollNumber}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "rollNumber") Integer rollNumber){
        Optional<ProductModel> productModelOptional = productService.findProduct(rollNumber);
        if(productModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the product not is possible, because it no exist.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(productModelOptional.get());
    }

    @PutMapping("/{rollNumber}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "rollNumber") Integer rollNumber,
                                              @RequestBody @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> productModelOptional = productService.findProduct(productRecordDto.rollNumber());
        if(productModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You can't update this product, her not exist.");
        }
        var productModelFinal = productModelOptional.get();
        BeanUtils.copyProperties(productRecordDto, productModelFinal);
        return ResponseEntity.status(HttpStatus.OK).body(productService.saveProduct(productModelFinal));
    }

    @DeleteMapping("/{rollNumber}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "rollNumber") Integer rollNumber){
        if (!productService.existsByRollNumber(rollNumber)){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not is possible delete this product, her not was found.");
        }
        Optional<ProductModel> productModelOptional = productService.findProduct(rollNumber);
        productService.deleteProduct(productModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product from code " + rollNumber + " was delete with success.");
    }

}
