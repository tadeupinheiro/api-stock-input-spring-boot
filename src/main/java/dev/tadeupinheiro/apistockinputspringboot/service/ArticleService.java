package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Transactional
    public void deleteArticle(ArticleModel articleModel){
        this.articleRepository.delete(articleModel);
    }

    @Transactional
    public ArticleModel saveArticle(ArticleModel articleModel){
        this.articleRepository.save(articleModel);
        return articleModel;
    }

    public Optional<ArticleModel> findArticle(Integer idArticle){
        Optional<ArticleModel> articleModel = this.articleRepository.findById(idArticle);
        return articleModel;
    }

    public List<ArticleModel> findAllArticles(){
        List<ArticleModel> articleModelList = articleRepository.findAll();
        return articleModelList;
    }
}
