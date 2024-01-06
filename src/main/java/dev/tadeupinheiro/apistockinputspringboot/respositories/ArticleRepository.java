package dev.tadeupinheiro.apistockinputspringboot.respositories;

import dev.tadeupinheiro.apistockinputspringboot.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleModel, UUID> {
}
