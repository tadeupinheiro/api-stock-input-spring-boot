package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService (ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public boolean existsByArticleCode(Integer idArticle) {
        return this.articleRepository.existsById(idArticle);
    }

    public void deleteArticle(ArticleModel articleModel){
        this.articleRepository.delete(articleModel);
    }

    public ArticleModel saveArticle(ArticleModel articleModel){
        this.articleRepository.save(articleModel);
        return articleModel;
    }

    public Optional<ArticleModel> findArticle(Integer idArticle){
        Optional<ArticleModel> articleModel = this.articleRepository.findById(idArticle);
        return articleModel;
    }
}
