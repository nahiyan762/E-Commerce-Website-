package Model;

import java.sql.ResultSet;
import java.sql.Statement;

import BusinessService.CategoryData;
import BusinessService.PurchaseData;

public class dalPurchase {

private Statement statement;
	
	public dalPurchase() {
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(PurchaseData pData)
	{	
		String sql = "INSERT INTO purchase(date, total, user_id)"
				+ "VALUES ('"+pData.getDate()+"',"
						+ "'"+pData.getTotal()+"',"
						+ "'"+pData.getUserID()+"');";
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
	
	public int GetLastID()
	{
		String sql = "SELECT MAX(purchase_id) purchase_id FROM purchase";
		try
		{
			ResultSet rs = this.statement.executeQuery(sql);
			int lastid=0;
			while(rs.next())
			{
				lastid = rs.getInt("purchase_id");
			}
			return lastid;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	
}
