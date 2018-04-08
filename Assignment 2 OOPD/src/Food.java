import java.util.*;

public class Food extends SubFood {
Vector subfoods;

public Food(String foodName,long initPrice) {
	super(foodName,initPrice);
	leaf = false;
	subfoods = new Vector();
}
public Food(String foodName,SubFood initParent , long initPrice) {
	
	super(initParent,foodName, initPrice);
	leaf = false;
	subfoods = new Vector();
	
}
public Food(SubFood subf) {
	super(subf.getName(),subf.getPrice());
	leaf = false;
	subfoods = new Vector();
	
}
public boolean add(SubFood f) throws NoSuchElementException{
	subfoods.add(f);
	return true;
}
public void remove(SubFood f) throws NoSuchElementException{
	subfoods.removeElement(f);
	
}
public Enumeration subordinates() {
	return subfoods.elements();
}
public SubFood getChild(String s )throws NoSuchElementException{
	
	SubFood newSubf = null;
	
	if (getName().equals(s))
		return this;
	else {
		boolean found = false;
		Enumeration e = subordinates();
		while(e.hasMoreElements()&&(! found)) {
			newSubf = (SubFood)e.nextElement();
			found = newSubf.getName().equals(s);
			   if (! found) {
	                 if (! newSubf.isLeaf ()) {
	                     newSubf = newSubf.getChild(s);
	                 } else
	                     newSubf = null;
	                 found =(newSubf != null);
	             }
	         }
	         if (found)
	             return newSubf;
	         else
	             return null;
	     }
}
	public long getPrice() {
		long sum = price;
		for(int i = 0;i<subfoods.size();i++) {
			sum += ((SubFood)subfoods.elementAt(i)).getPrice();	
			}
		return sum;
	}
}
