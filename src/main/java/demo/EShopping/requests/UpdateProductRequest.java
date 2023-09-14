package demo.EShopping.requests;

import demo.EShopping.entities.Category;
import lombok.Data;

@Data
public class UpdateProductRequest {


    private String productName;

    private String colour;

    private int productPrice;

    private int unitInStock;

    private Category category;


}
