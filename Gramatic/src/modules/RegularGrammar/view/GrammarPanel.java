package modules.RegularGrammar.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		JPanel pane = new JPanel();
		pane.setBackground(Color.WHITE);
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		
		terminalVarLabel = new JLabel("<html>&Sigma;:( )</html>");
		terminalVarLabel.setFont(ConstansGUI.GADUGI_FONT);
		panel2.add(terminalVarLabel);
		
		textTerminalVar = new JTextArea();
		textTerminalVar.setBorder(new RoundedBorder(10));
		textTerminalVar.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		textTerminalVar.setPreferredSize(new Dimension(200, 40));
		panel2.add(textTerminalVar);
		panel2.setAlignmentX(CENTER_ALIGNMENT);
		add(panel2);
		
		JLabel spaceLb = new JLabel();
		spaceLb.setBorder(new EmptyBorder(8, 0, 8, 0));
		add(spaceLb);
		
		JButton btnAddVar = new JButton("Añadir variable terminal");
		btnAddVar.setAlignmentX(CENTER_ALIGNMENT);
		btnAddVar.setActionCommand(Actions.ADD_ALPHABET.toString());
		btnAddVar.addActionListener(l);
		btnAddVar.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		btnAddVar.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		btnAddVar.setForeground(Color.WHITE);
		add(btnAddVar);
		
		JLabel lbb2 = new JLabel();
		lbb2.setBorder(new EmptyBorder(50, 0, 0, 0));
		add(lbb2);
		JPanel panel = new JPanel();
		
		nonTerminalVarLabel = new JLabel("V:( )");
		nonTerminalVarLabel.setFont(new Font("Lato", Font.PLAIN, 18));
		panel.add(nonTerminalVarLabel);
		
		textNonTerminalVar = new JTextArea();
		textNonTerminalVar.setBorder(new RoundedBorder(10));
		textNonTerminalVar.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		textNonTerminalVar.setPreferredSize(new Dimension(200, 40));
		panel.add(textNonTerminalVar);
		panel.setBackground(Color.WHITE);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		add(panel);
		
		JLabel spaceLbTwo = new JLabel();
		spaceLbTwo.setBorder(new EmptyBorder(8, 0, 8, 0));
		add(spaceLbTwo);
		
		JButton btnAdd = new JButton("Añadir variable no terminal");
		btnAdd.setAlignmentX(CENTER_ALIGNMENT);
		btnAdd.setActionCommand(Actions.ADD_NON_TERMINAL_VARIABLES.toString());
		btnAdd.addActionListener(l);
		btnAdd.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		btnAdd.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		btnAdd.setForeground(Color.WHITE);
		add(btnAdd);
		
		JLabel lbb = new JLabel();
		lbb.setBorder(new EmptyBorder(50, 0, 0, 0));
		add(lbb);
		
		axiomaticalSymbolLabel = new JLabel("S:()");
		axiomaticalSymbolLabel.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		pane.add(axiomaticalSymbolLabel);
		
		combo = new JComboBox<>();
		combo.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		combo.setBackground(Color.WHITE);
		pane.add(combo);
		pane.setAlignmentX(CENTER_ALIGNMENT);
		add(pane);

		JLabel spaceLbThree = new JLabel();
		spaceLbThree.setBorder(new EmptyBorder(8, 0, 8, 0));
		add(spaceLbThree);
		
		JButton btnSimAxi = new JButton("Seleccionar simbolo");
		btnSimAxi.setAlignmentX(CENTER_ALIGNMENT);
		btnSimAxi.setActionCommand(Actions.SELECT_INITIAL_AXIOMATIC_SYMBOL.toString());
		btnSimAxi.addActionListener(l);
		btnSimAxi.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		btnSimAxi.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		btnSimAxi.setForeground(Color.WHITE);
		add(btnSimAxi);
		
		JLabel lb = new JLabel();
		lb.setBorder(new EmptyBorder(50, 0, 0, 0));
		add(lb);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		JLabel lblVarPro = new JLabel("Producciones");
		lblVarPro.setFont(new Font("Lato", Font.PLAIN, 18));
		panel3.setAlignmentX(CENTER_ALIGNMENT);
		panel3.add(lblVarPro);
		
		textFirstProduction = new JTextArea();
		textFirstProduction.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		textFirstProduction.setBorder(new RoundedBorder(10));
		textFirstProduction.setPreferredSize(new Dimension(150, 40));
		panel3.add(textFirstProduction);
		add(panel3);
		
		JLabel lblPro = new JLabel("<html>&rarr;</html>");
		lblPro.setFont(new Font("Lato", Font.PLAIN, 18));
		panel3.add(lblPro);
		
		textSecondProduction = new JTextArea();
		textSecondProduction.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		textSecondProduction.setPreferredSize(new Dimension(150, 40));
		textSecondProduction.setBorder(new RoundedBorder(10));
		panel3.add(textSecondProduction);
		add(panel3);
		
		JLabel spaceLbFour = new JLabel();
		spaceLbFour.setBorder(new EmptyBorder(8, 0, 8, 0));
		add(spaceLbFour);
		
		JButton btnAddProd = new JButton("Añadir produccion");
		btnAddProd.setAlignmentX(CENTER_ALIGNMENT);
		btnAddProd.addActionListener(l);
		btnAddProd.setActionCommand(Actions.ADD_PRODUCTION.toString());
		btnAddProd.setBackground(Color.decode(ConstansGUI.BLUE_BUTTON));
		btnAddProd.setFont(ConstansGUI.GADUGI_FONT_SMALL);
		btnAddProd.setForeground(Color.WHITE);
		add(btnAddProd);
		
		JLabel lbb3 = new JLabel();
		lbb3.setBorder(new EmptyBorder(50, 0, 0, 0));
		add(lbb3);
		
		prodPanel = new JPanel();
		prodPanel.setBackground(Color.WHITE);
		add(prodPanel);
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
