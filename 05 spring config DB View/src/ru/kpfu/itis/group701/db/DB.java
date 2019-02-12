package ru.kpfu.itis.group701.db;

import ru.kpfu.itis.group701.models.User;

import java.util.List;

public interface DB {
    List<User> getUsers();
    User getUser(String username);
}
