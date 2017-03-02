<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<form action="User" method="post">
    <table align="center">
      
<%
	dalUser daluser = new dalUser();
	String id = request.getParameter("id");
	String arr[] = daluser.SelectById(Integer.parseInt(id ));
%>      
      <tr>
	      <td><h3>Username</h3></td>
	      <td><input type="text" name="username" value="<% out.println(arr[1]);%>" /></td>
	  </tr>
	  <tr>
	      <td><h3>E-mail</h3></td>
	      <td><input type="email" name="email" value="<% out.println(arr[2]);%>" /></td>
	  </tr>
	  <tr>
	      <td><h3>Contact</h3></td>
	      <td><input type="text" name="contact" value="<% out.println(arr[3]);%>" /></td>
	  </tr>   
	  <tr>   
	      <td><h3>Password</h3></td>
	      <td><input type="password" name="password" value="<% out.println(arr[4]);%>" /></td>
	  </tr>
	  <tr>
	      <td><h3>Gender</h3></td>
	      <td>
	      	<select name="gender">
	      	<%
	      		if(arr[5].equals("male"))
	      		{
	      			out.println("<option value=\"male\" >Male</option>");
	      			out.println("<option value=\"female\" >Female</option>");
	      		}
	      		else if(arr[5].equals("female"))
	      		{
	      			out.println("<option value=\"female\" >Female</option>");
	      			out.println("<option value=\"male\" >Male</option>");
	      		}
	      		else
	      		{
	      			out.println("<option value=\"female\" >Female</option>");
	      			out.println("<option value=\"male\" >Male</option>");
	      		}
	      	%>
	      	</select>
	      </td>
	  </tr>
		<tr>
			<td align="center" colspan="2">
		    	<button>Reset</button>
		        <input type="submit" name="UpdateUser" value="Update" />
		        <input type="hidden" name="id" value="<% out.print(id); %>">
		    </td>
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