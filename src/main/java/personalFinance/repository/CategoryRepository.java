package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoriesById(Long id);
}
