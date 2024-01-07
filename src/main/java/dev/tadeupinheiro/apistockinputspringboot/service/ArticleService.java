package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService (ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
}
