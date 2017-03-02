package Model;
import BusinessService.SizeData;

import java.io.PrintWriter;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSet;

public class dalSize
{
	private Statement statement;

	public dalSize()
	{
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(SizeData sizedata)
	{	
		String sql = "INSERT INTO size (size_name) "
				+ "VALUES ( '"+sizedata.getSize()+"');";
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
		String sql = "SELECT * FROM size";
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
		String sql = "SELECT * FROM size WHERE size_id='"+id+"' ";
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
		String sql="DELETE FROM size WHERE size_id = '"+id+"'";
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

	public boolean Update(SizeData data, String id)
	{
		String sql="UPDATE size SET "
							+ "size_name = '"+data.getSize()+"'"
							+ "WHERE size_id ='"+Integer.parseInt(id)+"'";
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


//public Vector<InsertData> View()
//{
//	String sql = "SELECT * FROM info";
//	try
//	{
//		ResultSet rs = this.statement.executeQuery(sql);
//		Vector<InsertData> list = new Vector<InsertData> ();
//		while(rs.next())
//		{
//			InsertData row = new InsertData();
//			
//			row.setUserName(rs.getString(0));
//			row.setUserName(rs.getString(1));
//			row.setUserName(rs.getString(2));
//			row.setUserName(rs.getString(3));
//			row.setUserName(rs.getString(4));
//			row.setUserName(rs.getString(5));
//			row.setUserName(rs.getString(6));
//			row.setUserName(rs.getString(7));
//			row.setUserName(rs.getString(8));
//			
//			list.add(row);
//			
//		}
//		return list;
//	  }
//	catch(Exception ex)
//	{
//		ex.printStackTrace();
//	}
//	return null;
//  }
