package Servlets;

import Models.User;
import Services.UserService;
import org.apache.ibatis.session.SqlSession;
import org.eclipse.jetty.servlet.Source;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private final TemplateEngine engine;
    private final UserService service;
    public RegisterServlet(TemplateEngine engine, SqlSession session) {
        this.engine=engine;
        this.service = new UserService(session);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        engine.render("signUp.ftl",resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String imageURL = req.getParameter("imageURL");
        User newUser = imageURL != null ? new User(username, password, gender, imageURL) : new User(username, password, gender);
        if (service.registerUser(newUser)) {
            resp.sendRedirect("/login/");
        } else {
            resp.sendRedirect("/register/");
        }
    }

}
