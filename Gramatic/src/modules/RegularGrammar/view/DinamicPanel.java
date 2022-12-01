package modules.RegularGrammar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modules.RegularGrammar.controller.Actions;
import modules.RegularGrammar.dataStructure.MyNode;
import modules.RegularGrammar.models.Production;

public class DinamicPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JPanel actual;
	private GrammarPanel grammarPanel;
	private ValidatePanel jGrammar;
	private CenterPanel centerPanel;
	
	public DinamicPanel(ActionListener listener) {
		setLayout(new BorderLayout());
		jGrammar = new ValidatePanel(listener);
		centerPanel = new CenterPanel(listener);

		JPanel buttonsPanel = new JPanel();

		JLabel emptyLabel = new JLabel();
		emptyLabel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		buttonsPanel.add(emptyLabel);

		JButton grammarBtn = new JButton("Gramatica");
		grammarBtn.addActionListener(listener);
		grammarBtn.setActionCommand(Actions.PANEL_GRAMMAR.toString());
		grammarBtn.setBackground(Color.decode(ConstansGUI.YELLOW_COLOR));
		grammarBtn.setFocusable(false);
		grammarBtn.setFont(ConstansGUI.GADUGI_FONT);
		grammarBtn.setForeground(Color.WHITE);
		grammarBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buttonsPanel.add(grammarBtn);

		JLabel emptyLabelTwo = new JLabel();
		emptyLabelTwo.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		buttonsPanel.add(emptyLabelTwo);

		JButton validationBtn = new JButton("Validar lenguaje");
		validationBtn.addActionListener(listener);
		validationBtn.setActionCommand(Actions.VALIDATE_LANGUAJE.toString());
		validationBtn.setBackground(Color.decode(ConstansGUI.YELLOW_COLOR));
		validationBtn.setFont(ConstansGUI.GADUGI_FONT);
		validationBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		validationBtn.setFocusable(false);
		validationBtn.setForeground(Color.WHITE);
		buttonsPanel.add(validationBtn);

		JLabel emptyLabelThree = new JLabel();
		emptyLabelThree.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));
		buttonsPanel.add(emptyLabelThree);

		JButton particularTreeBtn = new JButton("árbol de derivación particular");
		particularTreeBtn.addActionListener(listener);
		particularTreeBtn.setActionCommand(Actions.PANEL_PARTIAL_TREE.toString());
		particularTreeBtn.setBackground(Color.decode(ConstansGUI.YELLOW_COLOR));
		particularTreeBtn.setFont(ConstansGUI.GADUGI_FONT);
		particularTreeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		particularTreeBtn.setFocusable(false);
		particularTreeBtn.setForeground(Color.WHITE);
		buttonsPanel.add(particularTreeBtn);

		buttonsPanel.setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		
		
		add(buttonsPanel, BorderLayout.SOUTH);
		setBackground(Color.WHITE);

		grammarPanel = new GrammarPanel(listener);
		actual = grammarPanel;
		add(grammarPanel, BorderLayout.NORTH);
	}
	public void refreshNoTerminal(List<String> list) {
		grammarPanel.refreshCombo(list);
	}

	public void change(MyNode<String> node, String rute) {
		jGrammar.changeTree(node, rute);
	}
	
	public void changeContainer (MyNode<String> node, String route) {
		centerPanel.changeContainer(node, route);
	}

	public String getaphabet() {
		return grammarPanel.getTerminal();
	}

	public String getNoTerminal() {
		return grammarPanel.getNoTerminal();
	}

	public Production getProduction() {
		return grammarPanel.getProduction();
	}

	public String getAxiomaticalSymbol() {
		return grammarPanel.getAxiomaticalSymbol();
	}

	public String validateWord() {
		return jGrammar.getText();
	}

	public void changeToGrammar() {
		remove(actual);
		actual = jGrammar;
		add(actual, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void changeToCenterPanel() {
		remove(actual);
		actual = centerPanel;
		add(actual, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void changeToGrammarPanel() {
		remove(actual);
		actual = grammarPanel;
		add(actual, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	public void changeAlphabetLabel(List<String> list) {
		grammarPanel.changeTerminalLabel(list);
		grammarPanel.reset();
		repaint();
		revalidate();
	}
	public void changeNonTerminalLabel(List<String> list) {
		grammarPanel.changeNonTerminalLabel(list);
		grammarPanel.reset();
		repaint();
		revalidate();
	}
	public void refreshProductions(List<Production> list) {
		grammarPanel.refreshProductions(list);
		
	}
	public String getText() {
		return jGrammar.getText();
	}
	
	public void changeAxiomaticSymbol() {
		grammarPanel.changeAxiomaticSymbol();
		grammarPanel.reset();
		repaint();
		revalidate();
	}
}
