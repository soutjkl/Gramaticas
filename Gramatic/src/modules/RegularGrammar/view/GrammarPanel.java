package modules.RegularGrammar.view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import modules.RegularGrammar.controller.Actions;
import modules.RegularGrammar.models.Production;

public class GrammarPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> combo ;
	private JPanel prodPanel;
	private JTextArea textTerminalVar;
	private JTextArea textNonTerminalVar ;
	private JTextArea textFirstProduction;
	private JTextArea textSecondProduction;
	private JLabel terminalVarLabel;
	private JLabel nonTerminalVarLabel;
	private JLabel axiomaticalSymbolLabel;
	
	public GrammarPanel(ActionListener l) {
		setBackground(Color.WHITE);
		JPanel pane = new JPanel();
		pane.setBackground(Color.WHITE);
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel2.setBackground(Color.WHITE);
		extracted1(l, pane, panel2, panel3);

		prodPanel = new JPanel();
		prodPanel.setBounds(100, 100, 200, 50);
	}

	private JPanel extracted1(ActionListener l, JPanel pane, JPanel panel2, JPanel panel3) {
		JPanel panels = new JPanel();
		panels.setLayout(new GridLayout(6,2,2,2));
		panels.setBackground(Color.WHITE);

		terminalVarLabel = new JLabel("<html>&Sigma;:( )</html>");
		panel2.add(terminalVarLabel);

		textTerminalVar = new JTextArea();
		textTerminalVar.setBorder(new RoundedBorder(10));
		textTerminalVar.setPreferredSize(new Dimension(100, 30));
		panel2.add(textTerminalVar);
		panel2.setAlignmentX(CENTER_ALIGNMENT);
		panels.add(panel2);

		JButton btnAddVar = new JButton("Añadir variable terminal");
		btnAddVar.setAlignmentX(CENTER_ALIGNMENT);
		btnAddVar.setActionCommand(Actions.ADD_ALPHABET.toString());
		btnAddVar.addActionListener(l);
		btnAddVar.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		panels.add(btnAddVar);

		JPanel panel = new JPanel();
		nonTerminalVarLabel = new JLabel("V:( )");
		panel.add(nonTerminalVarLabel);

		textNonTerminalVar = new JTextArea();
		textNonTerminalVar.setBorder(new RoundedBorder(10));
		textNonTerminalVar.setPreferredSize(new Dimension(100, 30));
		panel.add(textNonTerminalVar);
		panel.setBackground(Color.WHITE);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		panels.add(panel);

		JButton btnAdd = new JButton("Añadir variable no terminal");
		btnAdd.setAlignmentX(CENTER_ALIGNMENT);
		btnAdd.setActionCommand(Actions.ADD_NON_TERMINAL_VARIABLES.toString());
		btnAdd.addActionListener(l);
		btnAdd.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		panels.add(btnAdd);

		axiomaticalSymbolLabel = new JLabel("S:()");
		axiomaticalSymbolLabel.setAlignmentX(CENTER_ALIGNMENT);
		panels.add(axiomaticalSymbolLabel);

		combo = new JComboBox<>();
		combo.setBackground(Color.WHITE);
		panels.add(combo);
		panels.setAlignmentX(CENTER_ALIGNMENT);
		panels.add(pane);

		JButton btnSimAxi = new JButton("Seleccionar simbolo");
		btnSimAxi.setAlignmentX(CENTER_ALIGNMENT);
		btnSimAxi.setActionCommand(Actions.SELECT_INITIAL_AXIOMATIC_SYMBOL.toString());
		btnSimAxi.addActionListener(l);
		btnSimAxi.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		panels.add(btnSimAxi);

		panel3.setBackground(Color.WHITE);
		JLabel lblVarPro = new JLabel("Producciones");
		panel3.setAlignmentX(CENTER_ALIGNMENT);
		panel3.add(lblVarPro);

		textFirstProduction = new JTextArea();
		textFirstProduction.setBorder(new RoundedBorder(10));
		textFirstProduction.setPreferredSize(new Dimension(100, 30));
		panel3.add(textFirstProduction);
		panels.add(panel3);

		JLabel lblPro = new JLabel("<html>&rarr;</html>");
		panel3.add(lblPro);

		textSecondProduction = new JTextArea();
		textSecondProduction.setPreferredSize(new Dimension(100, 30));
		textSecondProduction.setBorder(new RoundedBorder(10));
		panel3.add(textSecondProduction);
		panels.add(panel3);

		JButton btnAddProd = new JButton("Añadir produccion");
		btnAddProd.setAlignmentX(CENTER_ALIGNMENT);
		btnAddProd.addActionListener(l);
		btnAddProd.setActionCommand(Actions.ADD_PRODUCTION.toString());
		btnAddProd.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		panels.add(btnAddProd);

		add(panels,new Integer(1));
		return panels;
	}

	public String getNoTerminal() {
		String noTerminal = textNonTerminalVar.getText();
		textNonTerminalVar.setText("");
		return noTerminal;
	}
	
	public String getTerminal() {
		String terminal = textTerminalVar.getText();
		textTerminalVar.setText("");
		return terminal;
	}

	public Production getProduction() {
		Production pr = new Production(textFirstProduction.getText(), textSecondProduction.getText());
		textFirstProduction.setText("");
		textSecondProduction.setText("");
		return pr;
	}


	public void refreshCombo(List<String> list) {
		combo.removeAllItems();
		for (String string : list) {
			combo.addItem(string);
		}
		repaint();
		revalidate();
	}
	
	public String getAxiomaticalSymbol() {
		return (String) combo.getSelectedItem();
	}


	public void changeTerminalLabel(List<String> list) {
		terminalVarLabel.setText("<html>&Sigma;:(" + convert(list) + ")</html>");
		System.out.println(list);
	}

	public void changeNonTerminalLabel(List<String> list) {
		nonTerminalVarLabel.setText("V:(" + convert(list) + ")\r\n");
	}

	public String convert(List<String> list) {
		String result = "";
		for (String string : list) {
			if (list.get(list.size() - 1) == string) {
				result += string;
			} else {
				result += string + ", ";
			}
		}
		return result;
	}

	public void reset() {
		textNonTerminalVar.setText("");
		textTerminalVar.setText("");
		textFirstProduction.setText("");
		textSecondProduction.setText("");
		repaint(); 
		revalidate();
	}

	public void refreshProductions(List<Production> list) {
		ProductionsPanel productionsPanel = new ProductionsPanel(list);
		prodPanel.removeAll();
		prodPanel.add(new JScrollPane(productionsPanel), BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void changeAxiomaticSymbol() {
		axiomaticalSymbolLabel.setText("S:(" + combo.getSelectedItem().toString() + ")\r\n");
	}

}
