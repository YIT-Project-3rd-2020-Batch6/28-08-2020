package mobileController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobileDAO.RegisterDAO;
import mobileModel.RegisterModel;
/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServlet() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getAttribute("sub")!=null)
		{
		String userid=request.getParameter("userid");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String phonenumber=request.getParameter("phno");
		String secretquestion=request.getParameter("secretqsn");
		String secretanswer=request.getParameter("secretans");
		String address=request.getParameter("address");
		String utype="user";
		RegisterModel registration=new RegisterModel(userid, name, gender, email, password,  phonenumber, secretquestion, secretanswer, address, utype);
	    RegisterDAO rDao=new RegisterDAO();
	    boolean status=rDao.insert(registration);
	    try {
            if(status=true)
            {
            	request.setAttribute("successmsg", "Registered Succesfully");
            	response.sendRedirect("Login.jsp");
            }
            else
            {
            	request.setAttribute("errormsg", "Register Unsuccesfull");
            	RequestDispatcher rd=request.getRequestDispatcher("Register.jsp");  
	            rd.forward(request,response); 
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}