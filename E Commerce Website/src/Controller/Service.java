package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessService.ServiceData;
import Model.dalService;

@WebServlet("/Service")
public class Service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		dalService dalservice = new dalService();
		if(dalservice.DELETE(id))
		{
			response.sendRedirect("./ViewService.jsp");
		}
		else
		{
			out.println("hoynai");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("InsertService") != null) 
		{
			String area = request.getParameter("area");
			String price = request.getParameter("price");
			
			int err = 0;
			String msg = "";
			
			if(area.isEmpty())
			{
				err++;
				msg  = msg + "Area Required" + "<br>" ;
			}
			
			if(price.isEmpty())
			{
				err++;
				msg  = msg + "Price Required" + "<br>" ;
			}
			
			
			if(err == 0)
			{
				ServiceData data = new ServiceData();
				
				data.setServiceArea(area);
				data.setServicePrice(price);
				
				
				dalService dalservice = new dalService();
				if(dalservice.Insert(data))
				{
					response.sendRedirect("./ViewService.jsp");
				}
				else
				{
					out.println("Hoynai");
				}

			}
			out.print(msg);


		}
		else if (request.getParameter("UpdateService") != null) 
		{
			String ID = request.getParameter("id");
			String area = request.getParameter("area");
			String price = request.getParameter("price");
			
			ServiceData data = new ServiceData();
			
			data.setServiceArea(area);
			data.setServicePrice(price);
			
			dalService dalservice = new dalService();
			if(dalservice.Update(data, ID))
			{
				response.sendRedirect("./ViewService.jsp");
			}
			else
			{
				out.println("Hoynai");
			}

		}
	}

}
