package demo.EShopping.service;

import demo.EShopping.requests.AddProductRequest;
import demo.EShopping.requests.UpdateProductRequest;
import demo.EShopping.dataAccess.ProductRepository;
import demo.EShopping.entities.Product;
import demo.EShopping.responses.GetProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product saveOneProduct(AddProductRequest newCreateProduct) {


        Product toSave=new Product();

        toSave.setProductName(newCreateProduct.getProductName());
        toSave.setProductPrice(newCreateProduct.getProductPrice());
        toSave.setColour(newCreateProduct.getColour());
        toSave.setUnitInStock(newCreateProduct.getUnitInStock());
        toSave.setCategory(newCreateProduct.getCategory());

        return productRepository.save(toSave);
    }

    public Product updateOneProducts(int productId, UpdateProductRequest newProduct) {
        Optional<Product> product=productRepository.findById(productId);
        if (product.isPresent()){
            Product toUpdate=product.get();
            toUpdate.setProductName(newProduct.getProductName());
            toUpdate.setProductPrice(newProduct.getProductPrice());
            toUpdate.setColour(newProduct.getColour());
            toUpdate.setUnitInStock(newProduct.getUnitInStock());
            productRepository.save(toUpdate);
            return toUpdate;
        }else
            return null;
    }

    public void deleteByProductId(int productId) {
        productRepository.deleteById(productId);
    }

    public Product getByProductId(int productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
