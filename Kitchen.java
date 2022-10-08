import java.lang.Thread;

public class Kitchen {
	private int orderID;
	private int timeToPrepare;
	
	Kitchen(int orderID, int timeToPrepare){
		this.orderID = orderID;
		this.timeToPrepare = timeToPrepare;
	}
	
	public boolean notification() {
		cooking();
		System.out.println("Order No. "+this.orderID+" is ready!!");
		return true;
	}
	
	public void cooking() {
		Thread cookingTime = new Thread();
		try {
			cookingTime.sleep(this.timeToPrepare);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
