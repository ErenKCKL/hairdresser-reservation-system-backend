package ashina.hairdresserreservation.business.concretes;

import ashina.hairdresserreservation.business.abstracts.HairdresserService;
import ashina.hairdresserreservation.dataAccess.abstratcs.HairdresserDao;
import ashina.hairdresserreservation.entities.concretes.Hairdresser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HairdresserManager implements HairdresserService {

    /**

     Hairdresser Manager Class
     This class implements the HairdresserService interface and provides
     business logic for managing Hairdresser entities in the Hairdresser Reservation System.
     It acts as a bridge between the data access layer (HairdresserDao) and the
     application layer (controllers, etc.).
     Annotations used:
     @Service: Indicates that this class is a Spring Service component, making
     it eligible for component scanning and auto-detection in the application context.
     The class contains the following methods:
     findAll(): Retrieves a list of all Hairdresser entities from the database.
     findById(int id): Retrieves a specific Hairdresser entity by its ID.
     save(Hairdresser hairdresser): Saves a new Hairdresser entity or updates an existing one.
     deleteById(int id): Deletes a specific Hairdresser entity by its ID.
     findByEmail(String email): Retrieves a specific Hairdresser entity by its email address.
     The HairdresserDao instance is injected into the class using @Autowired annotation
     in the constructor, allowing for loose coupling and easy testing.
     */

    private HairdresserDao hairdresserDao;

    @Autowired
    public HairdresserManager(HairdresserDao hairdresserDao) {
        this.hairdresserDao = hairdresserDao;
    }

    @Override
    public List<Hairdresser> findAll() {
        return hairdresserDao.findAll();
    }

    @Override
    public Optional<Hairdresser> findById(int id) {
        return hairdresserDao.findById(id);
    }

    @Override
    public Hairdresser save(Hairdresser hairdresser) {
        return hairdresserDao.save(hairdresser);
    }

    @Override
    public void deleteById(int id) {
        hairdresserDao.deleteById(id);
    }

    @Override
    public Optional<Hairdresser> findByEmail(String email) {
        return hairdresserDao.findByEmail(email);
    }
}
