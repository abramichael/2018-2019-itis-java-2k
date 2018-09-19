package dao;

import entities.User;

public interface UserDAO {
    User getByUsername(String username);
}
