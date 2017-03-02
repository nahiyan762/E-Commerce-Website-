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
	<h2 align="center">Insert Size</h2>
    <form action="Size"  method="post" >
    	<table align="center" border="2" width="500">
        	
            <tr>
            	<td>
                	<b>Size</b>
                </td>
                <td>
                	<input type="text" size="30" name="size">
                </td>
            </tr>
           
            <tr>
            	<td align="center" colspan="2">
                	<button>Reset</button>
                    <input type="submit" name="InsertSize" value="Save" />
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