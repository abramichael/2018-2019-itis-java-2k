package servlets;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import entities.Student;
import services.StudentSearchService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DoSearchServlet extends HttpServlet {
    private StudentSearchService studentSearchService =
            new StudentSearchService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> students = studentSearchService.getStudentsByNameMask(
                request.getParameter("q")
        );
        JsonArray ja = new JsonArray();
        for (Student student: students) {
            ja.add(student.getName());
        }
        JsonObject jo = new JsonObject();
        jo.add("students", ja);
        response.setContentType("text/json");
        response.getWriter().println(jo.toString());

    }
}
