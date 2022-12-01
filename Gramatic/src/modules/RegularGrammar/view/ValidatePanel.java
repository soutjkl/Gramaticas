package modules.RegularGrammar.view;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import modules.RegularGrammar.controller.Actions;
import modules.RegularGrammar.dataStructure.MyNode;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;


public class ValidatePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField validateWordTextField;
	private GrammarTreePanel tree;
	
	public ValidatePanel(ActionListener listener) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		
		validateWordTextField = new JTextField();
		panel.add(validateWordTextField);
		validateWordTextField.setPreferredSize(new Dimension(150, 40));
		validateWordTextField.setColumns(12);
		
		JButton btnNewButton = new JButton("Validar");
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(ConstansGUI.GADUGI_FONT);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.decode(ConstansGUI.RED_COLOR));
		btnNewButton.setActionCommand(Actions.VALIDATE.toString());
		btnNewButton.addActionListener(listener);
		panel.add(btnNewButton);
		add(panel, BorderLayout.NORTH);	

		tree = new GrammarTreePanel(null);
		add(tree, BorderLayout.CENTER);
	}

	public String getText() {
		return validateWordTextField.getText();
	}

	public void changeTree(MyNode<String> node , String rute) {
		tree.refreshTree(node , rute);
		repaint();
		revalidate();
	}
}
