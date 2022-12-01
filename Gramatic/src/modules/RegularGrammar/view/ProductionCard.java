package modules.RegularGrammar.view;

import javax.swing.JPanel;

import modules.RegularGrammar.models.Production;

import javax.swing.JLabel;

import java.awt.Color;

public class ProductionCard extends JPanel {

	private static final long serialVersionUID = 1L;

	public ProductionCard(Production production) {
		setBackground(Color.decode(ConstansGUI.RED_COLOR));
		
		JLabel productionLb = new JLabel(production.getAxiomaticSymbol());
		productionLb.setFont(ConstansGUI.GADUGI_FONT);
		productionLb.setForeground(Color.WHITE);
		add(productionLb);
		
		JLabel arrowLabel = new JLabel("<html>&rarr;</html>\r\n");
		arrowLabel.setFont(ConstansGUI.TAHOMA_FONT);
		arrowLabel.setForeground(Color.WHITE);
		add(arrowLabel);
		
		JLabel productionTwoLabel = new JLabel(production.getProduction());
		productionTwoLabel.setFont(ConstansGUI.GADUGI_FONT);
		productionTwoLabel.setForeground(Color.WHITE);
		add(productionTwoLabel);
	}

}
