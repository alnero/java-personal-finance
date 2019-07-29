package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.Category;
import personalFinance.repository.CategoryRepository;
import personalFinance.utils.CategoryDTO;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Category> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return categories;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Category getCategoryById(@PathVariable(name = "id") Long id) {
        Category category = this.categoryRepository.findCategoriesById(id);
        return category;
    }

    @ResponseBody
    @PutMapping(value = "/{id}")
    public Category updateCategoryById(@PathVariable(value = "id") Long id, @RequestBody CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findCategoriesById(id);
        this.modelMapper.map(categoryDTO, category);
        category = this.categoryRepository.save(category);
        return category;
    }

    @ResponseBody
    @DeleteMapping(value = "/{id}")
    public void deleteCategoryById(@PathVariable(value = "id") Long id) {
        this.categoryRepository.deleteById(id);
    }

    @ResponseBody
    @PostMapping
    public Category createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = new Category();
        this.modelMapper.map(categoryDTO, category);
        category = this.categoryRepository.save(category);
        return category;
    }
}
