<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalSubCategory" %>
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

		<form action="SubCategory"  method="post" >
    	<table align="center" border="2" width="500">
<%
	dalSubCategory dalsubCategory = new dalSubCategory();
	String id = request.getParameter("id");
	String arr[] = dalsubCategory.SelectById(Integer.parseInt(id ));
%>        	
        	
        	<tr>
            	<td>
                	<b>Sub-Category Name:</b>
                </td>
                <td>
                	<input type="text" size="30" name="subcategory" value="<% out.println(arr[1]);%>">
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
  		if(list.elementAt(i).get(0).equals(arr[2]))
  		{
%>
		<option value="<%= list.elementAt(i).get(0)%>" selected><%= list.elementAt(i).get(1)%></option>
<%	  	
		}
  		else
  		{
 %>
 		<option value="<%= list.elementAt(i).get(0)%>"><%= list.elementAt(i).get(1)%></option>
 <% 			
  		}
	}
%>
	        </select>
	    </td>
	</tr>
           
            <tr>
            	<td align="center" colspan="2">
                	<button>Reset</button>
                    <input type="submit" name="UpdateSubCategory" value="Update" />
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