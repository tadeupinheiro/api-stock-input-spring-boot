package dev.tadeupinheiro.apistockinputspringboot.respositories;

import dev.tadeupinheiro.apistockinputspringboot.models.RollModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RollRepository extends JpaRepository<RollModel, UUID> {
}
