package modules.RegularGrammar.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import modules.RegularGrammar.dataStructure.MyNode;
import modules.RegularGrammar.models.Production;


public class MainWindow extends JFrame {

	private static final String ICON_PATH = "/modules/RegularGrammar/img/grammaricon.png";
	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	
	public MainWindow(ActionListener listener) {
		setTitle("Gramática");
		setSize(new Dimension(1000, 750));
		setIconImage(new ImageIcon(getClass().getResource(ICON_PATH)).getImage());
		setLocationRelativeTo(null);
		setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
		mainPanel = new MainPanel(listener);
		JScrollPane jScrollPane = new JScrollPane();
		jScrollPane.setViewportView(mainPanel);
		
		getContentPane().add(jScrollPane);
		repaint();
		revalidate();
	}
	 
	public void changeAlphabetLabel(List<String> list) {
		mainPanel.changeAlphabetLabel(list);
		repaint();
		revalidate();
	}

	public void changeNonTerminalLabel(List<String> list) {
		mainPanel.changeNonTerminalLabel(list);
		repaint();
		revalidate();
	}
	
	public void changeToGrammar() {
		mainPanel.changeToGrammar();
	}

	public String getAlphabet() {
		return mainPanel.getAphabet();
	}

	
	public void refreshCombo(List<String> list) {
		mainPanel.refreshNoTerminal(list);
	}

	public Production getProduct() {
		return mainPanel.getProduction();
	}

	public String getV() {
		return mainPanel.getNoTerminal();
	}

	public String axiomaticalSymbol() {
		return mainPanel.axiomaticalSimbol();
	}
	
	public String validateWord() {
		return mainPanel.validateWord();
	}

	public void changeToGrammarPanel() {
		mainPanel.changeToGrammarPanel();
	}
	
	public void changeToCenterPanel () {
		this.mainPanel.changeToCenterPanel();
	}
	
	public void change(MyNode<String> node , String rute) {
		mainPanel.change(node , rute);
		repaint();
		revalidate();
	}
	
	public void changeToCenterPanel(MyNode<String> node , String rute) {
		mainPanel.changeToCenterPanel(node, rute);
		repaint();
		revalidate();
	}

	public void refreshProductions(List<Production> list) {
		mainPanel.refreshProductions(list);
	}

	public void changeAxiomaticSymbol() {
		mainPanel.changeAxiomaticSymbol();
	}
}
