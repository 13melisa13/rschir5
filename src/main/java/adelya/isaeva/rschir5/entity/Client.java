package adelya.isaeva.rschir5.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.java.Log;

@Entity
@Data
@Builder
@Log
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    private String patronymic;
    @NonNull
    @Column(unique = true)
    private String login;
    @NonNull
    @Column(unique = true)
    private String email;
    @NonNull
    private String password;

}
