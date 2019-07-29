package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personalFinance.model.MoneyFlow;

import java.util.List;

@Repository
public interface MoneyFlowRepository extends JpaRepository<MoneyFlow, Long> {

    List<MoneyFlow> findAllByUserId(Long userId);
}
