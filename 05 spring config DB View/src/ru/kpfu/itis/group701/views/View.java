package ru.kpfu.itis.group701.views;

import ru.kpfu.itis.group701.models.User;

import java.util.List;

public interface View {
    String showUser(User user);
    String showUsers(List<User> users);
}
