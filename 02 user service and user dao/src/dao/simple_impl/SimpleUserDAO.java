package dao.simple_impl;

import dao.UserDAO;
import db.PseudoDataBase;
import entities.User;

import java.sql.PseudoColumnUsage;
import java.util.List;


public class SimpleUserDAO implements UserDAO {
    @Override
    public User getByUsername(String username) {
        List<User> users = PseudoDataBase.getUsers();
        for (User user: users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
