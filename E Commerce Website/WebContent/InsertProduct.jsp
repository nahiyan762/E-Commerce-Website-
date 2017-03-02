<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
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
	<h1 align="center">Insert Product</h1>
<form action="Product" method="post" enctype="multipart/form-data">
	<table align="center">
	    <tr>
	    	<td>Name: </td>
	    	<td><input type="text" name="name" /></td>
	    </tr>
	    <tr>
	    	<td>Price:</td>
	    	<td><input type="text" name="price" /></td>
	    </tr>
	    <tr>
	    	<td>Vat:</td>
	    	<td><input type="text" name="vat" /></td>
	    </tr>
	    <tr>
	    	<td>Discount:</td>
	    	<td><input type="text" name="discount" /></td>
	    </tr>
	    <tr>
	    	<td>Picture:</td>
	    	<td><input type="file" name="file" value="select images..."/></td>
	    </tr>
	    <tr>
	    	<td>Details:</td>
	    	<td><input type="text" name="details" /></td>
	    </tr>
	    <tr>
	    	<td>Quantity:</td>
	    	<td><input type="text" name="quantity" /></td>
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
	%>
		<option value="<%= list.elementAt(i).get(0)%>"><%= list.elementAt(i).get(1)%></option>
	<%	
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
	%>
		<option value="<%= sizelist.elementAt(i).get(0)%>"><%= sizelist.elementAt(i).get(1)%></option>
	<%	
		}
	%>
	    		</select>
	    	</td>
	    </tr>
	    
            <tr>
            	<td align="center" colspan="2">
                	<button>Reset</button>
                    <input type="submit" name="InsertProduct" value="Save" />
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