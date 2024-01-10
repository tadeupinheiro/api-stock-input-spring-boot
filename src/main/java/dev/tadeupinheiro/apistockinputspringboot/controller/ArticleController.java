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
    @PostMapping
    public ResponseEntity saveArticle (@RequestBody @Valid ArticleRecordDto articleRecordDto){
        var articleModel = new ArticleModel();
        if(articleService.existsByArticleCode(articleRecordDto.articleCode())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Article already exists");
        }
        BeanUtils.copyProperties(articleRecordDto, articleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.saveArticle(articleModel));
    }

    @GetMapping
    public ResponseEntity<List<ArticleModel>> getAllArticles (){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.findAllArticles());
    }

    @GetMapping("/{articleCode}")
    public ResponseEntity<Object> getOneArticle(@PathVariable(value = "articleCode") Integer id){
        Optional<ArticleModel> articleModelOptional = articleService.findArticle(id);
        if(articleModelOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Get the article not is possible, because it no exist.");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(articleModelOptional.get());
    }

    @PutMapping("/{articleCode}")
    public ResponseEntity<Object> updateArticle(@PathVariable(value = "articleCode") Integer articleCode,
                                                @RequestBody @Valid ArticleRecordDto articleRecordDto){
        Optional<ArticleModel> articleModel = articleService.findArticle(articleRecordDto.articleCode());
        if(articleModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("You can't update this article, her not exist.");
        }
        var articleModelFinal = articleModel.get();
        BeanUtils.copyProperties(articleRecordDto, articleModelFinal);
        return ResponseEntity.status(HttpStatus.OK).body(articleService.saveArticle(articleModelFinal));
    }

    @DeleteMapping("/{articleCode}")
    public ResponseEntity<Object> deleteArticle(@PathVariable(value = "articleCode") Integer articleCode){
        if (!articleService.existsByArticleCode(articleCode)){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not is possible delete this article, her not found.");
        }
        Optional<ArticleModel> articleModel = articleService.findArticle(articleCode);
        articleService.deleteArticle(articleModel.get());
        return ResponseEntity.status(HttpStatus.OK).body("Article from code " + articleCode + "was delete with success.");
    }

}
