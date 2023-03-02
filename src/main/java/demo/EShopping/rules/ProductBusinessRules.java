package demo.EShopping.rules;

import demo.EShopping.dataAccess.ProductRepository;
import demo.EShopping.entities.Product;
import demo.EShopping.exception.ProductNotFoundException;
import demo.EShopping.responses.GetAllProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductBusinessRules {

    @Autowired
    private ProductRepository productRepository;

    public void productName(String productName){
        if (productName.isEmpty()){
            throw new ProductNotFoundException("Product not added");
        }
    }

}