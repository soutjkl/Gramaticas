package modules.RegularGrammar.view;

import java.util.List;

import javax.swing.JPanel;

import modules.RegularGrammar.models.Production;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

public class ProductionsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel accumulatedPanel;

	public ProductionsPanel(List<Production> list) {
		setSize(100,200);
		setLayout(new BorderLayout(0, 0));
		setBackground(Color.WHITE);
		
		accumulatedPanel = new JPanel();
		add(accumulatedPanel, BorderLayout.CENTER);
		accumulatedPanel.setBackground(Color.WHITE);
		accumulatedPanel.setLayout(new GridLayout(list.size(), 1, 10, 10));
		refreshPanel(list);
	}

	public void refreshPanel(List<Production> list) {
		accumulatedPanel.removeAll();
		for (Production production : list) {
			accumulatedPanel.add(new ProductionCard(production));
		}
		repaint();
		revalidate();
	}

}
