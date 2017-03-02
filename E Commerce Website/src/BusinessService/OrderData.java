package BusinessService;

public class OrderData {
	
	private int OrderID;
	private int Quantity;
	private int ProductId;
	private int PurchaseId;
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int orderID) {
		OrderID = orderID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getPurchaseId() {
		return PurchaseId;
	}
	public void setPurchaseId(int purchaseId) {
		PurchaseId = purchaseId;
	}

	
}
