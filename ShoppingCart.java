import java.util.*;

public class ShoppingCart implements Cart {

    private ArrayList<SelectedItem> items;
    
   public ShoppingCart() {
	   items = new ArrayList<SelectedItem>();
   }
   
   public void addItem(SelectedItem newItem) {
	   items.add(newItem);
   }
   
   public void deleteItem(int deleteItemNumber) {
	   items.remove(deleteItemNumber);
   }
   
   public double getTotal() {
	   double cartTotal = 0;
	   for (SelectedItem item : items) {
		   cartTotal = cartTotal + (item.getQuantity() * item.getUnitPrice());
	   }
	   
	   return cartTotal;
   }
   
   
   public void printItems() {
	   for (SelectedItem item : items) {
		   System.out.println(item.getQuantity());;
		   System.out.println(" * " + item.getUnitPrice());
	   }
   }
   
   public double getTax() {
	   double tax = (getTotal() * 0.045);
	   return tax;
   }
   
   public double getShipping() {
	   double ship;
	   if (getTotal() <= 10.00) {
		   ship = 2.50;
	   } else {
		   ship = Math.round((getTotal() + (getTotal() * 0.15) * 100)) / 100;
	   }
	   
	   return ship;
   }
   
   public String toString() {
	   String totalOut = "Total: $" + getTotal() + System.lineSeparator() + "Tax: $" + getTax() + System.lineSeparator() + 
			   "Shipping: $" + getShipping() + System.lineSeparator() + "GRAND TOTAL: $" + (getTotal() + getTax() + getShipping());
	   return totalOut;
   }
}
