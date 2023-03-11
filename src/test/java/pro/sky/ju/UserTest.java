package pro.sky.ju;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private final static String USER = "user";
    private final static String USER_MAIL = "user@mail.com";
    private final static String SYMBOL = "@";
    private final static String POINT = ".";
    private static User user;

    @BeforeAll
    static void addNewUserWithParameters() {
        user = new User(USER, USER_MAIL);
        System.out.println("Создать через конструктор с параметрами:" + user.getEmail() + " " + user.getLogin());
    }

    @BeforeAll
    static void addNewUserWithoutParameters() {
        user = new User();
        System.out.println("Создать через конструктор без параметров:" + user.getEmail() + " " + user.getLogin());
    }

    @Test
    void shouldCheckSymbols() {
        Assertions.assertTrue(user.getEmail().contains(SYMBOL));
        Assertions.assertTrue(user.getEmail().contains(POINT));
    }

    @Test
    void shouldNameNotEqualsMail() {
        assertNotEquals(user.getEmail(), user.getLogin());
    }
    @Test
    public void shouldCheckUserForExceptions () throws RuntimeException {
        RuntimeException e = assertThrows(RuntimeException.class, () -> {
            new User("bobrov", "bobrov");
            new User(" ", "bobrov");
            new User(" ", " ");
        });
        assertNotNull(e.getMessage());
    }
}