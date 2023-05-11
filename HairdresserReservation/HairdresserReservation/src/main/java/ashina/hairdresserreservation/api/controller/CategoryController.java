package ashina.hairdresserreservation.api.controller;

import ashina.hairdresserreservation.business.abstracts.CategoryService;
import ashina.hairdresserreservation.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    /**
     Category Controller Class
     This class serves as the REST API controller for managing Category entities
     in the Hairdresser Reservation System. It handles HTTP requests related to
     Category entities and delegates the business logic to the CategoryService.
     Annotations used:
     @RestController: Indicates that this class is a Spring REST Controller, enabling
     the creation of RESTful endpoints.
     @RequestMapping: Specifies the base path for the endpoints in this controller.
     The class contains the following endpoints:
     GET /api/categories: Retrieves a list of all Category entities.
     GET /api/categories/{id}: Retrieves a specific Category entity by its ID.
     GET /api/categories/{categoryTitle}: Retrieves a specific Category entity by its category title.
     POST /api/categories: Creates a new Category entity.
     PUT /api/categories/{id}: Updates a specific Category entity by its ID.
     DELETE /api/categories/{id}: Deletes a specific Category entity by its ID.
     The CategoryService instance is injected into the class using the @Autowired
     annotation in the constructor, allowing for loose coupling and easy testing.
     */

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category>  categories= categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return categoryService.findById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{categoryTitle}")
    public ResponseEntity<Category> getCategoryByCategoryTitle(@PathVariable String categoryTitle) {
        return categoryService.findByCategoryTitle(categoryTitle)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category categoryDetails) {
        return categoryService.findById(id).map(category -> {
            category.setCategoryTitle(category.getCategoryTitle());
            Category updatedCategory = categoryService.save(category);
            return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        return categoryService.findById(id).map(category -> {
            categoryService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
