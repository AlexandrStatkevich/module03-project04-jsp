package by.alst.project.jdbc.servlet;

import by.alst.project.jdbc.service.InformationService;
import by.alst.project.jdbc.service.UserService;
import by.alst.project.jdbc.utils.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();
    private final InformationService informationService = InformationService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userService.findAll());
        req.setAttribute("informationService", informationService);
        req.getRequestDispatcher(JspHelper.getPath("users")).forward(req, resp);
    }
}