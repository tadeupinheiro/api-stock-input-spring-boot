package dev.tadeupinheiro.apistockinputspringboot;

import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import dev.tadeupinheiro.apistockinputspringboot.models.ColorModel;
import dev.tadeupinheiro.apistockinputspringboot.models.ProductModel;
import dev.tadeupinheiro.apistockinputspringboot.models.RollModel;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ArticleRepository;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ColorRepository;
import dev.tadeupinheiro.apistockinputspringboot.respositories.ProductRepository;
import dev.tadeupinheiro.apistockinputspringboot.respositories.RollRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class CompositionTest {
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private RollRepository rollRepository;
    @Autowired
    private ProductRepository productRepository;

    /**
     * Fluxo da API:
     * 1. Criar uma Cor
     * 2. Criar um Artigo contendo sua respectiva Cor
     * 3. Criar varios Rolos contendo seus respectivos Artigo
     * 4. Criar um Produto contendo seus respectives Rolos
     */
    @Test
    void createProduct() {
        // 1. Criar uma Cor
        var color = new ColorModel();
        color.setColorCode(UUID.randomUUID());
        color.setColorName("Pantone Mango Tango");
        colorRepository.save(color);
        // 2. Criar um Artigo contendo sua respectiva Cor
        var article = new ArticleModel();
        article.setArticleCode(UUID.randomUUID());
        article.setArticleName("Soft cotton");
        article.setCor(color);
        articleRepository.save(article);
        // 3. Criar varios Rolos contendo seus respectivos Artigo
        var roll = new RollModel();
        roll.setRollNumber(UUID.randomUUID());
        roll.setArticle(article);
        rollRepository.save(roll);
        // 4. Criar um Produto contendo seus respectives Rolos
        var product = new ProductModel();
        product.setId(UUID.randomUUID());
        product.getRolls().add(roll);
        productRepository.save(product);
    }
}
