<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalUser" %> 
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
			<th>User Id</th>
			<th>User name</th>
			<th>E-mail</th>
			<th>Contact Number</th>
			<th>Password</th>
			<th>Gender</th>
		</tr>
	<%
		dalUser daluser = new dalUser();
		Vector<Vector<String>> list = daluser.ViewList();
		for(int i=0;  i<list.size(); i++ )
		{
	%>
	<tr>
		<td><% out.println(list.elementAt(i).get(0)); %></td>
		<td><% out.println(list.elementAt(i).get(1)); %></td>
		<td><% out.println(list.elementAt(i).get(2)); %></td>
		<td><% out.println(list.elementAt(i).get(3)); %></td>
		<td><% out.println(list.elementAt(i).get(4)); %></td>
		<td><% out.println(list.elementAt(i).get(5)); %></td>
		<td><a href="EditUser.jsp?id=<% out.println(list.elementAt(i).get(0)); %>">Update</a></td>
        <td><a href="User?id=<% out.println(list.elementAt(i).get(0)); %>">Delete</a></td>
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