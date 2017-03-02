<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalSize" %>
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
<table align="center" border="1">
	<tr>
		<th>Size Id</th>
		<th>Size</th>
	</tr>
	<%
	dalSize data = new dalSize();
	Vector<Vector<String>> list = data.ViewList();
	for(int i=0;  i<list.size(); i++ )
	{
	%>
		<tr>
			<td><% out.println(list.elementAt(i).get(0)); %></td>
			<td><% out.println(list.elementAt(i).get(1)); %></td>
			<td><a  href="EditSize.jsp?id=<% out.println(list.elementAt(i).get(0)); %>">Update</a></td>
         	<td><a  href="Size?id=<% out.println(list.elementAt(i).get(0)); %>">Delete</a></td>
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