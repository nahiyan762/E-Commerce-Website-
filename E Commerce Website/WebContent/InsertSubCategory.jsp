<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalCategory" %>
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
<form action="SubCategory" method="post">
<table align="center">
   	<tr>
       	<td>
       		Sub-Category Name:
       	</td>
       	<td>
       		<input type="text" size="30" name="subcategory">
       	</td>
	</tr>
        
	<tr>
	 	<td>Category:</td>
	        <td>
	        	<select name="categoryid">
<%
  	dalCategory dalcategory = new dalCategory();
  	Vector<Vector<String>> list = dalcategory.ViewList();
  	for(int i=0;  i<list.size(); i++ )
    {
 %>
		<option value="<%= list.elementAt(i).get(0)%>"><%= list.elementAt(i).get(1)%></option>
<%	
	}
%>
	        </select>
	    </td>
	</tr>
       <tr>
        	<td></td>
            <td colspan="2">
            	<input type="submit" name="SaveSubCategory" value="Save" />
                <input type="submit" value="Reset">
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