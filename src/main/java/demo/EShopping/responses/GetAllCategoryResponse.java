package demo.EShopping.responses;

import lombok.Data;

@Data
public class GetAllCategoryResponse {
    private Long categoryId;
    private String categoryName;

  //  public GetCategoryResponse(Category entity) {
    //    this.categoryName = entity.getCategoryName();
      //  this.categoryId=entity.getCategoryId();
    //}
}
