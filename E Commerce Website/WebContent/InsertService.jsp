<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2 align="center">Insert Service</h2>
    <form action="Service"  method="post" >
    	<table align="center" border="2" width="500">
        	
            <tr>
            	<td>
                	<b>Area</b>
                </td>
                <td>
                	<input type="text" size="30" name="area">
                </td>
            </tr>
            
            <tr>
            	<td>
                	<b>Service Price</b>
                </td>
                <td>
                	<input type="text" size="30" name="price">
                </td>
            </tr>
           
            <tr>
            	<td align="center" colspan="2">
                	<button>Reset</button>
                    <input type="submit" name="InsertService" value="Save" />
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