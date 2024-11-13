package com.diary.web;

import java.io.IOException;

import com.diary.model.User;
import com.diary.service.DiaryServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginAction")
public class LoginActionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  DiaryServiceImpl diaryService = new DiaryServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (diaryService.loginservice(username, password)) {
            // User authenticated successfully, create a session
        	User userdata = diaryService.getuserdata(username,password);
            HttpSession session = request.getSession();
            session.setAttribute("userdata", userdata);
            session.setMaxInactiveInterval(60 * 60 * 24 * 7); // Session timeout set to 7 days;
            response.sendRedirect(request.getContextPath() + "/public/html/home.jsp");
        } else {
            // Authentication failed, redirect back to login with an error message
            response.sendRedirect("login.jsp?error=invalid_credentials");
        }

    }
}
