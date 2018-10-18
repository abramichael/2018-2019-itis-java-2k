package servlets;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import helpers.MainHelper;

import java.io.IOException;

public class SearchPageServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        Template t = MainHelper
                .getConfig(request.getServletContext())
                .getTemplate("search.ftl");
        try {
            t.process(null, response.getWriter());
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
