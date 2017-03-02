<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Model.dalLogin" %>
<%@ page import="BusinessService.LoginData" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("member"))
{
%>
<form action="Delivary"  method="post" >
<table align="center">
	<%
	dalLogin dallogin = new dalLogin();
	Vector<LoginData> list = dallogin.SelectByID((String)session.getAttribute("userID"));
	%>
	    <tr>
	    	<td>Name: </td>
	    	<td><input type="text" name="name" value="<%out.print(list.elementAt(0).getUserName()); %>" /></td>
	    </tr>
	  
	    <tr>
	    	<td>Area:</td>
	        <td>
	        	<select name="areaid">
<%
dalService dalservice = new dalService();
  	Vector<Vector<String>> servicelist = dalservice.ViewList();
  	for(int i=0;  i<servicelist.size(); i++ )
    {
 %>
		<option value="<%= servicelist.elementAt(i).get(0)%>"><%= servicelist.elementAt(i).get(1)%></option>
<%	
	}
%>
	        </select>
	    </td>
	    </tr>
	    <tr>
	    	<td>Address:</td>
	    	<td><textarea name="addr"></textarea></td>
	    </tr>
	    <tr>
	    	<td>Mobile Number:</td>
	    	<td><input type="text" name="number" value="<%out.print(list.elementAt(0).getUserContact()); %>" /></td>
	    </tr>
	    <tr>
	    	<td></td>
	    	<td><input type="submit" name="submit" value="Save" /></td>
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