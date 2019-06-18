package personalFinance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @SequenceGenerator(name = "categories_seq", sequenceName = "categories_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @OneToMany
    private long categoryId;

    @NotNull(message = "category name can't be empty")
    @Column(name = "category_name", length = 256)
    private String categoryName;

    public Category() {}

    public Category(@NotNull(message = "category name can't be empty") String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(long categoryId, @NotNull(message = "category name can't be empty") String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
