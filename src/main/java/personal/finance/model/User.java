package personal.finance.model;

public class User {
    private long userId;
    private String userContent;

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
