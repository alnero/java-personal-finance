package personalFinance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private long id;

    @NotNull(message = "name of category can't be empty")
    @Column(name = "name", length = 256)
    private String name;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    @Column(name = "category_id")
    private List<Expense> expenses;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
