
public class Order {
	private int orderID;
	private int customerID;
	private float paymentAmount;
	private boolean orderStatus;
	
	Order(int orderID, int customerID,float paymentAmount, boolean orderStatus){
		this.orderID = orderID;
		this.paymentAmount = paymentAmount;
		this.customerID = customerID;
		this.orderStatus = orderStatus;
	}

	public int getOrderID() {
		return orderID;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}

	public int getCustomerID() {
		return customerID;
	}

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
