package modules.RegularGrammar.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import modules.RegularGrammar.dataStructure.MyNode;

public class GrammarTreePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private MyNode<String> root;
	private String totalRoute = "";
	
	public GrammarTreePanel(MyNode<String> node) {
		root = node;
	}
	
	@Override
	public void paint(Graphics g) {
		String [] total = totalRoute.split(",");
		Graphics2D g2d = (Graphics2D)(g);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 2000, 1000);
		if (root != null) {
	        g2d.setColor(Color.decode(ConstansGUI.BLUE_BUTTON));
			g2d.fillOval((int)getSize().getWidth()/2, 0, 30, 30);
			 g2d.setColor(Color.BLACK);
			 if (root.getData() != null) {
				 g2d.drawString(root.getData() , ((int)getSize().getWidth()/2)+15 , 15);
			}
			drawChilds(g2d, root, 0, (int)getSize().getWidth() , 30 , (int)getSize().getWidth()/2, 0 , total);
		}
	}
	
	public void drawChilds(Graphics g2d , MyNode<String> node , int minX , int xSize , int y, int originX , int originY, String[] total) {
		g2d.setColor(Color.decode(ConstansGUI.RED_COLOR));
		if (node.getSons().size() != 0 ) {
			int childsSize = (xSize/node.getSons().size()) ;
			int childSizeTotal = (childsSize/2);
			for (int i = 0; i < node.getSons().size(); i++) {
				for (int j = 0; j < total.length; j++) {
					if (total[j].equals(node.getSons().get(i).getData())) {
						g2d.setColor(Color.decode(ConstansGUI.BLUE_BUTTON));
						g2d.fillOval((childsSize*(i+1)-childSizeTotal)+minX, y+50, 30, 30);
					}else {
						g2d.fillOval((childsSize*(i+1)-childSizeTotal)+minX, y+50, 30, 30);
					}
				}
				g2d.setColor(Color.BLACK);
				g2d.drawString(node.getSons().get(i).getData(), ((childsSize*(i+1)-childSizeTotal)+15)+minX , y+65);
				g2d.drawLine(originX+15, originY+30, (childsSize*(i+1)-childSizeTotal+15)+minX, y+50);
				if (node.getSons().get(i).getSons() != null) {
					drawChilds(g2d, node.getSons().get(i), childsSize*i+minX , childsSize , y+50 , childsSize*(i+1)-childSizeTotal+minX, (y+50), total);
				}
			}
		}
	}
	
	public void refreshTree(MyNode<String> newRoot , String route) {
		root = newRoot;
		totalRoute = route ;
		repaint();
		revalidate();
	}
}
