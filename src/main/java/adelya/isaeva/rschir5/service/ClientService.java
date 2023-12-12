package adelya.isaeva.rschir5.service;

import adelya.isaeva.rschir5.entity.Client;
import adelya.isaeva.rschir5.entity.products.Book;
import adelya.isaeva.rschir5.repository.BookRepository;
import adelya.isaeva.rschir5.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;
    public Client save(Client book){
        return repository.save(book);
    }
    public List<Client> getAll(){
        return repository.findAll();
    }
    public Client getById(Long id) {
        return repository.findById(id).get();
    }
    public void delete(Client book) {
        repository.delete(book);
    }
}
