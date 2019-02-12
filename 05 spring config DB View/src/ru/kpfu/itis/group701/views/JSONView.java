package ru.kpfu.itis.group701.views;

import ru.kpfu.itis.group701.models.User;

import java.util.List;

public class JSONView implements View {
    @Override
    public String showUser(User user) {
        return "{\"userame\": " + user.getUsername() + "}" ;
    }

    @Override
    public String showUsers(List<User> users) {
		// TODO - do
        return "LIST of users";
    }
}
