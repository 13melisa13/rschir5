package adelya.isaeva.rschir5;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "adelya.isaeva.rschir5.repository")
@SpringBootApplication

public class Rschir5Application {
    public static void main(String[] args) {
        SpringApplication.run(Rschir5Application.class, args);
    }

}
