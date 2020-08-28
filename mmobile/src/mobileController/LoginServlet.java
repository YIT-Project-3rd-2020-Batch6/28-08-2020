package mobileController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobileDAO.LoginDAO;
import mobileModel.RegisterModel;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RegisterModel registerModel=new RegisterModel();
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String userid=request.getParameter("userid");  
		    String password=request.getParameter("password");
		    registerModel.setUserid(userid);
	        registerModel.setPassword(password);
	        
		    if(LoginDAO.validate(registerModel)){ 
		    	request.setAttribute("successmsg", "login successfully");
		        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        request.setAttribute("errormsg", "Wrong username or password");
		        RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  			 
		
	}
}
