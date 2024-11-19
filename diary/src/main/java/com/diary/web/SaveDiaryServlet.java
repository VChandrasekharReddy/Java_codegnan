package com.diary.web;

import java.io.IOException;
import java.time.LocalDate;

import com.diary.model.User;
import com.diary.service.DiaryServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveDiaryServlet
 */
@WebServlet("/SaveDiaryServlet")
public class SaveDiaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private  DiaryServiceImpl diaryService = new DiaryServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDiaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = null;
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("userdata");
		String diarymater = request.getParameter("diarydata");
		if(diaryService.adddiary(user.getUserid(),LocalDate.now(),diarymater)) {
			message = "add the the data.....";
		}
		else {
			message = "error while addling the data......";
		}
		session.setAttribute("message", message); // Store in session
		response.sendRedirect(request.getContextPath() + "/public/html/home.jsp");
	}
	

}
