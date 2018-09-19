package services;

import dao.UserDAO;
import dao.simple_impl.SimpleUserDAO;
import entities.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserService {

    private UserDAO userDAO = new SimpleUserDAO();

    public User getCurrentUser(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("current_user");
        return user;
    }

    public User authenticate(HttpServletRequest request) {
        String username = request.getParameter("username");
        if (username != null) {
            User user = userDAO.getByUsername(username);
            if (user == null) {
                return null;
            }
            String password = request.getParameter("password");
            if (password.equals(user.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    public void authorize(User current_user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("current_user", current_user);
    }
}
