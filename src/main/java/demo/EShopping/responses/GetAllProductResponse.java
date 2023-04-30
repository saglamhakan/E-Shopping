package demo.EShopping.responses;


import demo.EShopping.entities.Product;
import lombok.Data;

@Data
public class GetAllProductResponse {

    private int id;
    private String productName;
    private String colour;
    private int productPrice;
    private int unitInStock;

    private String categoryName;

    private Long categoryId;


    public GetAllProductResponse(Product entity){
        this.id=entity.getId();
        this.productName=entity.getProductName();
        this.productPrice=entity.getProductPrice();
        this.colour=entity.getColour();
        this.unitInStock=entity.getUnitInStock();
        if (entity.getCategory() != null) {
            this.categoryName=entity.getCategory().getCategoryName();
            this.categoryId=entity.getCategory().getCategoryId();
        } else {
            this.categoryName = null;
            this.categoryId = null;
        }


    }


}
