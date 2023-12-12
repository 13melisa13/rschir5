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
@AllArgsConstructor
@NoArgsConstructor
public class WashingMachine extends Product{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;
    Integer capacityTank;
    String manufacturerName;
}
