package demo.EShopping.service;

import demo.EShopping.mappers.ModelMapperService;
import demo.EShopping.requests.AddProductRequest;
import demo.EShopping.requests.UpdateProductRequest;
import demo.EShopping.dataAccess.ProductRepository;
import demo.EShopping.entities.Product;
import demo.EShopping.responses.GetAllProductResponse;
import demo.EShopping.rules.ProductBusinessRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    private final ProductBusinessRules productBusinessRules;
    private final ModelMapperService modelMapperService;

    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapperService modelMapperService, ProductBusinessRules productBusinessRules) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
        this.productBusinessRules = productBusinessRules;

    }


    public List<GetAllProductResponse> getAllProducts(Optional<Long> categoryId, Optional<String> categoryName) {

        List<Product> list;
        if (categoryId.isPresent()) {
            list = productRepository.findByCategory_CategoryId(categoryId.get());
        } else if (categoryName.isPresent()) {
            list = productRepository.findByCategory_CategoryName(categoryName.get());
        } else {
            list = productRepository.findAll();
        }
        return list.stream().map(product -> new GetAllProductResponse(product)).collect(Collectors.toList());

    }

    public Product saveOneProduct(AddProductRequest newCreateProduct) {
        this.productBusinessRules.productName(newCreateProduct.getProductName());

        // Product toSave = new Product();

        //toSave.setProductName(newCreateProduct.getProductName());
        //toSave.setProductPrice(newCreateProduct.getProductPrice());
        //toSave.setColour(newCreateProduct.getColour());
        //toSave.setUnitInStock(newCreateProduct.getUnitInStock());
        //toSave.setCategory(newCreateProduct.getCategory());

        Product product = this.modelMapperService.forRequest().map(newCreateProduct, Product.class);

        return productRepository.save(product);
    }

    public void updateOneProducts(int productId, UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
        productRepository.save(product);

    }

    public void deleteByProductId(int productId) {
        productRepository.deleteById(productId);
    }

    public Product getByProductId(int productId) {
        return productRepository.findById(productId).orElse(null);
    }

}





/*  for (Product product:products){
                GetProductResponse foundProduct= new GetProductResponse(product);
                foundProduct.setProductName(product.getProductName());
                foundProduct.setColour(product.getColour());
                foundProduct.setProductPrice(product.getProductPrice());
                foundProduct.setUnitInStock(product.getUnitInStock());
                foundProduct.setCategory(product.getCategory());

                productResponses.add(foundProduct);
            }


            return productResponses;


           public List<GetProductResponse> getAllProducts(Optional<Long> categoryId) {

        List<Product> list;

        if (categoryId.isPresent()){
            list=productRepository.findByCategory_CategoryId(categoryId.get());
        }else {
            list=productRepository.findAll();
        }
        return list.stream().map(like -> new GetProductResponse(like)).collect(Collectors.toList());
    }

*/


