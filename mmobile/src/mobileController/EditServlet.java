package mobileController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mobileModel.ProductModel;
import mobileDAO.EditDAO;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd=null;
		String pid;
		ProductModel temp;
		if(request.getParameter("oper")!=null)
		{
			if(request.getParameter("oper").equals("edit") )
			{
				pid=request.getParameter("pid");		

			    temp=EditDAO.getProductsByPid(pid);
			    if(temp!=null)
			    {
			    	request.setAttribute("product", temp);
			    	rd=request.getRequestDispatcher("editproduct.jsp");
			    	rd.forward(request, response);
			    }
			    
			}
			
		}
		if(request.getParameter("confirmedit")!=null)
		{
			pid=request.getParameter("pid");	
			String pname=request.getParameter("pname");
			String brand=request.getParameter("brand");
			String ram= request.getParameter("ram");
			String rom=request.getParameter("rom");
			String processor=request.getParameter("processor");
			String battery=request.getParameter("battery");
			String price=request.getParameter("price");
			String descrptn=request.getParameter("descrptn");
			temp = new ProductModel();
			temp.setPname(pname);
			temp.setBrand(brand);
			temp.setRam(ram);
			temp.setRom(rom);
			temp.setProcessor(processor);
			temp.setBattery(battery);
			temp.setPrice(price);
			temp.setDescrptn(descrptn);
			if(EditDAO.EditProductByPid(temp))
			 	request.setAttribute("successmsg", "Updated succssfully");
			else
				request.setAttribute("errormsg", "Not updated");			 
			rd=request.getRequestDispatcher("editproduct.jsp");
    	    rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
