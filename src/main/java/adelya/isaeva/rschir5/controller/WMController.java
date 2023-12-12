package adelya.isaeva.rschir5.controller;

import adelya.isaeva.rschir5.entity.products.Book;
import adelya.isaeva.rschir5.entity.products.ProductType;
import adelya.isaeva.rschir5.entity.products.WashingMachine;
import adelya.isaeva.rschir5.service.BookService;
import adelya.isaeva.rschir5.service.WMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/washing_machines")
public class WMController {
    @Autowired
    WMService bookService;
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        var bookList = bookService.getAll();
        if (!bookList.isEmpty()) {
            map.put("status", 1);
            map.put("data", bookList);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            map.put("status", 1);
            map.put("data", bookService.getById(id));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            WashingMachine book = bookService.getById(id);
            bookService.delete(book);
            map.put("status", 1);
            map.put("message", "Record is deleted successfully!");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody WashingMachine book) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        book.setType(ProductType.PLUMBING);
        bookService.save(book);
        map.put("status", 1);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody WashingMachine bookDetail) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            WashingMachine book = bookService.getById(id);
            book.setName(bookDetail.getName());
            book.setType(ProductType.PLUMBING);
            book.setPrice(bookDetail.getPrice());
            book.setCapacityTank(bookDetail.getCapacityTank());
            book.setManufacturerName(bookDetail.getManufacturerName());
            book.setTrader(bookDetail.getTrader());
            bookService.save(book);
            map.put("status", 1);
            map.put("data", bookService.getById(id));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

}
