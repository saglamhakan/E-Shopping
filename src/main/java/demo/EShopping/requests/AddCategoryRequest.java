package demo.EShopping.requests;

import lombok.Data;

@Data
public class AddCategoryRequest {

    private Long categoryId;

    private String categoryName;
}
