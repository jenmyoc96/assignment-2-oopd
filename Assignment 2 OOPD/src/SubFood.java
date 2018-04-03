import java.util.*;

public class SubFood extends AbstractSubFood {
	

		public SubFood( String foodName ) {
			name = foodName;
			leaf = true;
		}
	 public SubFood(SubFood initParent,String foodName,float initTime) {
		 	name = foodName;
		    leaf = true;
		    parent = initParent;
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
