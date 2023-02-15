package demo.EShopping.responses;

import demo.EShopping.entities.Category;
import lombok.Data;

@Data
public class CategoryResponse {

    private String categoryName;

    public CategoryResponse(Category entity){
        this.categoryName=entity.getCategoryName();
    }
}
