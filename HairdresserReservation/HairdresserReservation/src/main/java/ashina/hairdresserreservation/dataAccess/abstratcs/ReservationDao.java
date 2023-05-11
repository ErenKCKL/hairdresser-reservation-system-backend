package ashina.hairdresserreservation.dataAccess.abstratcs;

import ashina.hairdresserreservation.entities.concretes.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationDao extends JpaRepository<Reservation, Integer> {

    List<Reservation> findByHairdresserId(int hairdresserId);
    List<Reservation> findByClientId(int customerId);
}
