package demo.EShopping.controllers;

import demo.EShopping.requests.AddCategoryRequest;
import demo.EShopping.requests.UpdateCategoryRequest;
import demo.EShopping.entities.Category;
import demo.EShopping.exception.CategoryNotFoundException;
import demo.EShopping.responses.GetCategoryResponse;
import demo.EShopping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @GetMapping("/getAll")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public GetCategoryResponse getByCategoryId(@PathVariable int categoryId){
        Category category=categoryService.getByCategoryId(categoryId);
        if (category==null){
            throw new CategoryNotFoundException("Category not available");
        }
        return new GetCategoryResponse(category);
    }


    @PostMapping("/add")
    public Category createOneCategory(@RequestBody AddCategoryRequest newCategory){
        return categoryService.saveOneCategory(newCategory);
    }

    @PutMapping("/{categoryId}")
    public Category updateOneCategory(@PathVariable int categoryId, UpdateCategoryRequest newCategory){
        return categoryService.updateOneCategory(categoryId,newCategory);
    }
    @DeleteMapping("/{categoryId}")
    public void deleteByCategoryId(@PathVariable int categoryId){
        categoryService.deleteByCategoryId(categoryId);
    }
}
