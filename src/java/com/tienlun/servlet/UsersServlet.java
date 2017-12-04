/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.servlet;

import com.tienlun.dao.UsersDAO;
import com.tienlun.model.Users;
import com.tienlun.util.PasswordService;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tienpv
 */
public class UsersServlet extends HttpServlet {

    UsersDAO usersDAO = new UsersDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String command = request.getParameter("command");
        String url = "";
        Users users = new Users();
        HttpSession session = request.getSession();
        switch (command) {
            case "insert.html":
                users.setEmail(request.getParameter("email"));
                users.setPassword(request.getParameter(PasswordService.encryption("pass")));
                users.setIsActive(1L);
                usersDAO.insertUser(users);
                session.setAttribute("user", users);
                url = "/index.jsp";
                break;
            case "login.html":
                users = usersDAO.login(request.getParameter("email"), PasswordService.encryption(request.getParameter("pass")));
                if (users != null) {
                    session.setAttribute("user", users);
                    url = "/index.jsp";
                } else {
                    request.setAttribute("error", "Error email or password!");
                    url = "/login.jsp";
                }
                break;
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
