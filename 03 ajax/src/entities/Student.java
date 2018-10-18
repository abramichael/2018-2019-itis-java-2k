package entities;

public class Student {
    private long id;
    private String name;
    private int year;
    private String city;

    public Student(long id, String name, int year, String city) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }
}
