package inventory;
import java.util.Scanner; 

public class inven1 {
	public String iname;
	public boolean checked = true;
	int price;
	//check the status of the item
	public boolean checked()
	{
		return checked;
	}
	//This function is used to take items from the warehouse.
	public void take() {
		
		checked = false;
	}
	//Part of restock items
	public void returned() {
		checked = true;
		System.out.println("Item is returned ");
	}
	//Return price
	public int getPrice() 
	{
		if (price >0) {
			return price;
		}else {
			System.out.println("Price is not available");
			return 0;
		}
	}
	
}


