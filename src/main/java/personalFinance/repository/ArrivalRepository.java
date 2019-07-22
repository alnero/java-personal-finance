package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.Arrival;

public interface ArrivalRepository extends JpaRepository<Arrival, Long> {
    Arrival findArrivalByUserId(long userId);
    void deleteByUserId(long userId);
}
