package personalFinance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "arrival")
public class Arrival {
    @Id
    @SequenceGenerator(name = "arrival_seq", sequenceName = "arrival_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arrival_seq")
    private long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "amount can't be empty")
    @Column(name = "amount")
    private BigDecimal amount;

    public Arrival() {

    }

    public Arrival(@NotNull(message = "user can't be empty") User user, @NotNull(message = "amount can't be empty") BigDecimal amount) {
        this.user = user;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
