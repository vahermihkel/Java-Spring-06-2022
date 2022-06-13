package ee.mihkel.webshop.repository;

import ee.mihkel.webshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
