package adelya.isaeva.rschir5.repository;
import adelya.isaeva.rschir5.entity.products.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
