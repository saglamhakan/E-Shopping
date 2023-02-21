package demo.EShopping.service;

import demo.EShopping.mappers.ModelMapperService;
import demo.EShopping.requests.AddCategoryRequest;
import demo.EShopping.requests.UpdateCategoryRequest;
import demo.EShopping.dataAccess.CategoryRepository;
import demo.EShopping.entities.Category;
import demo.EShopping.responses.GetAllCategoryResponse;
import demo.EShopping.responses.GetByIdCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private final CategoryRepository categoryRepository;

    private final ModelMapperService modelMapperService;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
    }


    public List<GetAllCategoryResponse> getAllCategory() {

        List<Category> categories = categoryRepository.findAll();

        List<GetAllCategoryResponse> categoryResponses = (List<GetAllCategoryResponse>) categories.stream().
                map(category -> this.modelMapperService.forResponse()
                .map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());


        return categoryResponses;
    }


    public Category saveOneCategory(AddCategoryRequest newCategory) {

      //  Category toSave = new Category();
        //toSave.setCategoryName(newCategory.getCategoryName());
        //toSave.setCategoryId(newCategory.getCategoryId());

        Category category=this.modelMapperService.forRequest().map(newCategory, Category.class);
        return categoryRepository.save(category);
    }

    public void updateOneCategory( UpdateCategoryRequest updateCategoryRequest, Long categoryId) {

        Category category=this.modelMapperService.forRequest().map(updateCategoryRequest,Category.class);
        categoryRepository.save(category);


    }

    public void deleteByCategoryId(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public GetByIdCategoryResponse getByCategoryId(Long categoryId) {

        Category category=categoryRepository.findById(categoryId).orElseThrow();

        GetByIdCategoryResponse categoryResponse=this.modelMapperService.forResponse().map(category,GetByIdCategoryResponse.class);

        return categoryResponse;
    }
}
/*
 new ArrayList<GetCategoryResponse>();

        for (Category category:categories){
            GetCategoryResponse foundCategory=new GetCategoryResponse(category);
            foundCategory.setCategoryName(category.getCategoryName());

            categoryResponses.add(foundCategory);

            ----------------------------------------

             Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            Category foundCategory = category.get();
            foundCategory.setCategoryName(newCategory.getCategoryName());
            foundCategory.setCategoryId(newCategory.getCategoryId());

            categoryRepository.save(foundCategory);
            return foundCategory;

 */