package adelya.isaeva.rschir5.controller;

import adelya.isaeva.rschir5.entity.products.ProductType;
import adelya.isaeva.rschir5.entity.products.Telephone;
import adelya.isaeva.rschir5.service.TelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/telephones")
public class TController {
    @Autowired
    TelephoneService clientService;
    @GetMapping("/")
    public ResponseEntity<?> getAll(){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        var clientList = clientService.getAll();
        if (!clientList.isEmpty()) {
            map.put("status", 1);
            map.put("data", clientList);
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
            map.put("data", clientService.getById(id));
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
            Telephone client = clientService.getById(id);
            clientService.delete(client);
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
    public ResponseEntity<?> save(@RequestBody Telephone client) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        client.setType(ProductType.ELECTRONIC);
        clientService.save(client);
        map.put("status", 1);
        map.put("message", "Record is Saved Successfully!");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Telephone clientDetail) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            Telephone client = clientService.getById(id);
            client.setName(clientDetail.getName());
            client.setType(ProductType.ELECTRONIC);
            client.setPrice(clientDetail.getPrice());
            client.setCapacityMemory(clientDetail.getCapacityMemory());
            client.setManufacturerName(clientDetail.getManufacturerName());
            client.setTrader(clientDetail.getTrader());
            clientService.save(client);
            map.put("status", 1);
            map.put("data", clientService.getById(id));
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception ex) {
            map.clear();
            map.put("status", 0);
            map.put("message", "Data is not found");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
    }

}
