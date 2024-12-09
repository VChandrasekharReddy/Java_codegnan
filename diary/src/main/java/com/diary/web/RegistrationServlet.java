package com.diary.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.diary.model.User;
import com.diary.service.DiaryServiceImpl;
//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServletAction")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DiaryServiceImpl diaryService = new DiaryServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = null;
        String userid = request.getParameter("userid");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String mobilenumber = request.getParameter("mobile");
        String password = request.getParameter("password");
        String cpass = request.getParameter("confirm-password");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");
        LocalDate dofb = LocalDate.parse(request.getParameter("dofb"));
        
        if(diaryService.isvalieduserid(userid) && diaryService.isvaliedusername(username) && diaryService.isvaliedemail(email) && diaryService.isvaliedmobilenumber(mobilenumber)&& diaryService.isvaliedpassword(password)) {          
            // Check if the user ID is unique
            if (diaryService.unique(userid)) {
                // Create a new user object
                User user = new User(userid, username, mobilenumber, email, password, question, answer, LocalDateTime.now(), dofb, 0);
                // Try registering the user
                if (diaryService.registeruser(user)) {
                    response.sendRedirect("login.jsp?error=_account_created_please_login_now_");
                }else {
                    response.sendRedirect("public/html/registration.jsp?error=invalid_credentials_or mobile or email are alreday used please give the unique details");
                    return; // Stop further processing
                }
            }else {
                response.sendRedirect("public/html/registration.jsp?error=userid_already_exist");
                return; // Stop further processing
            }
        }else {
        	 response.sendRedirect("public/html/registration.jsp?error=invalied formats enterd");
        	 return;
        }
 
    }


}
