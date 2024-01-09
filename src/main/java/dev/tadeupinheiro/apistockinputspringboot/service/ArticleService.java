package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService (ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public boolean existsByArticleCode(Integer idArticle) {
        return this.articleRepository.existsById(idArticle);
    }
}
