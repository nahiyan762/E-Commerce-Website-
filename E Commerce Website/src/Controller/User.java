package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessService.ServiceData;
import BusinessService.UserData;
import Model.dalService;
import Model.dalUser;

@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		dalUser daluser = new dalUser();
		if(daluser.DELETE(id))
		{
			response.sendRedirect("./ViewUser.jsp");
		}
		else
		{
			out.println("hoynai");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	    String name = (String)session.getAttribute("userType");
		
		
		if (request.getParameter("InsertUser") != null) 
		{
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			String type;
			
			if(name.equals("admin"))
			{
				type = "admin";
			}
			else
			{
				type = "member";
			}
			
			int err = 0;
			String msg = "";
			
			if(username.isEmpty() || email.isEmpty() || contact.isEmpty() || password.isEmpty() || gender.isEmpty())
			{
				err++;
				msg  = msg + "Required" + "<br>" ;
			}
			
			if(err == 0)
			{
				UserData data = new UserData();
					data.setUsername(username);
					data.setEmail(email);
					data.setContact(contact);
					data.setPassword(password);
					data.setGender(gender);
					data.setType(type);
				
				
				dalUser daluser = new dalUser();
				if(daluser.Insert(data))
				{
					response.sendRedirect("./ViewUser.jsp");
				}
				else
				{
					out.println("Hoynai");
				}

			}
			out.print(msg);
		}
		else if (request.getParameter("UpdateUser") != null) 
		{

			String ID = request.getParameter("id");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String password = request.getParameter("password");
			String gender = request.getParameter("gender");
			
			UserData data = new UserData();
				data.setUsername(username);
				data.setEmail(email);
				data.setContact(contact);
				data.setPassword(password);
				data.setGender(gender);
				
			dalUser daluser = new dalUser();
			if(daluser.Update(data, ID))
			{
				response.sendRedirect("./ViewUser.jsp");
			}
			else
			{
				out.println("Hoynai");
			}

		}
	}

}
