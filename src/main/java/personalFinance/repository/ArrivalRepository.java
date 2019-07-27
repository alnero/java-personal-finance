package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.Arrival;
import java.util.List;

public interface ArrivalRepository extends JpaRepository<Arrival, Long> {
    Arrival findArrivalByUserId(long userId);
    void deleteByUserId(long userId);
    List<Arrival> findAllByUserId(long userId);
}
