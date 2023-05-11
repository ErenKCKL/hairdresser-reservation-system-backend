package ashina.hairdresserreservation.business.abstracts;

import ashina.hairdresserreservation.entities.concretes.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    /**
     Category Service Interface
     This interface defines the contract for managing Category entities in the
     Hairdresser Reservation System. It provides a set of methods that need to be
     implemented by concrete classes to handle business logic related to Category entities.
     The interface contains the following methods:
     findAll(): Retrieves a list of all Category entities from the database.
     findById(int id): Retrieves a specific Category entity by its ID.
     save(Category category): Saves a new Category entity or updates an existing one.
     deleteById(int id): Deletes a specific Category entity by its ID.
     findByCategoryTitle(String categoryTitle): Retrieves a specific Category entity by its category title.
     Implementing classes should provide the actual business logic for these operations,
     typically by interacting with the data access layer (e.g., CategoryDao) and
     applying any required business rules or validations.
     */

    List<Category> findAll();

    Optional<Category> findById(int id);

    Category save(Category category);

    void deleteById(int id);

    Optional<Category> findByCategoryTitle(String categoryTitle);

}
