package personalFinance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    private long userId;

    @NotNull(message = "content of user can't be empty")
    @Column(name = "content", length = 256)
    private String name;

    public User() {
    }

    public User(@NotNull(message = "content of user can't be empty") String name) {
        this.name = name;
    }

    public User(long userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String content) {
        this.name = content;
    }
}
