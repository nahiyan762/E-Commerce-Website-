<%@ page import="java.util.*" %>
<%@ page import="Model.dalProduct" %>

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
<table align="center" border="1" height="20" width="1000" cellpadding="5" cellspacing="0">
<td align="right"> <input type="text" name="search" placeholder="Search..">
<%
if(session.getAttribute("userType") != null && session.getAttribute("userType").equals("member"))
{
%>
	<a href="Login">Logout</a>
<%	
}
else
{
%>
	<a href="Login.jsp">Login</a>
<%	
}
%>
	 
	<a href="Checkout.jsp">Product:
		<%
		
			if((Vector<String>)session.getAttribute("cart") != null)
			{
				Vector<String> pid = (Vector<String>)session.getAttribute("cart");
				out.println(pid.size());
			}
			else
			{
				out.println(0);
			}
		%>
	</a>
	
	<a href="Checkout.jsp">Cost:
		<%
		
			if((Vector<String>)session.getAttribute("cart") != null)
			{
				int total=0;
				Vector<String> pid = (Vector<String>)session.getAttribute("cart");
				Vector<Integer> pqty = (Vector<Integer>)session.getAttribute("qty");
				for(int i=0; i<pid.size(); i++)
				{
					
					dalProduct dalproduct = new dalProduct();
					String arr[] = dalproduct.SelectById(Integer.parseInt(pid.elementAt(i)));
					int price = Integer.parseInt(arr[2]) * pqty.elementAt(i);
					total += price + (price * Integer.parseInt(arr[3]))/100 - (price * Integer.parseInt(arr[4]))/100;
				}
				out.println(total);
			}
			else
			{
				out.println(0);
			}
		%>
	</a>
	
</td>
</table>

<table align="center" border="1" height="40" width="1000" cellpadding="5" cellspacing="0">
<td align="left">
<div class="menu">

<ul>

<li><a href="Index.jsp">Home</a></li>

<li><a href="#">About Us</a></li>

</ul>

</div>
</td>
</table>
<table align="center" border="1" height="450" width="1000" cellpadding="5" cellspacing="0">
  <tr>
	<td>

<%
dalProduct dalproduct = new dalProduct();
Vector<Vector<String>> list = dalproduct.ViewList();

int start = 0;
int end =0;
int per_page = 8;
String pg = request.getParameter("pg");

if(pg == null)
{
	end = 8;
}
else
{
	start = (Integer.parseInt(pg) - 1) * per_page;
	end = Integer.parseInt(pg) * per_page;
}

for(int i=start;  i<end; i++ )
{
%>	
	<ul id="products">
        <li>
            <a href="Details.jsp?id=<% out.println(list.elementAt(i).get(0)); %>"><img src="image/<% out.println(list.elementAt(i).get(5)); %>"/></a>
            <a href="Details.jsp?id=<% out.println(list.elementAt(i).get(0)); %>" class="tistle"><% out.println(list.elementAt(i).get(1)); %></a>
            <strong>$ <% out.println(list.elementAt(i).get(2)); %></strong>
      </li>
    </ul>
<% 
}
%>   

		
	  <table align="center" border="1" height="30" width="700" cellpadding="5" cellspacing="0">
       <tr>
       	<td>
		       <% 
		       		int pages = 1;
		       		
		       		for(int i=0; i<list.size(); i = i+per_page)
					{
				%>
						<a href="Index.jsp?pg=<%out.println(pages);%>"><%out.println(pages);%>|</a>		
				<%
				pages++;
					}
		       %>
	   	</td>
	   </tr>
	  </table>
	
	</tr>
	
</table>
</body>
</html>