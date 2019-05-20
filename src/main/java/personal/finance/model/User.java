package personal.finance.model;

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
    private String userContent;

    public User() {
    }

    public User(long userId, String userContent) {
        this.userId = userId;
        this.userContent = userContent;
    }

    public long getUserId() {
        return this.userId;
    }

    public String getUserContent() {
        return this.userContent;
    }

    public void setUserContent(String content) {
        this.userContent = content;
    }
}