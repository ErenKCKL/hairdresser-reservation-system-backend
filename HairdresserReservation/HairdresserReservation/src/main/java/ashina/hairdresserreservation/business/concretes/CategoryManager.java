package ashina.hairdresserreservation.business.concretes;

import ashina.hairdresserreservation.business.abstracts.CategoryService;
import ashina.hairdresserreservation.dataAccess.abstratcs.CategoryDao;
import ashina.hairdresserreservation.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager implements CategoryService {

    /**
     Category Manager Class
     This class implements the CategoryService interface and provides
     business logic for managing Category entities in the Hairdresser Reservation System.
     It acts as a bridge between the data access layer (CategoryDao) and the
     application layer (controllers, etc.).
     Annotations used:
     @Service: Indicates that this class is a Spring Service component, making
     it eligible for component scanning and auto-detection in the application context.
     The class contains the following methods:
     findAll(): Retrieves a list of all Category entities from the database.
     findById(int id): Retrieves a specific Category entity by its ID.
     save(Category category): Saves a new Category entity or updates an existing one.
     deleteById(int id): Deletes a specific Category entity by its ID.
     findByCategoryTitle(String categoryTitle): Retrieves a specific Category entity by its category title.
     The CategoryDao instance is injected into the class using @Autowired annotation
     in the constructor, allowing for loose coupling and easy testing.
     */

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
    return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public void deleteById(int id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Optional<Category> findByCategoryTitle(String categoryTitle) {
        return categoryDao.findByCategoryTitle(categoryTitle);
    }
}
