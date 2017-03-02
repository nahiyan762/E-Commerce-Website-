package Model;

import java.io.PrintWriter;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.Statement;

import BusinessService.CategoryData;
import BusinessService.SizeData;

public class dalCategory {
	
	private Statement statement;
	
	public dalCategory() {
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(CategoryData data)
	{	
		String sql = "INSERT INTO category (category_name) "
				+ "VALUES ( '"+data.getCategoryName()+"');";
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
		String sql = "SELECT * FROM category";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<Vector<String>> list = new Vector<Vector<String>> ();
			while(rs.next())
			{
				Vector<String> row = new Vector<String>();
				
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				
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
		String sql = "SELECT * FROM category WHERE category_id='"+id+"' ";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			String[] list = new String[2];
			while(rs.next())
			{
				list[0] = rs.getString(1);
				list[1] = rs.getString(2);
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
		String sql="DELETE FROM category WHERE category_id = '"+id+"'";
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

	public boolean Update(CategoryData data, String id)
	{
		String sql="UPDATE category SET "
							+ "category_name = '"+data.getCategoryName()+"'"
							+ "WHERE category_id ='"+Integer.parseInt(id)+"'";
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
