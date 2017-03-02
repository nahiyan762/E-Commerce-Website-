package Model;

import java.io.PrintWriter;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.Statement;

import BusinessService.ServiceData;
import BusinessService.SizeData;


public class dalService {
	
	private Statement statement;

	public dalService(){
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(ServiceData data)
	{	
		String sql = "INSERT INTO service (area,s_price) "
				+ "VALUES ( '"+data.getServiceArea()+"',"
						+ "'"+data.getServicePrice()+"');";
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
		String sql = "SELECT * FROM service";
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
		String sql = "SELECT * FROM service WHERE service_id='"+id+"' ";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			String[] list = new String[3];
			while(rs.next())
			{
				list[0] = rs.getString(1);
				list[1] = rs.getString(2);
				list[2] = rs.getString(3);
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
		String sql="DELETE FROM service WHERE service_id = '"+id+"'";
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

	public boolean Update(ServiceData data, String id)
	{
		String sql= "UPDATE service SET "
				+ "area = '"+data.getServiceArea()+"', "
						+ "s_price = '"+data.getServicePrice()+"' "
								+ "WHERE service_id = '"+Integer.parseInt(id)+"'";
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
