package demo.EShopping.requests;

import lombok.Data;

@Data
public class AddCategoryRequest {

    private int categoryId;

    private String categoryName;
}
