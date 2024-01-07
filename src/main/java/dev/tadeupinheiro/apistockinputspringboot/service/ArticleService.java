package dev.tadeupinheiro.apistockinputspringboot.service;

import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ArticleService {

    final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    public double settingWidthByPattern(UUID articleCode, double size, double weigth){
        Optional<ArticleModel> article = articleRepository.findById(articleCode);
        double widthTemp = article.get().getWidth();
        double widthFinal = size * weigth * (widthTemp/1000);
        return widthFinal;
    };


    public boolean existsArticleCode(UUID articleCode){
        return articleRepository.existsByArticleCode(articleCode);
    };
}
