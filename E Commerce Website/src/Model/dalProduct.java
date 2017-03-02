package Model;

import java.io.PrintWriter;
import java.sql.Statement;
import java.util.Vector;
import java.sql.ResultSet;

import BusinessService.ProductData;
import BusinessService.SubCategoryData;

public class dalProduct {

	private Statement statement;
	
	public dalProduct() 
	{
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(ProductData data)
	{		
		String sql = "INSERT INTO product (p_name,price,vat,discount,picture,details,quantity,subcategory_id,size_id) "
				+ "VALUES ( '"+data.getName()+"',"
					+ "'"+data.getPrice()+"',"
					+ "'"+data.getVat()+"',"
					+ "'"+data.getDiscount()+"',"
					+ "'"+data.getPicName()+"',"
					+ "'"+data.getDetails()+"',"
					+ "'"+data.getQuantity()+"',"
					+ "'"+data.getSubcatagoryId()+"',"
					+ "'"+data.getSizeId()+"');";

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
		String sql = "SELECT product.product_id, product.p_name, product.price, product.vat, product.discount, product.picture, product.details, product.quantity, subcategory.name, size.size_name FROM product,subcategory,size WHERE product.subcategory_id = subcategory.subcategory_id AND product.size_id = size.size_id ";
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
				row.add(rs.getString(7));
				row.add(rs.getString(8));
				row.add(rs.getString(9));
				row.add(rs.getString(10));
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
		String sql = "SELECT * FROM product WHERE product_id='"+id+"' ";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			String[] list = new String[10];
			while(rs.next())
			{
				list[0] = rs.getString(1);
				list[1] = rs.getString(2);
				list[2] = rs.getString(3);
				list[3] = rs.getString(4);
				list[4] = rs.getString(5);
				list[5] = rs.getString(6);
				list[6] = rs.getString(7);
				list[7] = rs.getString(8);
				list[8] = rs.getString(9);
				list[9] = rs.getString(10);
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
		String sql="DELETE FROM product WHERE product_id = '"+id+"'";
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
	
	public boolean Update(ProductData data, String id) 
	{
		String sql= "UPDATE product SET "
				+ "p_name = '"+data.getName()+"', "
				+ "price = '"+data.getPrice()+"', "
				+ "vat = '"+data.getVat()+"', "
				+ "discount = '"+data.getDiscount()+"', "
				+ "picture = '"+data.getPicName()+"', "
				+ "details = '"+data.getDetails()+"', "
				+ "quantity = '"+data.getQuantity()+"', "
				+ "subcategory_id = '"+data.getSubcatagoryId()+"', "
				+ "size_id = '"+data.getSizeId()+"' "
				+ "WHERE product_id = '"+Integer.parseInt(id)+"'";
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
