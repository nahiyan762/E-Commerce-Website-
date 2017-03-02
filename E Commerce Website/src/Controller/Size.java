package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessService.SizeData;
import Model.dalSize;

@WebServlet("/Size")
public class Size extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		dalSize data = new dalSize();
		if(data.DELETE(id))
		{
			response.sendRedirect("./ViewSize.jsp");
		}
		else
		{
			out.println("hoynai");
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("InsertSize") != null) 
		{
			String size = request.getParameter("size");
			
			int err = 0;
			String msg = "";
			
			if(size.isEmpty())
			{
				err++;
				msg  = msg + "Size Required" + "<br>" ;
			}
			
			if(err == 0)
			{
				SizeData sizedata = new SizeData();
				
				sizedata.setSize(size);
				
				
				dalSize dalSize = new dalSize();
				if(dalSize.Insert(sizedata))
				{
					response.sendRedirect("./ViewSize.jsp");
				}
				else
				{
					out.println("Hoynai");
				}

			}
			out.print(msg);
		}
		else if(request.getParameter("UpdateSize") != null)
		{
			String ID = request.getParameter("id");
			String Size = request.getParameter("size");
			
			SizeData data = new SizeData();
			
			data.setSize(Size);
			
			
			dalSize dalSize = new dalSize();
			if(dalSize.Update(data, ID))
			{
				response.sendRedirect("./ViewSize.jsp");
			}
			else
			{
				out.println("Hoynai");
			}

		}
	}

}
