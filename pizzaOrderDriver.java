import java.util.*;

public class pizzaOrderDriver {
	static int globalCustomerID = 1;
	static int globalOrderID = 1;
	static List<Customer> customerList = new ArrayList<>();
	static List<Order> orderList = new ArrayList<>();
	
	static float takePizzaInputs() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice of Crust: ");
		System.out.println("1. Thin\t2. Thick");
		int choiceOfCrust = sc.nextInt();
		
		System.out.println("Enter your choice of Flavour: ");
		System.out.println("1. Vegetarian\t2. Non-Vegetarian\t3. Vegan");
		int choiceOfFlavour = sc.nextInt();
		
		System.out.println("Enter your choice of Toppings: ");
		System.out.println("1. Cheese   2. Mushroom    3. Tomato   4. Jalapeno   5.Spinach");
		int choiceOfToppings = sc.nextInt();
		
		System.out.println("Enter your choice of Pizza Size: ");
		System.out.println("1. Large\t2. Medium\t3. Small");
		int choiceOfSize = sc.nextInt();

		Pizza p = new Pizza(choiceOfCrust, choiceOfFlavour, choiceOfToppings, choiceOfSize);
		return p.Pricing();
	}
	
	static float takePastaInputs() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice of Pasta: ");
		System.out.println("1. Penne\t2. Ditalini");
		int choiceOfPasta = sc.nextInt();
		
		System.out.println("Enter your choice of Flavour: ");
		System.out.println("1. White Sauce\t2. Red Sauce\n");
		int choiceOfFlavour = sc.nextInt();
		
		//in the end add all these into the pizza list
		Pasta p = new Pasta(choiceOfPasta, choiceOfFlavour, choiceOfFlavour);
		return p.Pricing();
	}
	
//write one to create/check customer availability in DB
	static int getcustomerDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Customer Details as follows:");
		System.out.println("Enter the Phone Number");
		String choicePhoneNumber = sc.next();
		//we need static customer list 
//		if(!customerList.isEmpty()) {
			for(Customer c: customerList) {
				if(c.getPhoneNumber().equals(choicePhoneNumber)) {
					return c.getCustomerID();
				}
			}
//		}
			
		System.out.println("Enter the name of the customer.");
		String choiceName = sc.next();
		Customer c = new Customer(globalCustomerID++, choiceName, choicePhoneNumber);
		customerList.add(c);
		return globalCustomerID-1;
	}
	
//write one for checking order; traverse through orderid
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(;;) { // we can actually loop over a while loop to have a customer take more than one order
			//menu display using class MENU
			
			//-------- this can be in while loop-----------------
			boolean flag = true;
			float totalAmount = 0.0f;
			int timeInMinutes = 0; // 20mins = 20milli seconds -> for pizza
			//15mins = 15 milli seconds => pasta
			while(flag) {
				
				Menu.displayList();
				System.out.println("Would you like to order?\nType y/n as per your choice.");
				char ordering = sc.next().charAt(0);
				if(ordering == 'y' || ordering == 'Y') {
					System.out.println("Would you like to order a Pizza or Pasta?");
					System.out.println("Choose '1' for Pizza and '2' for Pasta\n");
					int temp = sc.nextInt();
					if(temp == 1) {
						totalAmount = totalAmount + takePizzaInputs();
						timeInMinutes = timeInMinutes + 20;
					}
					else {
						totalAmount = totalAmount + takePastaInputs();
						timeInMinutes = timeInMinutes + 15;
					}
				}				
				
				System.out.println("Do you want to order another item?\nType y/n as per your choice.");
				char anotherOrder = sc.next().charAt(0);
				if(anotherOrder == 'n' || anotherOrder == 'N') {
					int customerID = getcustomerDetails();
					orderList.add(
							new Order(globalOrderID++, customerID, totalAmount, false)
							); 
					Kitchen pre = new Kitchen(globalOrderID - 1, timeInMinutes);
					if(pre.notification()) {
						int cust = 0;
						System.out.println("\n\n***************************");
//						System.out.println("The Order No. "+(globalOrderID-1)+" is ready.");
						for(Order o: orderList) {
							if(o.getOrderID() == globalOrderID - 1) {
								cust = o.getCustomerID();
								o.setOrderStatus(true);
							}
						}
						for(Customer c: customerList) {
							if(c.getCustomerID() == cust) {
								System.out.println("Customer Name: "+c.getName());
							}
						}
						System.out.println("\n\n***************************\n\n\n");
						System.out.println("\nTotal Amount: "+totalAmount);
						System.out.println("Procced to payment....");
						System.out.println("Payment done!!");
						
					}
					System.out.println("Enter key 'Z' to end the pizza orders for the day!!!");
					
				}
			}
			
			
			
			//quit for loop for end the order ; end of the day!!!
			//take another item? 'y' continue else System.out.exit()
			
			//if you press key, 'E' or 'e' then you'll have to write the below code
			System.out.println("Ending the process....");
			System.exit(0);
		}
				
	}

}
