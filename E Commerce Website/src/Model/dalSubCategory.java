package Model;

import java.io.PrintWriter;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSet;

import BusinessService.CategoryData;
import BusinessService.ServiceData;
import BusinessService.SubCategoryData;

public class dalSubCategory {

	private Statement statement;
	
	public dalSubCategory() 
	{
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(SubCategoryData data)
	{	
		String sql = "INSERT INTO subcategory (name,category_id) "
				+ "VALUES ( '"+data.getSubCategoryName()+"',"
						+ "'"+data.getCategoryId()+"');";
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
		String sql = "SELECT subcategory.subcategory_id, subcategory.name, category.category_name "
				+ "FROM subcategory,category "
				+ "WHERE subcategory.category_id = category.category_id ";
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
		String sql = "SELECT * FROM subcategory WHERE subcategory_id='"+id+"' ";
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
	
	public boolean Update(SubCategoryData data, String id)
	{
		String sql= "UPDATE subcategory SET "
				+ "name = '"+data.getSubCategoryName()+"', "
						+ "category_id = '"+data.getCategoryId()+"' "
								+ "WHERE subcategory_id = '"+Integer.parseInt(id)+"'";
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
	
	public boolean DELETE(int id)
	{
		String sql="DELETE FROM subcategory WHERE subcategory_id = '"+id+"'";
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
