package ashina.hairdresserreservation.business.abstracts;

import ashina.hairdresserreservation.entities.concretes.Category;
import ashina.hairdresserreservation.entities.concretes.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    List<Reservation> findAll();

    Optional<Reservation> findById(int id);

    Reservation save(Reservation reservation);

    void deleteById(int id);

    List<Reservation> findByHairdresserId(int hairdresserId);

    List<Reservation> findByClientId(int clientId);

}
