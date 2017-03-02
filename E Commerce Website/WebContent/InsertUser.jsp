<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="User" method="post">
    <table align="center">
      <tr>
	      <td><h3>Username</h3></td>
	      <td><input type="text" name="username" placeholder="username" /></td>
	  </tr>
	  <tr>
	      <td><h3>E-mail</h3></td>
	      <td><input type="email" name="email" placeholder="e-mail" /></td>
	  </tr>
	  <tr>
	      <td><h3>Contact</h3></td>
	      <td><input type="text" name="contact" placeholder="contact number" /></td>
	  </tr>   
	  <tr>   
	      <td><h3>Password</h3></td>
	      <td><input type="password" name="password" placeholder="password" /></td>
	  </tr>
	  <tr>
	      <td><h3>Gender</h3></td>
	      <td>
	      	<select name="gender">
	      		<option value="male" >Male</option>
                <option value="female">Female</option>
	      	</select>
	      </td>
	  </tr>
		<tr>
			<td align="center" colspan="2">
		    	<button>Reset</button>
		        <input type="submit" name="InsertUser" value="Save" />
		    </td>
		</tr> 
	   
    </table>
</form>

</body>
</html>