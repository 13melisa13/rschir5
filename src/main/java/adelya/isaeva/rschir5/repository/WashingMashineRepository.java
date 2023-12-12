package adelya.isaeva.rschir5.repository;

import adelya.isaeva.rschir5.entity.products.Book;
import adelya.isaeva.rschir5.entity.products.WashingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WashingMashineRepository extends JpaRepository<WashingMachine, Long> {
}
