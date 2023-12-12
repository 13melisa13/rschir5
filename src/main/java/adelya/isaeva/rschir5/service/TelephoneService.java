package adelya.isaeva.rschir5.service;

import adelya.isaeva.rschir5.entity.products.Book;
import adelya.isaeva.rschir5.entity.products.Telephone;
import adelya.isaeva.rschir5.repository.BookRepository;
import adelya.isaeva.rschir5.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelephoneService {
    @Autowired
    TelephoneRepository repository;
    public Telephone save(Telephone book){
        return repository.save(book);
    }
    public List<Telephone> getAll(){
        return repository.findAll();
    }
    public Telephone getById(Long id) {
        return repository.findById(id).get();
    }
    public void delete(Telephone book) {
        repository.delete(book);
    }
}
