
public class Pizza implements Entity{
	enum Size {Large, Medium, Small}
	enum Crust {Thin, Thick}
	enum Flavour {Vegetarian, Non_Veg, Vegan}
	enum Topping {Cheese, Mushroom, Tomato, Jalapeno, Spinach}
	

//	private int OrderID;
    private Crust crust;
    private Flavour flavour;
    private Topping toppings;
    private Size size;
	
	Pizza(){
		
	}
	
	Pizza( int  crust,	int  flavour,	int toppings, int size){
		
		//for crust 
		if(crust == 1) {
			this.crust = Crust.Thin;
		}
		else if(crust == 2) {
			this.crust = Crust.Thick;
		}
		
		//for flavor
		if(flavour == 1) {
			this.flavour = Flavour.Vegetarian;
		}
		else if (flavour == 2) {
			this.flavour = Flavour.Non_Veg;
		}
		else if (flavour == 3) {
			this.flavour = Flavour.Vegan;
		}
		
		//for toppings
		if(toppings == 1) {
			this.toppings = Topping.Cheese;
		}
		else if (toppings == 2) {
			this.toppings = Topping.Mushroom;
		}
		else if (toppings == 3) {
			this.toppings = Topping.Tomato;
		}
		else if (toppings == 4) {
			this.toppings = Topping.Jalapeno;
		}
		else if (toppings == 5) {
			this.toppings = Topping.Spinach;
		} 
		//size 
		if(size == 1) {
			this.size = Size.Large;
		}
		else if(size == 2) {
			this.size = Size.Medium;
		}
		else if(size == 3) {
			this.size = Size.Small;
		}
	}
	
	private float flavourAndSizeAmount() {
		float amount = 0.0f;
		if(this.flavour == Flavour.Vegetarian) {
			if(this.size == Size.Small) {
				amount = 20f;
			}
			else if (this.size == Size.Medium) {
				amount = 40f;
			}
			else if(this.size == Size.Large) {
				amount = 60f;
			}
		}
		else if(this.flavour == Flavour.Non_Veg) {
			if(this.size == Size.Small) {
				amount = 25f;
			}
			else if (this.size == Size.Medium) {
				amount = 50f;
			}
			else if(this.size == Size.Large) {
				amount = 75f;
			}
		}
		else if(this.flavour == Flavour.Vegan) {
			if(this.size == Size.Small) {
				amount = 15f;
			}
			else if (this.size == Size.Medium) {
				amount = 30f;
			}
			else if(this.size == Size.Large) {
				amount = 45f;
			}
		}
		
		return amount;
	}
	
	private float toppingsAmount() {
		float amount = 0.0f; 
		//enum Topping {Cheese, Mushroom, Tomato, Jalapeno, Spinach}
		if(this.toppings == Topping.Cheese) {
			amount = 10f;
		}
		else if(this.toppings == Topping.Mushroom) {
			amount = 7f;
		}
		else if(this.toppings == Topping.Tomato) {
			amount = 5f;
		}
		else if(this.toppings == Topping.Jalapeno) {
			amount = 9f;
		}
		else if(this.toppings == Topping.Spinach) {
			amount = 4f;
		}
		return amount;
	}
	
	@Override
	public float Pricing() {
		float totalAmount = 0.0f;
		totalAmount  = totalAmount + flavourAndSizeAmount();
		totalAmount  = totalAmount + toppingsAmount();
		return totalAmount; //put $ in the main statement
	}

	@Override
	public void DisplayCustomerOrder() {
		System.out.println("");
		
	}

	@Override
	public void displayList() {
		System.out.println("\n\n The Pizza Menu is as follows!!!\n\n");
		System.out.println("The Crusts available are as follows:");
		System.out.println(java.util.Arrays.asList(Crust.values())+"\n");
		System.out.println("The Flavours available are as follows:");
		System.out.println(java.util.Arrays.asList(Flavour.values())+"\n");
		System.out.println("The Size available are as follows:");
		System.out.println(java.util.Arrays.asList(Size.values())+"\n");
		System.out.println("The Toppings available are as follows:");
		System.out.println(java.util.Arrays.asList(Topping.values())+"\n");
	}

	
	
//	public String getCrust() {
//	return crust;
//}
//
//public String getFlavour() {
//	return flavour;
//}
//
//public String getToppings() {
//	return toppings;
//}
//
//public String getSize() {
//	return size;
//}
//
}
