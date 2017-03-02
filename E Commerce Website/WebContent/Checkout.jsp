<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalProduct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("cart") != null && session.getAttribute("qty") != null)
{
%>
	<table width="1000" align="center" border="1">
		<tr>
            <th>Product</th>
            <th>Price</th>
            <th>Vat</th>
            <th>Discount</th>
            <th>Quantity</th>
            <th>Total Price</th>
            <th>Delete</th>
        </tr>
        <%

			Vector<String> pid = (Vector<String>)session.getAttribute("cart");
			Vector<Integer> pqty = (Vector<Integer>)session.getAttribute("qty");        	
       	 	
			int total = 0;
       	    for(int i=0; i<pid.size(); i++)
        	{
        		dalProduct dalproduct = new dalProduct();
        		String id = pid.elementAt(i);
        		String arr[] = dalproduct.SelectById(Integer.parseInt(id));
        		%>
        		<tr>
					<td align="center"><img style="width: 50px;height: 50px;" src="image/<% out.println(arr[5]); %>"></td>
					<td align="center"><% out.println(arr[2]);%></td>
					<td align="center"><% out.println(arr[3]);%></td>
					<td align="center"><% out.println(arr[4]);%></td>
					<td align="center" style="width: 250px;"> 
						<form action="Checkout" method="post">
                    		<input type="text" name="qty" value="<%out.println(pqty.elementAt(i)); %>">
                    		<input type="hidden" name="id" value="<% out.print(id); %>">
                    		<input type="submit" name="UpdateQty" value="Update">
                  		</form>
					</td>
					
					<td align="center">
					<% 
						int t=0;
						int price = Integer.parseInt(arr[2]) * pqty.elementAt(i);
						t += price + (price * Integer.parseInt(arr[3]))/100 - (price * Integer.parseInt(arr[4]))/100; 
						out.println("$"+t);
						total += t; 
					%>
					</td>
					<td align="center">
						<a href="Checkout?id=<% out.println(id); %>">Remove</a>
					</td>
		</tr>
				<%
        	}
        %>
        <tr>
			<td colspan="5" align="right">Total Amount: </td>
            <td colspan="2" align="center">
            	<% out.println("$"+total); session.setAttribute("total", total); %>
            </td>
        </tr>
        <tr>
        	<form action="Checkout" method="post">
				<tr align="center">
                	<td colspan="4"><a href="Index.jsp">Continue Shopping</a></td>
                    <td colspan="3"><input type="submit" name="Order" value="Place Order"></td>
                </tr>
            </form>
        </tr>
	</table>	
<%
}
else
{
	String referer = request.getHeader("Referer");
	response.sendRedirect(referer);
}
%>
</body>
</html>