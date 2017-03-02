<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalDelivary" %> 
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
	<form action="Delivary"  method="post" >
		<table align="center" border="1">
  			<tr>
  				<th>Delivary Id</th>
  				<th>Area</th>
  				<th>Address</th>
  				<th>Amount</th>
  				<th>Delivary Date</th>
            	<th>Delivared OR Not</th>
  			</tr>
  			<%
  				dalDelivary daldelivary = new dalDelivary();
				Vector<Vector<String>> list = daldelivary.ViewList();
				for(int i=0;  i<list.size(); i++ )
				{
			%>
				<tr>
					<td><% out.println(list.elementAt(i).get(0)); %></td>
					<td><% out.println(list.elementAt(i).get(1)); %></td>
					<td><% out.println(list.elementAt(i).get(2)); %></td>
					<td><% out.println(list.elementAt(i).get(3)); %></td>
					<td><% out.println(list.elementAt(i).get(4)); %></td>
					<td align="center"><input type="checkbox" name="check" value="<%out.println(list.elementAt(i).get(0));%>" <% if(list.elementAt(i).get(5).equals("clear")) out.println("checked"); %>></td>
        		</tr>
			<% 
				}
			%>
				<tr>
        			<td align="center" colspan="7"><input style="width:300px" type="submit" name="Confirm" value="Confirm"></td>
        		</tr>
  		</table>
	</form>
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