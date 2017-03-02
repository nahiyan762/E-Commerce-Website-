package Model;

import java.io.PrintWriter;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.Statement;

import BusinessService.ServiceData;
import BusinessService.UserData;

public class dalUser {
	
	private Statement statement;
	
	public dalUser() {
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(UserData data)
	{	
		String sql = "INSERT INTO login (user_name, user_email, user_contact, user_pass,user_gender, user_type) "
				+ "VALUES ('"+data.getUsername()+"',"
						+ "'"+data.getEmail()+"',"
								+ "'"+data.getContact()+"',"
										+ "'"+data.getPassword()+"',"
												+ "'"+data.getGender()+"',"
														+ "'"+data.getType()+"');";
		try
		{
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
	
	public Vector<Vector<String>> ViewList()
	{
		String sql = "SELECT * FROM login";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<Vector<String>> list = new Vector<Vector<String>> ();
			while(rs.next())
			{
				Vector<String> row = new Vector<String>();
				
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				
				list.add(row);
				
			}
			return list;
		  }
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	  }
	public  String[] SelectById(int id)
	{
		String sql = "SELECT * FROM login WHERE user_id='"+id+"' ";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			String[] list = new String[6];
			while(rs.next())
			{
				list[0] = rs.getString(1);
				list[1] = rs.getString(2);
				list[2] = rs.getString(3);
				list[3] = rs.getString(4);
				list[4] = rs.getString(5);
				list[5] = rs.getString(6);
			}
			return list;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
		}
	public boolean DELETE(int id)
	{
		String sql="DELETE FROM login WHERE user_id = '"+id+"'";
		try
		{
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	public boolean Update(UserData data, String id)
	{

		String sql= "UPDATE login SET "
				+ "user_name = '"+data.getUsername()+"', "
				+ "user_email = '"+data.getEmail()+"', "
				+ "user_contact = '"+data.getContact()+"', "
				+ "user_pass = '"+data.getPassword()+"', "
						+ "user_gender = '"+data.getGender()+"' "
								+ "WHERE user_id = '"+Integer.parseInt(id)+"'";
		
		try
		{
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
}
