<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form action="Category"  method="post" >
    	<table align="center" border="2" width="500">
        	<%
				dalCategory dalcategory = new dalCategory();
				String id = request.getParameter("id");
				String arr[] = dalcategory.SelectById(Integer.parseInt(id ));
			%>
        	<tr>
            	<td>
                	<b>Category Name</b>
                </td>
                <td>
                	<input type="text" size="30" name="category" value="<% out.println(arr[1]);%>">
                </td>
            </tr>
           
            <tr>
            	<td align="center" colspan="2">
                	<button>Reset</button>
                    <input type="submit" name="UpdateCategory" value="Update" />
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