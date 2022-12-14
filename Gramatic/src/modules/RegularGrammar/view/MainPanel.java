package modules.RegularGrammar.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modules.RegularGrammar.dataStructure.MyNode;
import modules.RegularGrammar.models.Production;


public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel actual;
	private DinamicPanel dinamicPanel;

	public MainPanel(ActionListener listener) {
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		dinamicPanel = new DinamicPanel(listener);
		this.actual = dinamicPanel;
		add(dinamicPanel);
	}

	public void change(MyNode<String> node, String rute) {
		dinamicPanel.change(node, rute);
	}

	public void changeToCenterPanel(MyNode<String> node, String route) {
		dinamicPanel.changeContainer(node, route);
	}

	public String getAphabet() {
		return dinamicPanel.getaphabet();
	}

	public String getNoTerminal() {
		return dinamicPanel.getNoTerminal();
	}

	public Production getProduction() {
		return dinamicPanel.getProduction();
	}

	public String axiomaticalSimbol() {
		return dinamicPanel.getAxiomaticalSymbol();
	}

	public String validateWord() {
		return dinamicPanel.getText();
	}

	public void changeToGrammar() {
		dinamicPanel.changeToGrammar();
	}

	public void changeToCenterPanel() {
		dinamicPanel.changeToCenterPanel();
	}

	public void changeToGrammarPanel() {
		dinamicPanel.changeToGrammarPanel();
	}

	public void changeAlphabetLabel(List<String> list) {
		dinamicPanel.changeAlphabetLabel(list);
		repaint();
		revalidate();
	}

	public void changeNonTerminalLabel(List<String> list) {
		dinamicPanel.changeNonTerminalLabel(list);
		repaint();
		revalidate();
	}

	public void refreshNoTerminal(List<String> list) {
		dinamicPanel.refreshNoTerminal(list);
	}

	public void refreshProductions(List<Production> list) {
		dinamicPanel.refreshProductions(list);
	}

	public void changeAxiomaticSymbol() {
		dinamicPanel.changeAxiomaticSymbol();
	}

	public JPanel getActual() {
		return actual;
	}

	public void setActual(JPanel actual) {
		this.actual = actual;
	}
}
