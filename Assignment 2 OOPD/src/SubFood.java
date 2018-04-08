import java.util.*;

public class SubFood extends AbstractSubFood {
	

		public SubFood( String foodName, long f ) {
			name = foodName;
			price = f ;
			leaf = true;
		}
	 public SubFood(SubFood initParent,String foodName,long initPrice) {
		 	name = foodName;
		 	price = initPrice;
		    leaf = true;
		    parent = initParent;
	 }
	
	 public long getPrice() {
		 return price;
	 }
	 public String getName() {
		 return name;
	 }
	 public boolean add(SubFood p) throws NoSuchElementException{
		 throw new NoSuchElementException("No subordinates");
	 }
	 public void remove(SubFood p) throws NoSuchElementException {
	     throw new NoSuchElementException("No subordinates");
	 }
	 public Enumeration subordinates () {
	     Vector v = new Vector();
	     return v.elements ();
	 }
	 //--------------------------------------
	 public SubFood getChild(String s) throws NoSuchElementException {
	     throw new NoSuchElementException("No children");
	 }

	public SubFood getParent() {
		return parent;
	}
	
}
