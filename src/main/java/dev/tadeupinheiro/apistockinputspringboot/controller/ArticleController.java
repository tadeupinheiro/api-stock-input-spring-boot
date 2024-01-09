package dev.tadeupinheiro.apistockinputspringboot.controller;

import dev.tadeupinheiro.apistockinputspringboot.dtos.ArticleRecordDto;
import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.models.ProductModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import dev.tadeupinheiro.apistockinputspringboot.service.ArticleService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    ArticleRepository articleRepository;

    @PostMapping
    public ResponseEntity saveArticle (@RequestBody @Valid ArticleRecordDto articleRecordDto){
        var articleModel = new ArticleModel();
        if(articleService.existsByArticleCode(articleRecordDto.articleCode())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Article already exists");
        }
        BeanUtils.copyProperties(articleRecordDto, articleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleRepository.save(articleModel));
    }

    @GetMapping
    public ResponseEntity<List<ArticleModel>> getAllArticles (){
        return ResponseEntity.status(HttpStatus.OK).body(articleRepository.findAll());
    }

    @GetMapping("/{articleCode}")
    public ResponseEntity<Object> getOneArticle(@PathVariable(value = "articleCode") Integer id){
        Optional<ArticleModel> articleModelOptional = articleRepository.findById(id);
        if(articleModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the article not is possible, because it no exist.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(articleModelOptional.get());
    }

}
