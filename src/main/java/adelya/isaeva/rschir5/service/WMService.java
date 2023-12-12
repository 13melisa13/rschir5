package adelya.isaeva.rschir5.service;

import adelya.isaeva.rschir5.entity.products.Book;
import adelya.isaeva.rschir5.entity.products.WashingMachine;
import adelya.isaeva.rschir5.repository.BookRepository;
import adelya.isaeva.rschir5.repository.WashingMashineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WMService {
    @Autowired
    WashingMashineRepository repository;
    public WashingMachine save(WashingMachine book){
        return repository.save(book);
    }
    public List<WashingMachine> getAll(){
        return repository.findAll();
    }
    public WashingMachine getById(Long id) {
        return repository.findById(id).get();
    }
    public void delete(WashingMachine book) {
        repository.delete(book);
    }
}
