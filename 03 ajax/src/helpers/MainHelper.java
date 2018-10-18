package helpers;

import entities.Student;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainHelper {
    private static String URL = "jdbc:postgresql://localhost:5432/first701";
    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";
    private static Connection conn;
    public static Connection getConn() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(
                        URL,
                        USERNAME,
                        PASSWORD
                );
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public static Student makeORMStudent(ResultSet rs) {
        try {
            rs.next();
            return new Student(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getInt("year"),
                    rs.getString("city")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Student> makeORMStudentList(ResultSet rs){
        List<Student> students = new ArrayList<>();
        Student s = makeORMStudent(rs);
        while (s != null) {
            students.add(s);
            s = makeORMStudent(rs);
        }
        return students;
    }
    private static Configuration cfg = null;

    public static Configuration getConfig(ServletContext sc) {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_22);
            cfg.setServletContextForTemplateLoading(sc, "/WEB-INF/templates");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        }
        return cfg;

    }
}
