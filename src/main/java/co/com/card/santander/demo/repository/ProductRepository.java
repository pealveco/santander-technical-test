package co.com.card.santander.demo.repository;

import co.com.card.santander.demo.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
