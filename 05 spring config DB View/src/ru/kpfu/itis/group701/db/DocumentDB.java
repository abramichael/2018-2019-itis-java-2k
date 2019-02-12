package ru.kpfu.itis.group701.db;

import ru.kpfu.itis.group701.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentDB implements DB {
    private Scanner scanner;
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split("\t");
            users.add(
                    new User(data[0], data[1], Integer.parseInt(data[2]))
            );
        }
        return users;
    }

    @Override
    public User getUser(String username) {
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split("\\t");
            if (username.equals(data[0])) {
                return new User(data[0], data[1], Integer.parseInt(data[2]));
            }
        }
        return null;
    }
}
