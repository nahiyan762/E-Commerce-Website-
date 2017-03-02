package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessService.CategoryData;
import BusinessService.SizeData;
import Model.dalCategory;
import Model.dalSize;

@WebServlet("/Category")
public class Category extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		dalCategory dalcategory = new dalCategory();
		if(dalcategory.DELETE(id))
		{
			response.sendRedirect("./ViewCategory.jsp");
		}
		else
		{
			out.println("hoynai");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("InsertCategory") != null) 
		{
			String category = request.getParameter("category");
			
			int err = 0;
			String msg = "";
			
			if(category.isEmpty())
			{
				err++;
				msg  = msg + "Category Name Required" + "<br>" ;
			}
			
			if(err == 0)
			{
				CategoryData data = new CategoryData();
					data.setCategoryName(category);
				
				dalCategory dalcategory = new dalCategory();
					if(dalcategory.Insert(data))
					{
						response.sendRedirect("./ViewCategory.jsp");
					}
					else
					{
						out.println("Hoynai");
					}

			}
			out.print(msg);	
		}
		else if (request.getParameter("UpdateCategory") != null) 
		{
			String ID = request.getParameter("id");
			String category = request.getParameter("category");
			
			CategoryData data = new CategoryData();
				data.setCategoryName(category);;
			
			
			dalCategory dalcategory = new dalCategory();
				if(dalcategory.Update(data, ID))
				{
					response.sendRedirect("./ViewCategory.jsp");
				}
				else
				{
					out.println("Hoynai");
				}

		}
	}

}
