package demo.EShopping.service;

import demo.EShopping.requests.AddCategoryRequest;
import demo.EShopping.requests.UpdateCategoryRequest;
import demo.EShopping.dataAccess.CategoryRepository;
import demo.EShopping.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category saveOneCategory(AddCategoryRequest newCategory) {

        Category toSave = new Category();
        toSave.setCategoryName(newCategory.getCategoryName());
        toSave.setCategoryId(newCategory.getCategoryId());

        return categoryRepository.save(toSave);
    }

    public Category updateOneCategory(int categoryId, UpdateCategoryRequest newCategory) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category foundCategory = category.get();
            foundCategory.setCategoryName(newCategory.getCategoryName());

            categoryRepository.save(foundCategory);
            return foundCategory;
        } else
            return null;
    }

    public void deleteByCategoryId(int categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Category getByCategoryId(int categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }
}
