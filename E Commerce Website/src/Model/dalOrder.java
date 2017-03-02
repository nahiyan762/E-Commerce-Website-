package Model;

import java.sql.Statement;

import BusinessService.OrderData;
import BusinessService.PurchaseData;

public class dalOrder {

private Statement statement;
	
	public dalOrder() {
		DataAccessLayer access = new DataAccessLayer();
		statement = access.getStatement();
	}
	
	public boolean Insert(OrderData oData)
	{	
		String sql = "INSERT INTO project.order (quantity, product_id, purchase_id) "
				+ "VALUES ('"+oData.getQuantity()+"',"
						+ " '"+oData.getProductId()+"',"
								+ " '"+oData.getPurchaseId()+"');";
		try
		{
			//System.out.println(sql);
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
