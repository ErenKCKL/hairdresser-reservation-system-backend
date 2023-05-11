package ashina.hairdresserreservation.business.abstracts;

import ashina.hairdresserreservation.entities.concretes.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    List<Client> findAll();

    Optional<Client> findById(int id);

    Client save(Client client);

    void deleteById(int id);

    Optional<Client> findByEmail(String email);

}
