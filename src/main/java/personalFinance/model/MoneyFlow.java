package personalFinance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class MoneyFlow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    MoneyFlow() {
    }

    MoneyFlow(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
