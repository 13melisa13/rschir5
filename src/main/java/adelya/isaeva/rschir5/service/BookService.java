package adelya.isaeva.rschir5.service;

import adelya.isaeva.rschir5.entity.products.Book;
import adelya.isaeva.rschir5.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository repository;
    public Book save(Book book){
        return repository.save(book);
    }
    public List<Book> getAll(){
        return repository.findAll();
    }
    public Book getById(Long id) {
        return repository.findById(id).get();
    }
    public void delete(Book book) {
        repository.delete(book);
    }
}
