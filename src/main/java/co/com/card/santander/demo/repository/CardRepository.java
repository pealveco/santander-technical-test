package co.com.card.santander.demo.repository;

import co.com.card.santander.demo.domain.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {
}
