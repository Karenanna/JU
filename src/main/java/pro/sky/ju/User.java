package pro.sky.ju;

import java.util.regex.Pattern;

public class User {
    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) {
        if (!Pattern.compile("^(?=.@)[A-Za-z0-9_-]+" +
                "[^-] [A-Za-z0-9-] + (\\.[A-Za-z0-9-]+)*(\\.[A-Za-z] {2,})$").matcher(login).matches()){
//            throw new RuntimeException("Емайл не соответствует требованиям");
        }
        if(email.length() < 12) throw new RuntimeException("Пароль дольжен быть составлять более 12 синволов");
        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;

    }
}
