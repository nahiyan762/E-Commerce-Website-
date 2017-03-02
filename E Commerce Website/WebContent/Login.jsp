<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Login" method="post">
    <table align="center">
      <tr>
	      <td><h3>E-mail</h3></td>
	      <td><input type="email" name="email" placeholder="email" /></td>
	  </tr> 
	  <tr>   
	      <td><h3>Password</h3></td>
	      <td><input type="password" name="password" placeholder="password" /></td>
	  </tr> 
	  <tr>   
	      <td></td>
	      <td><input type="submit" value="Login" name="Login" /><br/><br/></td>
	  </tr> 

    </table>
</form>
</body>
</html>