package demo.EShopping.responses;

import demo.EShopping.entities.Category;
import lombok.Data;

@Data
public class GetCategoryResponse {

    private String categoryName;

    public GetCategoryResponse(Category entity){
        this.categoryName=entity.getCategoryName();
    }
}
