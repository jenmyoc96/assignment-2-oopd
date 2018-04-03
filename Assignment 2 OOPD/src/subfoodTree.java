import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.text.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.tree.*;

public class subfoodTree extends JxFrame implements TreeSelectionListener {

	
	Food food;
	SubFood Sweet;
	SubFood Savory;
	SubFood chocolate,cake;
	SubFood tart,pie;
	
	JScrollPane sp ;
	JPanel treePanel;
	JTree tree;
	DefaultMutableTreeNode troot; 
	JLabel label;
	
	public subfoodTree() {
		super("food Tree");
		makeFoods();
		setGui();
		
	}
	private void setGui() {
		treePanel = new JPanel();
		getContentPane().add(treePanel);
		treePanel.setLayout(new BorderLayout());
		
		sp = new JScrollPane();
		treePanel.add("center",sp);
		treePanel.add("south", label = new JLabel("hello"));
		
		treePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		troot = new DefaultMutableTreeNode(food.getName());
		tree = new JTree(troot);
		tree.setBackground(Color.RED);
		loadTree(food);
		
		sp.getViewport().add(tree);
		setSize(new Dimension(100,200));
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

        Enumeration e = sf.subordinates();
        if (e != null) {
            while (e.hasMoreElements()) {
                SubFood newSubf = (SubFood)e.nextElement();
                node = new DefaultMutableTreeNode(newSubf.getName());
                pnode.add(node);
                addNodes(node, newSubf);
            }
        }
    }
	private void makeFoods() {
		food = new Food("Food");
		food.add(Sweet = new Food("Sweet"));
		food.add(Savory = new Food("savory"));
		
		Sweet.add(chocolate = new Food("chocolate"));
		Sweet.add(cake = new Food("cake"));
		
		Savory.add(tart = new Food("tart"));
		Savory.add(pie = new Food("pie"));
			
	}

	  public void valueChanged(TreeSelectionEvent evt) {
	        TreePath path = evt.getPath();
	        String selectedTerm = path.getLastPathComponent().toString();

	        SubFood subfood = food.getChild(selectedTerm);
	  }
	public static void main(String argv[]) {
		new subfoodTree();
	}

}


