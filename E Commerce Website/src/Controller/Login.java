package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessService.LoginData;
import Model.dalLogin;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		session.removeAttribute("userType");
		response.sendRedirect("./Index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if (request.getParameter("Login") != null) 
		{
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			int err = 0;
			String msg = "";
			
			if(email.equals(null) && password.equals(null))
			{
				err++;
				msg  = msg + "Required" + "<br>" ;
			}
			
			if(err == 0)
			{
				LoginData data = new LoginData();
				
				data.setUserEmail(email);
				data.setUserPassword(password);
				
				dalLogin dallogin = new dalLogin();
				
				Vector<LoginData> list = dallogin.SelectBy(data);
				
				if(list.size() != 0)
				{
					for(int i=0; i<list.size(); i++)
					{
						session.setAttribute("userID",list.elementAt(i).getUserID());
						session.setAttribute("userType",list.elementAt(i).getUserType());
					}
					
					if(session.getAttribute("userType").equals("admin"))
					{
						response.sendRedirect("./AdminIndex.jsp");
					}
					else
					{
						response.sendRedirect("./Index.jsp");
					}
					
				}
				else
				{
					response.sendRedirect("./Login.jsp");
				}
			}
		}
	}

}
