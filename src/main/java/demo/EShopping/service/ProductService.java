package demo.EShopping.service;

import demo.EShopping.dataAccess.CategoryRepository;
import demo.EShopping.entities.Category;
import demo.EShopping.exception.BusinessException;
import demo.EShopping.exception.ProductNotFoundException;
import demo.EShopping.mappers.ModelMapperManager;
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
    private final ModelMapperManager modelMapperManager;



    @Autowired
    public ProductService(ProductRepository productRepository, ModelMapperManager modelMapperManager,
                          ProductBusinessRules productBusinessRules) {
        this.productRepository = productRepository;
        this.modelMapperManager = modelMapperManager;
        this.productBusinessRules = productBusinessRules;
    }

    public List<GetAllProductResponse> getAllProducts(Optional<Long> categoryId, Optional<String> categoryName) {

        List<Product> products;
        if (categoryId.isPresent() && categoryName.isPresent()) {
            products = productRepository.findByCategory_CategoryIdAndCategory_CategoryName(categoryId.get(), categoryName.get());
        } else if (categoryId.isPresent()) {
            products = productRepository.findByCategory_CategoryId(categoryId.get());
        } else if (categoryName.isPresent()) {
            products = productRepository.findByCategory_CategoryName(categoryName.get());
        } else
            products = productRepository.findAll();
        return products.stream().map(product -> new GetAllProductResponse(product)).collect(Collectors.toList());

    }

    public Product saveOneProduct(AddProductRequest newCreateProduct) {
        this.productBusinessRules.productName(newCreateProduct.getProductName());
        this.productBusinessRules.existProductName(newCreateProduct.getProductName());
        this.productBusinessRules.productPrice(newCreateProduct.getProductPrice());

        // Product toSave = new Product();

        //toSave.setProductName(newCreateProduct.getProductName());
        //toSave.setProductPrice(newCreateProduct.getProductPrice());
        //toSave.setColour(newCreateProduct.getColour());
        //toSave.setUnitInStock(newCreateProduct.getUnitInStock());
        //toSave.setCategory(newCreateProduct.getCategory());

        Product product = this.modelMapperManager.forRequest().map(newCreateProduct, Product.class);

        return productRepository.save(product);
    }

  /*  public void updateOneProducts(int productId, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(productId).orElse(null);
        if (Objects.nonNull(product)) {
            product.setProductName(updateProductRequest.getProductName());
            product.setColour(updateProductRequest.getColour());
            product.setProductPrice(updateProductRequest.getProductPrice());
            product.setUnitInStock(updateProductRequest.getUnitInStock());
            product.setCategory(updateProductRequest.getCategory());
        }
        productRepository.save(product);
    }

   */

    public void deleteByProductId(int productId) {
        productRepository.deleteById(productId);
    }

    public GetAllProductResponse getByProductId(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product == null) {
            throw new ProductNotFoundException("Product not available");
        }
        return new GetAllProductResponse(product);

    }

    public List<GetAllProductResponse> getById(Long categoryId) {
        List<Product> products;
   if (categoryId == null){
       throw new BusinessException("Category not found");
   }else{
       products = productRepository.findByCategory_CategoryId(categoryId);
       return  products.stream().map(product -> new GetAllProductResponse(product)).collect(Collectors.toList());



   }

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


