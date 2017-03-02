package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessService.DelivaryData;
import Model.dalDelivary;
import Model.dalService;

@WebServlet("/Delivary")
public class Delivary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if (request.getParameter("submit") != null) 
		{
			int areaid = Integer.parseInt(request.getParameter("areaid"));
			String address = request.getParameter("addr");
			
			
			dalService dalservice = new dalService();
			String arr[] = dalservice.SelectById(areaid);
			
			int totalAmount = (Integer)session.getAttribute("total") + Integer.parseInt(arr[2]);
			
			Date now = new Date();
		    Calendar cal = Calendar.getInstance();
		    cal.add(Calendar.DATE, +7);
		    
		    String date = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
			
		    DelivaryData data = new DelivaryData();
		    data.setAreaId(areaid);
		    data.setAddress(address);
		    data.setTotalAmount(totalAmount);
		    data.setDate(date);
		    
		    dalDelivary daldelivary = new dalDelivary();
		    if(daldelivary.Insert(data))
		    {
		    	response.sendRedirect("./Index.jsp");
		    }
		    else
		    {
		    	out.println("Hoy nai");
		    }   
		}
		else if(request.getParameter("Confirm") != null)
		{
			String check[]= request.getParameterValues("check");
			dalDelivary daldelivary = new dalDelivary();
			//daldelivary.CheckList(check);
			if(daldelivary.CheckList(check))
			{
				response.sendRedirect("./Delivary.jsp");
			}
			else
			{
				out.println("Hoy nai");
			}
		}
	}

}
