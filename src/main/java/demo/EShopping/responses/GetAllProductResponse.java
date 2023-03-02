package demo.EShopping.responses;

import demo.EShopping.entities.Category;
import demo.EShopping.entities.Product;
import lombok.Data;

@Data
public class GetAllProductResponse {

    private String productName;
    private String colour;
    private int productPrice;
    private int unitInStock;

   // private Category category;

    private String categoryName;

    private Long categoryId;



    public GetAllProductResponse(Product entity){
        this.productName=entity.getProductName();
        this.productPrice=entity.getProductPrice();
        this.colour=entity.getColour();
        this.unitInStock=entity.getUnitInStock();
      //  this.category=entity.getCategory();
        this.categoryName=entity.getCategory().getCategoryName();
        this.categoryId=entity.getCategory().getCategoryId();

    }


}
