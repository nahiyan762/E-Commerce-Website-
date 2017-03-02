<%@ page import="java.util.*" %>
<%@ page import="Model.dalProduct" %>
<%@ page import="Model.dalSize" %>

<!DOCTYPE html>
<html>

<head>

<style type="text/css">
<%@ include file="CSS/menu.css" %>
</style>

<title>E-Commerce</title>
<style type="text/css">
<%@ include file="CSS/menu.css" %>
</style>
</head>



<body>
<table align="center" border="1" height="20" width="1000" cellpadding="5" cellspacing="0">
<td align="right"> <input type="text" name="search" placeholder="Search..">
<a href="Login.jsp">Login/Register</a> 
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

<li><a href="Checkout.jsp">Your Bag</a></li>

</ul>

</div>
</td>
</table>
<%
	dalProduct dalproduct = new dalProduct();
	String id = request.getParameter("id");
	String arr[] = dalproduct.SelectById(Integer.parseInt(id));
%>
<table align="center" border="1" height="450" width="1000" cellpadding="5" cellspacing="0">
  <tr>
    <td width="150" valign="top"><b>Advertise</b><br>
	
	</td>
	
	
	<td>
	<article id="mainview">
	
	<div id="images">
    	<img src="image/<% out.println(arr[5]); %>" height="400" width="400">
        <span class="sale"> </span>
        
    </div>
    
    <div id="description">
        <h1><% out.println(arr[1]); %></h1>
        <strong id="price">$ <% out.println(arr[2]); %></strong>
        <p><% out.println(arr[6]); %></p>
    </div>

<div id="tab1" class="w3-container city">
  <h2>Vat</h2>
  <p><% out.println(arr[3]); %></p>
</div>

<div id="tab2" class="w3-container city">
  <h2>Discount</h2>
  <p><% out.println(arr[4]); %></p>
</div>

<div id="tab3" class="w3-container city">
  <h2>Size</h2>
<p>	<%
		dalSize dalsize = new dalSize();
		Vector<Vector<String>> sizelist = dalsize.ViewList();
		for(int i=0;  i<sizelist.size(); i++ )
		{
			if(sizelist.elementAt(i).get(0).equals(arr[9]))
			{
				out.println(sizelist.elementAt(i).get(1));
			}
		}
	%>
</p>
</div>

<a href="AddtoCART?id=<%out.println(arr[0]);%>">Add to cart</a>
	
	
</article>

	</td>
	
	
	
	<td width="150" valign="top"><b>Advertise</b><br>
	
	</td>
	</tr>
	
</table>
<table align="center" border="1" height="50" width="1000" cellpadding="5" cellspacing="0">
<td align="center"><h4>Copyright</h4>

</td>
</table>
</body>
</html>