package Model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import BusinessService.DelivaryData;
import BusinessService.OrderData;

public class dalDelivary {
private Statement statement;
	
	public dalDelivary() {
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(DelivaryData data)
	{	
		String sql = "INSERT INTO `project`.`delivery` (`service_id`, `address`, `amount`, `date`, `check`)"
				+ "VALUES ('"+data.getAreaId()+"',"
						+ " '"+data.getAddress()+"',"
						+ " '"+data.getTotalAmount()+"',"
						+ " '"+data.getDate()+"',"
								+ " ' ');";
		try
		{
			System.out.println(sql);
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
		String sql = "SELECT * FROM delivery";
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
	
	public boolean CheckList(String arr[])
	{
		for(int i=0; i<arr.length; i++)
		{
			String sql = "UPDATE `project`.`delivery` SET `check` = 'clear' WHERE `delivery`.`delivery_id` = '"+arr[i]+"';";
			try
			{
				this.statement.execute(sql);	
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
