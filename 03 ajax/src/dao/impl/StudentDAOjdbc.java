package dao.impl;

import dao.DAO;
import dao.DAOStudent;
import entities.Student;
import helpers.MainHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOjdbc implements DAOStudent {
    @Override
    public Student get(long i) {
        Connection conn = MainHelper.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "select * from students where id = ?"
            );
            ResultSet rs = ps.executeQuery();
            Student s = MainHelper.makeORMStudent(rs);
            return s;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Student obj) {

    }

    @Override
    public void delete(long i) {

    }

    @Override
    public void create(Student obj) {

    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public List<Student> getStudentsByNameMask(String q) {
        try {
            PreparedStatement ps = MainHelper.getConn().prepareStatement(
                    "select * from students where name like ?"
            );
            ps.setString(1, "%" + q + "%");
            ResultSet rs = ps.executeQuery();
            return MainHelper.makeORMStudentList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
