package modules.RegularGrammar.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import modules.RegularGrammar.dataStructure.MyNode;

public class GrammarParticularTreePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MyNode<String> root;
	private String x = "";

	public GrammarParticularTreePanel(MyNode<String> node) {
		this.root = node;
	}
	
	@Override
	public void paint(Graphics g) {
		String [] total = this.x.split(",");
		Graphics2D g2d = (Graphics2D)(g);
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 2000, 1000);
		if (total.length > 1) {
			drawPartialTree(g2d, total, 0); 
		}
	}
	
	public void drawPartialTree(Graphics g, String [] valores, int y) {
		int x = (int)getSize().getWidth()/2;
		g.setColor(Color.decode(ConstansGUI.YELLOW_COLOR));
		for (int i = 0; i < valores.length-1; i++) {
			g.setColor(Color.decode(ConstansGUI.YELLOW_COLOR));
			g.fillOval(x, y, 50, 30);
			g.setColor(Color.BLACK);
			g.drawString(valores[i], x +15, y +17);
			if (i < valores.length -2) {
				g.drawLine(x + 25, y+30 ,	x + 25 , y+100);
			}
			y += 100;
		}
	}
	
	public void refreshPartialTree(MyNode<String> newRoot, String rute) {
		this.root = newRoot;
		this.x = rute;
		repaint();
		revalidate();
	}

	public MyNode<String> getRoot() {
		return root;
	}

	public void setRoot(MyNode<String> root) {
		this.root = root;
	}

	public void setX(String x) {
		this.x = x;
	}
}
