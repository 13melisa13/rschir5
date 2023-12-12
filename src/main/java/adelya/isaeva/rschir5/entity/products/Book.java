package adelya.isaeva.rschir5.entity.products;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

@EqualsAndHashCode(callSuper = true)
@Entity
@Log
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book extends Product{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String authorName;
}
