package demo.EShopping.rules;

import demo.EShopping.dataAccess.CategoryRepository;
import demo.EShopping.exception.CategoryNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {

    @Autowired
    private CategoryRepository categoryRepository;

    public void categoryName(String categoryName){
        if (categoryName.isEmpty()){
            throw new CategoryNotFoundException("Category name can not is empty");

        }
    }
}
