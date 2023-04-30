package demo.EShopping.dataAccess;

import demo.EShopping.entities.Product;
import demo.EShopping.responses.GetAllProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


    List<Product> findByCategory_CategoryId(Long categoryId);


    List<Product> findByCategory_CategoryName(String categoryName);



    List<Product> findByCategory_CategoryIdAndCategory_CategoryName(Long categoryId, String categoryName);



//    List<Product> findByCategory_CategoryIdAndCategory_CategoryName(Long categoryId, String categoryName);
}
