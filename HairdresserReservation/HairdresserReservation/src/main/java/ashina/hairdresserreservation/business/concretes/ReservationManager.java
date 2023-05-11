package ashina.hairdresserreservation.business.concretes;

import ashina.hairdresserreservation.business.abstracts.ReservationService;
import ashina.hairdresserreservation.dataAccess.abstratcs.ReservationDao;
import ashina.hairdresserreservation.entities.concretes.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationManager implements ReservationService {

    private ReservationDao reservationDao;

    @Autowired
    public ReservationManager(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    @Override
    public Optional<Reservation> findById(int id) {
        return reservationDao.findById(id);
    }

    @Override
    public Reservation save(Reservation reservation) {
        return reservationDao.save(reservation);
    }

    @Override
    public void deleteById(int id) {
        reservationDao.deleteById(id);
    }

    @Override
    public List<Reservation> findByHairdresserId(int hairdresserId) {
        return reservationDao.findByHairdresserId(hairdresserId);
    }

    @Override
    public List<Reservation> findByClientId(int clientId) {
        return reservationDao.findByClientId(clientId);
    }
}
