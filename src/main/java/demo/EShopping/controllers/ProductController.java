package demo.EShopping.controllers;

import demo.EShopping.requests.AddProductRequest;
import demo.EShopping.requests.UpdateProductRequest;
import demo.EShopping.entities.Product;
import demo.EShopping.exception.ProductNotFoundException;
import demo.EShopping.responses.GetAllProductResponse;
import demo.EShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAllProducts(@RequestParam Optional<Long> categoryId, @RequestParam Optional<String> categoryName ){
        return productService.getAllProducts(categoryId,categoryName);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetAllProductResponse> getProductById(@PathVariable int productId){
       return ResponseEntity.ok(productService.getByProductId(productId));
    }

    @PostMapping("/add")
    public Product createOneProducts(@RequestBody AddProductRequest newCreateProduct){
        return productService.saveOneProduct(newCreateProduct);
    }
    @PutMapping("/{productId}")
    public void updateOneProducts(@PathVariable int productId, @RequestBody UpdateProductRequest updateProductRequest){
          productService.updateOneProducts(productId,updateProductRequest);
    }

    @DeleteMapping("/{productId}")
    public void deleteByProductId(@PathVariable int productId){
        productService.deleteByProductId(productId);
    }


}
