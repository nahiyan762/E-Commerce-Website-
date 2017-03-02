package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessService.CategoryData;
import BusinessService.ServiceData;
import BusinessService.SubCategoryData;
import Model.dalCategory;
import Model.dalService;
import Model.dalSubCategory;

@WebServlet("/SubCategory")
public class SubCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		dalSubCategory dalsubCategory = new dalSubCategory();
		if(dalsubCategory.DELETE(id))
		{
			response.sendRedirect("./ViewSubCategory.jsp");
		}
		else
		{
			out.println("hoynai");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("SaveSubCategory") != null)
		{
			String subcategory = request.getParameter("subcategory");
			int categoryId = Integer.parseInt(request.getParameter("categoryid"));

			int err = 0;
			String msg = "";
			
			if(subcategory.isEmpty())
			{
				err++;
				msg  = msg + "subcategory Name Required" + "<br>" ;
			}
			
			if(err == 0)
			{
				SubCategoryData data = new SubCategoryData();
					data.setSubCategoryName(subcategory);
					data.setCategoryId(categoryId);
				
				dalSubCategory dalsubCategory = new dalSubCategory();
					if(dalsubCategory.Insert(data))
					{
						response.sendRedirect("./ViewSubCategory.jsp");
					}
					else
					{
						out.println("Hoynai");
					}

			}
			out.print(msg);	
		}
		else if(request.getParameter("UpdateSubCategory") != null)
		{
			String ID = request.getParameter("id");
			String subcategory = request.getParameter("subcategory");
			int categoryid = Integer.parseInt(request.getParameter("categoryid"));
			
			SubCategoryData data = new SubCategoryData();			
				data.setSubCategoryName(subcategory);
				data.setCategoryId(categoryid);
			
			dalSubCategory dalsubCategory = new dalSubCategory();
			if(dalsubCategory.Update(data, ID))
			{
				response.sendRedirect("./ViewSubCategory.jsp");
			}
			else
			{
				out.println("Hoynai");
			}
		}
			
	}

}
