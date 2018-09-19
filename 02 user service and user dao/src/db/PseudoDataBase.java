package db;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class PseudoDataBase {

    private static List<User> users;

    public static List<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
            users.add(new User("andrey2000", "edward"));
            users.add(new User("andrey99", "nail"));
        }
        return users;
    }
}
