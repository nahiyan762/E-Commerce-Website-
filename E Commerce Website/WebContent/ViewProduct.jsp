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
if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("admin"))
{
%>
<table width="500" align="center" border="1">
		<tr>
        	<th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Vat</th>
            <th>Discount</th>
            <th>Picture</th>
            <th>Details</th>
            <th>Quantity</th>
            <th>SubCategory</th>
            <th>Size</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%
        	dalProduct dalproduct = new dalProduct();
        	Vector<Vector<String>> list = dalproduct.ViewList();
			for(int i=0;  i<list.size(); i++ )
			{
        %>
        <tr>
			<td><% out.println(list.elementAt(i).get(0)); %></td>
			<td><% out.println(list.elementAt(i).get(1)); %></td>
			<td><% out.println(list.elementAt(i).get(2)); %></td>
			<td><% out.println(list.elementAt(i).get(3)); %></td>
			<td><% out.println(list.elementAt(i).get(4)); %></td>
			<td><img style="width: 150px;height: 150px;" src="image/<% out.println(list.elementAt(i).get(5)); %>"></td>
			<td><% out.println(list.elementAt(i).get(6)); %></td>
			<td><% out.println(list.elementAt(i).get(7)); %></td>
			<td><% out.println(list.elementAt(i).get(8)); %></td>
			<td><% out.println(list.elementAt(i).get(9)); %></td>
			<td><a href="EditProduct.jsp?id=<% out.println(list.elementAt(i).get(0)); %>">Update</a></td>
        	<td><a href="Product?id=<% out.println(list.elementAt(i).get(0)); %>">Delete</a></td>
		</tr>
 		<%
			}
		%>
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