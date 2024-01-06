package dev.tadeupinheiro.apistockinputspringboot.respositories;

import dev.tadeupinheiro.apistockinputspringboot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {
}
