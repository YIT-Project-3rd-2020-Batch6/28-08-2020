package mobileController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobileDAO.ForgotDAO;
import mobileModel.RegisterModel;

/**
 * Servlet implementation class ForgotServlet
 */
@WebServlet("/ForgotServlet")
public class ForgotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RegisterModel registerModel=new RegisterModel();
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String userid=request.getParameter("userid");  
		    String secretqsn=request.getParameter("secretqsn");
		    String secretans=request.getParameter("secretans");
		    registerModel.setUserid(userid);
	        registerModel.setSecretqsn(secretqsn);
	        registerModel.setSecretans(secretans);
		       
		    if(ForgotDAO.validate(registerModel)){  
		        RequestDispatcher rd=request.getRequestDispatcher("Reset.jsp");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        out.print("Sorry secretqsn or secretans error");  
		        RequestDispatcher rd=request.getRequestDispatcher("Forgotpassword.jsp");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  			 
		
	}
	}

