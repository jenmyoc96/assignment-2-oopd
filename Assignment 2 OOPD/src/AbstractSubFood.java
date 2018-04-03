	 import java.util.*;

public abstract class AbstractSubFood {
	 
	 	protected String name;
	 	protected SubFood parent = null;
	 	protected boolean leaf = true;
	 	
	 	public abstract String getName();
	 	public abstract boolean add(SubFood s) throws NoSuchElementException;
	 	public abstract Enumeration subordinates();
	 	public abstract SubFood getChild(String p);
	 	public boolean isLeaf() {
	 		return leaf;
	 	}

	 }

