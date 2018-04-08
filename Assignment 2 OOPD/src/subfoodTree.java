import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class subfoodTree extends JxFrame implements TreeSelectionListener {


	SubFood food, Sweet,Savory;
	SubFood chocolate,cake;
	SubFood tart,pie;
	
	JScrollPane sp ;
	JPanel treePanel;
	JTree tree;
	DefaultMutableTreeNode troot; 
	JLabel label;
	
	public subfoodTree() {
		super("food Tree");
		makeSubFoods();
		setGui();
	}

	//-------------------------
	private void setGui() {
		treePanel = new JPanel();
		getContentPane().add(treePanel);
		treePanel.setLayout(new BorderLayout());
		
		sp = new JScrollPane();
		treePanel.add("Center",sp);
		treePanel.add("South", label = new JLabel("              "));
		
		treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		troot = new DefaultMutableTreeNode(food.getName());
		tree = new JTree(troot);
		tree.setBackground(Color.RED);
		loadTree(food);
		
		sp.getViewport().add(tree);
		setSize(new Dimension(200,300));
		setVisible(true);
		
	}
	public void loadTree(SubFood top) {
		DefaultMutableTreeNode troot;
        troot = new DefaultMutableTreeNode(top.getName());
        treePanel.remove(tree);
        tree= new JTree(troot);
        tree.addTreeSelectionListener(this);
        sp.getViewport().add(tree);

        addNodes(troot, top);
        tree.expandRow(0);
        repaint();
		
	}
	private void addNodes(DefaultMutableTreeNode pnode, SubFood sf) {
        DefaultMutableTreeNode node;

        Enumeration  e = sf.subordinates();
        if (e != null) {
            while (e.hasMoreElements()) {
                SubFood newSubf = (SubFood)e.nextElement();
                node = new DefaultMutableTreeNode(newSubf.getName());
                pnode.add(node);
                addNodes(node, newSubf);
            }
        }
    }
	private void makeSubFoods() {
		food = new Food("Food",100);
		food.add(Sweet = new Food("Sweet", 5));
		food.add(Savory = new Food("savory",67));
		
		Sweet.add(chocolate = new Food("chocolate",4));
		Sweet.add(cake = new Food("cake",4));
		
		chocolate.add(new SubFood("dark",2));
		chocolate.add(new SubFood("milk",2));
		
		Savory.add(tart = new Food("tart",33));
		Savory.add(pie = new Food("pie",34));
		
	}
	 public void valueChanged(TreeSelectionEvent evt) {
	        TreePath path = evt.getPath();
	        String selectedTerm = path.getLastPathComponent().toString();

	        SubFood subfood = food.getChild(selectedTerm);
	        if (subfood != null)
	        	label.setText(new Float(subfood.getPrice()).toString());
	    }
	  
	public static void main(String args[]) {
		new subfoodTree();
	}

}


