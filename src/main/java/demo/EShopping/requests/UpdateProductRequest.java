package demo.EShopping.requests;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private String productName;

    private String colour;

    private int productPrice;

    private int unitInStock;

   // private Category category;
}
