package webapi.automation.entities;

public class User {

    // For tests using JsonObject
    public static final String LOGIN = "admin";
    public static final String ID = "password123";

    private String login;

    private int id;

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
