package personalFinance.utils;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private long userId;
    private String name;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}