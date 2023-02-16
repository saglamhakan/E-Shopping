package demo.EShopping.controllers;

import demo.EShopping.requests.AddProductRequest;
import demo.EShopping.requests.UpdateProductRequest;
import demo.EShopping.entities.Product;
import demo.EShopping.exception.ProductNotFoundException;
import demo.EShopping.responses.GetProductResponse;
import demo.EShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public GetProductResponse getProductById(@PathVariable int productId){
        Product product=productService.getByProductId(productId);
        if (product==null){
            throw new ProductNotFoundException("Product not available");
        }
        return new GetProductResponse(product);
    }

    @PostMapping("/add")
    public Product createOneProducts(@RequestBody AddProductRequest newCreateProduct){
        return productService.saveOneProduct(newCreateProduct);
    }
    @PutMapping("/{productId}")
    public Product updateOneProducts(@PathVariable int productId, UpdateProductRequest newProduct){
        return productService.updateOneProducts(productId,newProduct);
    }

    @DeleteMapping("/{productId}")
    public void deleteByProductId(@PathVariable int productId){
        productService.deleteByProductId(productId);
    }
}
