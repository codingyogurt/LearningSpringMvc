package com.codingyogurt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/index.do")
public class IndexServlet extends HttpServlet{
	
	IndexLoginService IndexLoginService = new IndexLoginService();
	
	@Override
	protected void doGet(HttpServletRequest indexRequest, HttpServletResponse indexResponse) throws ServletException, IOException{
		indexRequest.getRequestDispatcher("/WEB-INF/views/IndexView.jsp").forward(indexRequest, indexResponse);
	}
	
	protected void doPost(HttpServletRequest indexRequest, HttpServletResponse indexResponse) throws ServletException,IOException{
		String indexUsername = indexRequest.getParameter("txtUsername");
		String indexPassword = indexRequest.getParameter("txtPassword");
		
		if(IndexLoginService.verifyUser(indexUsername, indexPassword)) {
			indexRequest.setAttribute("username", indexUsername);
			indexRequest.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(indexRequest, indexResponse);
			
		} else {
			indexRequest.setAttribute("indexMessage", "Error Logging in.");
			indexRequest.getRequestDispatcher("/WEB-INF/views/IndexView.jsp").forward(indexRequest, indexResponse);
			
			
		}
	}
	  
	
}
