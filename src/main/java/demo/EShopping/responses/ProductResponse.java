package demo.EShopping.responses;

import demo.EShopping.entities.Category;
import demo.EShopping.entities.Product;
import lombok.Data;

@Data
public class ProductResponse {

    private String productName;
    private String colour;
    private int productPrice;
    private int unitInStock;

    private Category category;

    public ProductResponse(Product entity){
        this.productName=entity.getProductName();
        this.productPrice=entity.getProductPrice();
        this.colour=entity.getColour();
        this.unitInStock=entity.getUnitInStock();
        this.category=entity.getCategory();
    }
}
