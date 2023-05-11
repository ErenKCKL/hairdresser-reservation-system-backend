package ashina.hairdresserreservation.dataAccess.abstratcs;

import ashina.hairdresserreservation.entities.concretes.Hairdresser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HairdresserDao extends JpaRepository<Hairdresser, Integer> {

    /**
     Hairdresser Data Access Interface
     This interface extends JpaRepository and is used for performing data access
     operations on the Hairdresser entity in the Hairdresser Reservation System.
     It provides methods to interact with the database, including standard CRUD
     operations and custom queries.
     JpaRepository is a Spring Data interface that provides basic data access
     functionality (such as save, find, delete) for the specified entity and its
     primary key type. In this case, it is Hairdresser and Integer, respectively.
     The interface includes the following custom method:
     findByEmail: Finds a Hairdresser entity by its email address and returns
     an Optional containing the Hairdresser if found, or an empty Optional otherwise.
     */
    Optional<Hairdresser> findByEmail(String email);
}
