package services;

import dao.DAOStudent;
import dao.impl.StudentDAOjdbc;
import entities.Student;

import java.util.List;

public class StudentSearchService {
    private DAOStudent studentDAO =
            new StudentDAOjdbc();

    public List<Student> getStudentsByNameMask(String q) {
        return studentDAO.getStudentsByNameMask(q);
    }
}
