package demo.EShopping.responses;

import lombok.Data;

@Data
public class GetByIdCategoryResponse {

    private Long categoryId;

    private String categoryName;
}
