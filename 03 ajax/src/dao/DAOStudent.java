package dao;

import entities.Student;

import java.util.List;

public interface DAOStudent extends DAO<Student> {
    List<Student> getStudentsByNameMask(String q);
}
