package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddtoCART")
public class AddtoCART extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		int check=0;
		
		if((Vector<String>)session.getAttribute("cart") == null && (Vector<Integer>)session.getAttribute("qty") == null)
		{
			Vector<String> pid = new Vector<String>();
			Vector<Integer> pqty = new Vector<Integer>();
			
			pid.add(request.getParameter("id"));
			pqty.add(1);
			
			session.setAttribute("cart", pid);
			session.setAttribute("qty", pqty);
		}
		else
		{
			Vector<String> pid = (Vector<String>)session.getAttribute("cart");
			Vector<Integer> pqty = (Vector<Integer>)session.getAttribute("qty");
			for(int i=0; i<pid.size(); i++)
			{
//				System.out.println(pid.elementAt(i));
//				System.out.println(request.getParameter("id"));
				if(pid.elementAt(i).equals(request.getParameter("id")))
				{
					check++;
					break;
				}
			}
			if(check==0)
			{
				pid.add(request.getParameter("id"));
				pqty.add(1);
				
				session.setAttribute("cart", pid);
				session.setAttribute("qty", pqty);
			}
		}
		request.getRequestDispatcher("./Details.jsp?id="+request.getParameter("id")).forward(request, response);
		//response.sendRedirect("./Details.jsp?id="+request.getParameter("id"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
