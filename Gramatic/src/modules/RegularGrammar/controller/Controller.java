package modules.RegularGrammar.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modules.RegularGrammar.models.Grammar;
import modules.RegularGrammar.view.MainWindow;

public class Controller implements ActionListener {

	private Grammar grammar;
	private MainWindow mainWindow;

	public Controller() {
		// TODO Auto-generated constructor stub
		try {
			this.grammar = new Grammar();
			this.mainWindow = new MainWindow(this);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("The Controller class could not be instantiated.");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (Actions.valueOf(e.getActionCommand())) {
		case ADD_NON_TERMINAL_VARIABLES:
			addV();
			break;
		case ADD_PRODUCTION:
			addProduction();
			break;
		case ADD_ALPHABET:
			addAlphabet();
			break;
		case VALIDATE_LANGUAJE:
			this.mainWindow.changeToGrammar();
			break;
		case PANEL_GRAMMAR:
			this.mainWindow.changeToGrammarPanel();
			break;
		case PANEL_PARTIAL_TREE:
			this.mainWindow.changeToCenterPanel();
			break;
		case VALIDATE:
			validateGeneralDerivationTree();
			validatePartialTree();
			break;
		case SELECT_INITIAL_AXIOMATIC_SYMBOL:
			addAxiomaticInitialSymbol();
		default:
			break;
		}
	}

	public void addAxiomaticInitialSymbol() {
		this.grammar.setAxiomaticInitialSymbol(this.mainWindow.axiomaticalSymbol());
		this.mainWindow.changeAxiomaticSymbol();
	}

	public void validateGeneralDerivationTree() {
		this.grammar.isValidate(this.mainWindow.validateWord());
		this.mainWindow.change(this.grammar.getTree().getRoot(), this.grammar.getStatus());
		if (this.grammar.getStatus().equals("No pertenece al lenguaje")) {
			JOptionPane.showMessageDialog(null,
					"El lenguaje no pertenece, no se puede graficar el �rbol de derivaci�n general");
		}
		this.grammar.setStatus("");
	}

	public void addProduction() {
		this.grammar.getProductions().add(this.mainWindow.getProduct());
		this.mainWindow.refreshProductions(this.grammar.getProductions());
	}

	public void validatePartialTree() {
		this.grammar.isValidate(this.mainWindow.validateWord());
		this.mainWindow.changeToCenterPanel(this.grammar.getTree().getRoot(), this.grammar.getStatus());
		if (this.grammar.getStatus().equals("No pertenece al lenguaje")) {
			JOptionPane.showMessageDialog(null,
					"El lenguaje no pertenece, no se puede graficar el arbol " + "de derivacion particular");
		}
		this.grammar.setStatus("");
	}

	public void addAlphabet() {
		String alp = this.mainWindow.getAlphabet();
		boolean flag = true;
		for (int i = 0; i < this.grammar.getAlpabeth().size(); i++) {
			if (alp.equals(this.grammar.getAlpabeth().get(i))) {
				flag = false;
			}
		}
		for (int i = 0; i < this.grammar.getNonTerminalVariables().size(); i++) {
			if (alp.equals(this.grammar.getNonTerminalVariables().get(i))) {
				flag = false;
			}
		}
		if (flag) {
			this.grammar.getAlpabeth().add(alp);
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe");
		}
		this.mainWindow.changeAlphabetLabel(this.grammar.getAlpabeth());
	}

	// non terminal variables
	public void addV() {
		String v = this.mainWindow.getV();
		boolean flag = true;
		for (int i = 0; i < this.grammar.getNonTerminalVariables().size(); i++) {
			if (v.equals(this.grammar.getNonTerminalVariables().get(i))) {
				flag = false;
			}
		}
		for (int i = 0; i < this.grammar.getAlpabeth().size(); i++) {
			if (v.equals(this.grammar.getAlpabeth().get(i))) {
				flag = false;
			}
		}
		if (flag) {
			this.grammar.getNonTerminalVariables().add(v);
		} else {
			JOptionPane.showMessageDialog(null, "Ya existe");
		}
		this.mainWindow.refreshCombo(this.grammar.getNonTerminalVariables());
		this.mainWindow.changeNonTerminalLabel(this.grammar.getNonTerminalVariables());
	}

	public static void main(String[] args) {
		new Controller();
	}
}