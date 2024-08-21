package uz.bunyodbek.onlineshopmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.bunyodbek.onlineshopmain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsByName(String name);

}
