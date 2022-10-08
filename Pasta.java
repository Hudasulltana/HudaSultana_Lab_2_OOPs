import java.util.Scanner;

public class Pasta implements Entity{

	enum Type {Penne, Ditalini} //no change in cost for this -- assume some 20$ or something
	enum Flavour {White_Sauce, Red_Sauce} // $10, $20
	
	private Type type;
	private Flavour flavour;
//	private int OrderID;
	
	Pasta(int OrderID, int type, int flavour) {
//		this.OrderID = OrderID;
		switch(type) {
			case 1: this.type = Type.Penne;
				break;
			case 2: this.type = Type.Ditalini;
				break;
		}
		
		switch(flavour) {
		case 1: this.flavour = Flavour.White_Sauce;
			break;
		case 2: this.flavour = Flavour.Red_Sauce;
			break;
			
		}
	}
	
	@Override
	public float Pricing() {
		float amount = 0.0f;
		if(this.flavour == Flavour.White_Sauce) {
			amount = 10f;
		}
		else if(this.flavour == Flavour.Red_Sauce) {
			amount = 20f;
		}
		return amount; 
	}


	@Override
	public void DisplayCustomerOrder() {
		System.out.println("");
	}
	
	@Override
	public void displayList() {
		System.out.println("The Types available are as follows:");
		System.out.println(java.util.Arrays.asList(Type.values())+"\n");
		System.out.println("The Flavours available are as follows:");
		System.out.println(java.util.Arrays.asList(Flavour.values())+"\n");		
	};
}
