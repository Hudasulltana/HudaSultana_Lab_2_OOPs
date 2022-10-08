
public class Customer {
	//use a orerid, payment amount
	private int CustomerID;
	private String Name;
	private String PhoneNumber;

	public Customer(int customerID, String name, String phoneNumber) {
		CustomerID = customerID;
		Name = name;
		PhoneNumber = phoneNumber;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public String getName() {
		return Name;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}
	
		
	
}
