<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="Model.dalProduct" %>
<%@ page import="Model.dalSubCategory" %>
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

<form action="Product" method="post" enctype="multipart/form-data">
	<table align="center">
<%
	dalProduct dalproduct = new dalProduct();
	String id = request.getParameter("id");
	String arr[] = dalproduct.SelectById(Integer.parseInt(id));
%>

	 <input type="hidden" name="id" value="<% out.print(id); %>">
	    <tr>
	    	<td>Name: </td>
	    	<td><input type="text" name="name" value="<% out.println(arr[1]);%>"></td>
	    </tr>
	    <tr>
	    	<td>Price:</td>
	    	<td><input type="text" name="price" value="<% out.println(arr[2]);%>"></td>
	    </tr>
	    <tr>
	    	<td>Vat:</td>
	    	<td><input type="text" name="vat" value="<% out.println(arr[3]);%>"></td>
	    </tr>
	    <tr>
	    	<td>Discount:</td>
	    	<td><input type="text" name="discount" value="<% out.println(arr[4]);%>"></td>
	    </tr>
	    <input type="hidden" name="picName" value="<% out.print(arr[5]); %>">
	    <tr>
	    	<td>Picture:</td>
	    	<td><input type="file" name="file" value="select images..."/></td>
	    	<td><img style="width: 150px;height: 150px;" src="image/<% out.println(arr[5]); %>"></td>
	    </tr>
	    <tr>
	    	<td>Details:</td>
	    	<td><input type="text" name="details" value="<% out.println(arr[6]);%>"></td>
	    </tr>
	    <tr>
	    	<td>Quantity:</td>
	    	<td><input type="text" name="quantity" value="<% out.println(arr[7]);%>"></td>
	    </tr>
	    <tr>
	    	<td>Subcatagory:</td>
	    	<td>
	    		<select name="subcatagory">
	<%
		dalSubCategory dalsubCategory = new dalSubCategory();
		Vector<Vector<String>> list = dalsubCategory.ViewList();
		for(int i=0;  i<list.size(); i++ )
		{
			if(list.elementAt(i).get(0).equals(arr[8]))
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
	    	<td>Size:</td>
	    	<td>
	    		<select name="size">
	<%
		dalSize dalsize = new dalSize();
		Vector<Vector<String>> sizelist = dalsize.ViewList();
		for(int i=0;  i<sizelist.size(); i++ )
		{
			if(sizelist.elementAt(i).get(0).equals(arr[9]))
			{
	%>
		<option value="<%= sizelist.elementAt(i).get(0)%>" selected><%= sizelist.elementAt(i).get(1)%></option>
	<%					
			}
			else
			{
	%>
		<option value="<%= sizelist.elementAt(i).get(0)%>"><%= sizelist.elementAt(i).get(1)%></option>
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
                    <input type="submit" name="UpdateProduct" value="Update" />
                   
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