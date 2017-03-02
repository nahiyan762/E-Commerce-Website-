package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessService.OrderData;
import BusinessService.PurchaseData;
import Model.dalOrder;
import Model.dalPurchase;

@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		Vector<String> pid = (Vector<String>)session.getAttribute("cart");
   	    Vector<Integer> pqty = (Vector<Integer>)session.getAttribute("qty");
   	    
   	    for(int i=0; i<pid.size(); i++)
   	    {
   	    	if(Integer.parseInt(pid.elementAt(i)) == id)
   	    	{
   	    		pid.remove(i);
   	    		pqty.remove(i);
   	    		
   	    		session.setAttribute("cart", pid);
   	    		session.setAttribute("qty", pqty);
   	    	}
   	    }
   	    if(pid.size()==0)
   	    {
   	    	response.sendRedirect("./Index.jsp");
   	    }
   	    else
   	    {
   	    	response.sendRedirect("./Checkout.jsp");
   	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Vector<String> pid = (Vector<String>)session.getAttribute("cart");
   	    Vector<Integer> pqty = (Vector<Integer>)session.getAttribute("qty");
		
   	    if (request.getParameter("UpdateQty") != null) 
		{
			for(int i=0; i<pid.size(); i++)
			{
				if(pid.elementAt(i).equals(request.getParameter("id")))
				{
					pqty.remove(i);
					pqty.add(i, Integer.parseInt(request.getParameter("qty")));
					
					session.setAttribute("qty", pqty);
				}
			}
			response.sendRedirect("./Checkout.jsp");
		}
		else if(request.getParameter("Order") != null)
		{
			if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("member"))
			{
				Date now = new Date();
			    Calendar cal = Calendar.getInstance();
			    cal.setTime(now);
			    
			    String date = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH);
			    int total = (int) session.getAttribute("total");
			    String userID = (String) session.getAttribute("userID");
	//out.println(Date+"->"+total+"->"+userID);
			    
			    PurchaseData pData = new PurchaseData();
			    pData.setDate(date);
			    pData.setTotal(total);
			    pData.setUserID(userID);
			    
			    dalPurchase dalP = new dalPurchase();
			    //out.println(dalP.GetLastID());
			    if(dalP.Insert(pData))
			    {
			    	for(int i=0; i<pid.size(); i++)
			    	{
			    		int quantity = pqty.elementAt(i);
			    		int productId = Integer.parseInt(pid.elementAt(i));
			    		int purchaseId = dalP.GetLastID();
			    		
			    		OrderData oData = new OrderData();
			    		oData.setProductId(productId);
			    		oData.setPurchaseId(purchaseId);
			    		oData.setQuantity(quantity);
			    		
			    		dalOrder dalorder = new dalOrder();
			    		if(dalorder.Insert(oData))
			    		{
			    			session.removeAttribute("cart");
			    			session.removeAttribute("qty");
			    			response.sendRedirect("./Delivary.jsp");
			    		}
			    		else
			    		{
			    			out.println("Hoynai");
			    		}
			    	}
			    	
			    }
			    else
			    {
			    	out.println("Hoy nai");
			    }
			    
			}
			else
			{
				response.sendRedirect("./Login.jsp");
			}
		}
	}

}
