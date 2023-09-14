package demo.EShopping.controllers;

import demo.EShopping.requests.AddProductRequest;
import demo.EShopping.requests.UpdateProductRequest;
import demo.EShopping.entities.Product;
import demo.EShopping.responses.GetAllProductResponse;
import demo.EShopping.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAllProducts(@RequestParam Optional<Long> categoryId, @RequestParam Optional<String> categoryName ){
        return productService.getAllProducts(categoryId,categoryName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAllProductResponse> getProductById(@PathVariable int id){
       return ResponseEntity.ok(productService.getByProductId(id));
    }

    @PostMapping("/add")
    public Product createOneProducts(@RequestBody AddProductRequest newCreateProduct){
        return productService.saveOneProduct(newCreateProduct);
    }
  /*  @PutMapping("/{productId}")
    public void updateOneProducts(@PathVariable int productId, @RequestBody UpdateProductRequest updateProductRequest){
          productService.updateOneProducts(productId,updateProductRequest);
    }

   */

    @DeleteMapping("/{id}")
    public void deleteByProductId(@PathVariable int id){
        productService.deleteByProductId(id);
    }

    @GetMapping("/getByCategory")
    public List<GetAllProductResponse> getById(@RequestParam Long categoryId){
        return productService.getById(categoryId);

    }


}
