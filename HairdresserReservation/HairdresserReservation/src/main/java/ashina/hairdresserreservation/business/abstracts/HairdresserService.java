package ashina.hairdresserreservation.business.abstracts;

import ashina.hairdresserreservation.entities.concretes.Hairdresser;

import java.util.List;
import java.util.Optional;

public interface HairdresserService {

    /**

     Hairdresser Service Interface
     This interface defines the contract for managing Hairdresser entities in the
     Hairdresser Reservation System. It provides a set of methods that need to be
     implemented by concrete classes to handle business logic related to Hairdresser entities.
     The interface contains the following methods:
     findAll(): Retrieves a list of all Hairdresser entities from the database.
     findById(int id): Retrieves a specific Hairdresser entity by its ID.
     save(Hairdresser hairdresser): Saves a new Hairdresser entity or updates an existing one.
     deleteById(int id): Deletes a specific Hairdresser entity by its ID.
     findByEmail(String email): Retrieves a specific Hairdresser entity by its email address.
     Implementing classes should provide the actual business logic for these operations,
     typically by interacting with the data access layer (e.g., HairdresserDao) and
     applying any required business rules or validations.
     */

    List<Hairdresser> findAll();

    Optional<Hairdresser> findById(int id);

    Hairdresser save(Hairdresser hairdresser);

    void deleteById(int id);

    Optional<Hairdresser> findByEmail(String email);

}
