package ke.natujenge.tax.repository;

import ke.natujenge.tax.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    Optional<Bill> findOneByMonthId(Integer monthId);
}
