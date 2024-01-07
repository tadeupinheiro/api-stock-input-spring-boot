package dev.tadeupinheiro.apistockinputspringboot.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

import dev.tadeupinheiro.apistockinputspringboot.models.ColorModel;

public interface ColorRepository extends JpaRepository<ColorModel, UUID>{
    boolean existsByColorCode(UUID colorCode);
}
