package ashina.hairdresserreservation.dataAccess.abstratcs;

import ashina.hairdresserreservation.entities.concretes.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDao extends JpaRepository<Client, Integer> {

    Optional<Client> findByEmail(String email);

}
