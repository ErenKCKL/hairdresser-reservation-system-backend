package ashina.hairdresserreservation.business.concretes;

import ashina.hairdresserreservation.business.abstracts.ClientService;
import ashina.hairdresserreservation.dataAccess.abstratcs.ClientDao;
import ashina.hairdresserreservation.entities.concretes.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientManager implements ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientManager(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Optional<Client> findById(int id) {
        return clientDao.findById(id);
    }

    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }

    @Override
    public void deleteById(int id) {
        clientDao.deleteById(id);
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clientDao.findByEmail(email);
    }
}
