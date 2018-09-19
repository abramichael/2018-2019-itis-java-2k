package servlets;

import entities.User;
import services.UserService;

import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        if (userService.getCurrentUser(request) != null) {
            response.sendRedirect("/profile");
        } else {
            User current_user = userService.authenticate(request);
            if (current_user != null) {
                userService.authorize(current_user, request);
                response.sendRedirect("/profile");
            } else {
                //ошибка
                response.sendRedirect("/login?err_mess=too_bad_login");
            }
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        if (userService.getCurrentUser(request) != null) {
            response.sendRedirect("/profile");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<form method='POST' >" +
                    "<input type='text' name='username' />" +
                    "<input type='password' name='password' />" +
                    "<input type='submit' value='login' />" +
                    "</form>");
        }
    }
}
