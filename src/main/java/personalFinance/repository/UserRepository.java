package personalFinance.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long id);
}
