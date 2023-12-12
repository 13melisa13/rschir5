package adelya.isaeva.rschir5.entity.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.extern.java.Log;

@EqualsAndHashCode(callSuper = true)
@Entity
@Log
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telephone extends Product{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;
    Integer capacityMemory;
    String manufacturerName;
}
