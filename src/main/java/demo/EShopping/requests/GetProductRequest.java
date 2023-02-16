package demo.EShopping.requests;

import demo.EShopping.entities.Category;
import lombok.Data;

@Data
public class GetProductRequest {


    private String productName;

    private int productPrice;

    private int unitInStock;

    private String colour;

    private Category category;
}
