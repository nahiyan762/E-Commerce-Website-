package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import BusinessService.LoginData;
import BusinessService.ProductData;

public class dalLogin {

	private Statement statement;
	
	public dalLogin() {
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}

	public Vector<LoginData> SelectBy(LoginData data)
	{
		String sql = "SELECT * FROM login WHERE user_email ='"+data.getUserEmail()+"' "
				+ "AND user_pass = '"+data.getUserPassword()+"' ";
		
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<LoginData> list = new Vector<LoginData> ();
	
			while(rs.next())
			{
				LoginData row = new LoginData();
				
				row.setUserID(rs.getString(1));
				row.setUserName(rs.getString(2));
				row.setUserEmail(rs.getString(3));
				row.setUserContact(rs.getString(4));
				row.setUserPassword(rs.getString(5));
				row.setUserGender(rs.getString(6));
				row.setUserType(rs.getString(7));
				
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
	
	public Vector<LoginData> SelectByID(String id)
	{
		String sql = "SELECT * FROM login WHERE user_id ='"+Integer.parseInt(id)+"' ";
		//System.out.println(sql);
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<LoginData> list = new Vector<LoginData> ();
	
			while(rs.next())
			{
				LoginData row = new LoginData();
				
				row.setUserID(rs.getString(1));
				row.setUserName(rs.getString(2));
				row.setUserEmail(rs.getString(3));
				row.setUserContact(rs.getString(4));
				row.setUserPassword(rs.getString(5));
				row.setUserGender(rs.getString(6));
				row.setUserType(rs.getString(7));
				
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
}
