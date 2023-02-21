package demo.EShopping.requests;

import lombok.Data;

@Data
public class UpdateProductRequest {

    private int productId;

    private String productName;

    private String colour;

    private int productPrice;

    private int unitInStock;

    private int categoryId;


}
