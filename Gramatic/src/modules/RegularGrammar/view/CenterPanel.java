package modules.RegularGrammar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import modules.RegularGrammar.dataStructure.MyNode;

public class CenterPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private GrammarParticularTreePanel grammarParticularTreePanel;

	public CenterPanel(ActionListener listener) {
		initCenterPanel();
	}
	
	public void initCenterPanel() {
		this.grammarParticularTreePanel = new GrammarParticularTreePanel(null);
		setLayout(new BorderLayout());
		setSize(300, 300);
		setBackground(Color.blue);
		
		add(this.grammarParticularTreePanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void changeContainer(MyNode<String> node , String rute) {
		this.grammarParticularTreePanel.refreshPartialTree(node, rute);
		repaint();
		revalidate();
	}
}
