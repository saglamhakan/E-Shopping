package demo.EShopping.controllers;

import demo.EShopping.requests.AddCategoryRequest;
import demo.EShopping.requests.UpdateCategoryRequest;
import demo.EShopping.entities.Category;
import demo.EShopping.exception.CategoryNotFoundException;
import demo.EShopping.responses.GetAllCategoryResponse;
import demo.EShopping.responses.GetByIdCategoryResponse;
import demo.EShopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("categories")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/getAll")
    public List<GetAllCategoryResponse> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public GetByIdCategoryResponse getByCategoryId(@PathVariable Long categoryId){
        return categoryService.getByCategoryId(categoryId);

       // Category category=categoryService.getByCategoryId(categoryId);
        //if (category==null){
          //  throw new CategoryNotFoundException("Category not available");
        }
      //  return new GetAllCategoryResponse();
  //  }


    @PostMapping("/add")
    public Category createOneCategory(@RequestBody AddCategoryRequest newCategory){
        return categoryService.saveOneCategory(newCategory);
    }

    @PutMapping("{categoryId}")
    public void updateOneCategory(@RequestBody UpdateCategoryRequest updateCategoryRequest, @PathVariable Long categoryId){
         categoryService.updateOneCategory(updateCategoryRequest,categoryId);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteByCategoryId(@PathVariable Long categoryId){
        categoryService.deleteByCategoryId(categoryId);
    }
}
