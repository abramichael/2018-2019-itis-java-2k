package ru.kpfu.itis.group701.models;

public class User {
    private String username;
    private String city;
    private int year;

    public User(String username, String city, int year) {
        this.username = username;
        this.city = city;
        this.year = year;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
