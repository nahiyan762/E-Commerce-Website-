<!DOCTYPE html>
<html>

<head>

<script type="text/javascript">
</script>

<title>E-Commerce</title>
<style type="text/css">
<%@ include file="CSS/menu.css" %>
</style>
</head>



<body>
<% 
if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("admin"))
{
%>
<table align="center" border="1" height="20" width="1000" cellpadding="5" cellspacing="0">
<td align="right"> <input type="text" name="search" placeholder="Search..">
<a href="InsertUser.jsp">Register</a>
<a href="Login">Logout</a> </td>
</table>

<table align="center" border="1" height="40" width="1000" cellpadding="5" cellspacing="0">
<td align="left">
<div class="menu">

<ul>

<li><a href="ViewCategory.jsp">Category</a></li>

<li><a href="ViewSubCategory.jsp">Sub-Category</a></li>

<li><a href="ViewProduct.jsp">Product</a></li>

<li><a href="ViewService.jsp">Service</a></li>

<li><a href="ViewSize.jsp">Size</a></li> 

<li><a href="DelivaryView.jsp">DelivaryList</a></li>
</ul>

</div>
</td>
</table>

<table align="center" border="1" height="450" width="1000" cellpadding="5" cellspacing="0">

	
</table>
<table align="center" border="1" height="50" width="1000" cellpadding="5" cellspacing="0">
<td align="center"><h4>Copyright</h4></td>
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