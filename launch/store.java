package inventory;
import java.util.Scanner; 

public class store extends inven1 {
	inven1 v[] = new inven1 [10];
	static int i = 0;
	//for adding items to inventory
	void addItem(String iname) {
		
		v[i] = new inven1();
		this.iname=iname;
		v[i].iname=iname;
		i++;
		System.out.println("Item added successfully");
		
	}
	//Function for taking item out of inventory. It checks name of item
	void checkOut(String iname)
	{
		for (int k=0; k< i; k++)
		{
			if (v[k].iname.equalsIgnoreCase(iname)) {
				if (v[k].checked()) {
					v[k].take();
					System.out.println("Item successfully taken");
					System.out.println("WARNING! ITEM IS LOW ON SUPPLY.");
					System.out.println("Item has been sucessfully restocked");

				}
				else {
					System.out.println("Item is out of stock");
				}
			}
		}
	
	}
	//restocking item
	void returnItem(String iname) {
		if (i==0) {
			System.out.println("Item has been restocked");
		}
		for (int k =0; k<i; k++) {
			if (v[k].iname.equalsIgnoreCase(iname)) {
				v[k].checked = true;
			}
		}
	}
	//Setting price to items
	public void receivePrice() {
		if (i==0) {
			System.out.println("No items in Inventory");
		}
		else {
			for (int k=0; k< i; k++) {
				System.out.println("Enter the price of the item " + v[k].iname);
				Scanner ob = new Scanner(System.in);
				v[k].price = ob.nextInt();
			}
		}
	}
	//listing the inventory
	public void listInventory() {
		if (i==0) {
			System.out.println("No items in Inventory");
		}else {
			for (int k = 0; k < i;k++) {
				System.out.println(k + 1 + ". " + v[k].iname + " " + "Price: " 
						+ v[k].price + " Status: " + v[k].checked());
			}
		}
	}
}
