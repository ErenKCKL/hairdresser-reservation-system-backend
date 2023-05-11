package ashina.hairdresserreservation.dataAccess.abstratcs;

import ashina.hairdresserreservation.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    /**
     Category Dao Interface
     This interface extends the JpaRepository interface and provides data access methods
     for Category entities in the Hairdresser Reservation System. It defines custom query methods
     specific to Category entities.
     JpaRepository provides basic CRUD operations and methods for pagination and sorting,
     which can be used directly by the implementing classes without needing to define them.
     The interface contains the following custom method:
     findByCategoryTitle(String categoryTitle): Retrieves a specific Category entity by its category title.
     Spring Data JPA automatically generates the implementation for this interface during runtime,
     allowing for easy interaction with the underlying database using the defined methods.
     */

    Optional<Category> findByCategoryTitle(String categoryTitle);
}
