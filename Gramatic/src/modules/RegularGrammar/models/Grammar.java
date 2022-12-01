package modules.RegularGrammar.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import modules.RegularGrammar.dataStructure.MyNode;
import modules.RegularGrammar.dataStructure.TreeNArio;

public class Grammar {

	private String status;
	private String axiomaticInitialSymbol;
	private List<String> alphabet;
	private List<String> nonTerminalVariables;
	private List<Production> productions;
	private TreeNArio<String> tree;
	private long startTime = 0;
	private long elapsedTime = 0;
	private long elapsedSeconds = 0;

	public Grammar() {
		// TODO Auto-generated constructor stub
		this.alphabet = new ArrayList<String>();
		this.productions = new ArrayList<Production>();
		this.nonTerminalVariables = new ArrayList<String>();
		this.axiomaticInitialSymbol = "";
		this.status = new String();
	}

	/**
	 * @param info
	 * @return
	 */
	public boolean isValidate(String info) {
		this.startTime = System.currentTimeMillis();
		return isAccepted(info, changeContain(this.axiomaticInitialSymbol));
	}

	public boolean isAccepted(String info, List<String> list) {
		boolean flag = false;
		boolean validate = false;
		this.tree = new TreeNArio<String>(this.axiomaticInitialSymbol, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
		});
		for (String value : changeContain(this.axiomaticInitialSymbol)) {
			this.tree.addSon(this.axiomaticInitialSymbol, value);
		}
		if (list.size() > 0) {
			while (!flag) {
				this.elapsedTime = System.currentTimeMillis() - this.startTime;
				this.elapsedSeconds = this.elapsedTime / 1000;
				if (this.elapsedSeconds >= 2) {
					flag = true;
					validate = false;
				}
				List<String> auxList = new ArrayList<String>();
				for (String value : list) {
					if (isTerminal(value)) {
						if (value.equals(info)) {
							validate = true;
							flag = true;
							break;
						}
					} else {
						if (count(value) <= info.length()) {
							for (String string : changeContain(value)) {
								this.tree.addSon(value, string);
								auxList.add(string);
							}
						} else {
							flag = true;
						}
					}
				}
				list = auxList;
			}
		}
		if (validate) {
			generateTree(info);
		} else {
			this.status = "no pertenece al lenguaje";
		}
		return validate;
	}

	public TreeNArio<String> generateTree(String info) {
		TreeNArio<String> treeNArio = new TreeNArio<String>(info, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
		});
		MyNode<String> root = this.tree.search(info);
		while (root != this.tree.getRoot()) {
			treeNArio.addSon(root.getData(), root.getFather().getData());
			root = root.getFather();
		}
		TreeNArio<String> auxTree = new TreeNArio<String>(this.axiomaticInitialSymbol, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
		});
		MyNode<String> auxRoot = treeNArio.search(this.axiomaticInitialSymbol);
		while (auxRoot != treeNArio.getRoot()) {
			auxTree.addSon(auxRoot.getData(), auxRoot.getFather().getData());
			auxRoot = auxRoot.getFather();
		}
		printTree(auxTree.getRoot());
		this.status += "Es aceptado";
		return auxTree;
	}

	public void printTree(MyNode<String> root) {
		if (root.getData().equals(this.axiomaticInitialSymbol)) {
			this.status += root.getData() + ",";
		}
		for (int i = 0; i < root.getSons().size(); i++) {
			this.status += root.getSons().get(i).getData() + ",";
			printTree(root.getSons().get(i));
		}
	}

	public int count(String input) {
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if (this.alphabet.contains(input.charAt(i) + "")) {
				count++;
			}
		}
		return count;
	}

	public boolean isTerminal(String input) {
		for (int i = 0; i < input.length(); i++) {
			if (this.nonTerminalVariables.contains(input.charAt(i) + "")) {
				return false;
			}
		}
		return true;
	}

	public List<String> changeContain(String input) {
		List<String> list = new ArrayList<String>();
		for (Production production : this.productions) {
			if (isIn(production.getAxiomaticSymbol(), input)) {
				list.add(replaceAxioma(input, production.getAxiomaticSymbol(), production.getProduction()));
			}
		}
		return list;
	}

	public String replaceAxioma(String text, String axioma, String newValue) {
		String result = new String();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == axioma.charAt(0)) {
				result += newValue;
			} else {
				result += text.charAt(i);
			}
		}
		return result;
	}

	public boolean isIn(String axioma, String input) {
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == axioma.charAt(0)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param result the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the axiomaticInitialSymbol
	 */
	public String getAxiomaticInitialSymbol() {
		return axiomaticInitialSymbol;
	}

	/**
	 * @param axiomaticInitialSymbol the axiomaticInitialSymbol to set
	 */
	public void setAxiomaticInitialSymbol(String axiomaticInitialSymbol) {
		this.axiomaticInitialSymbol = axiomaticInitialSymbol;
	}

	/**
	 * @return the alphabet
	 */
	public List<String> getAlpabeth() {
		return alphabet;
	}

	/**
	 * @param alphabet the alphabet to set
	 */
	public void setAlpabeth(List<String> alphabet) {
		this.alphabet = alphabet;
	}

	/**
	 * @return the nonTerminalVariables
	 */
	public List<String> getNonTerminalVariables() {
		return nonTerminalVariables;
	}

	/**
	 * @param nonTerminalVariables the nonTerminalVariables to set
	 */
	public void setNonTerminalVariables(List<String> nonTerminalVariables) {
		this.nonTerminalVariables = nonTerminalVariables;
	}

	/**
	 * @return the productions
	 */
	public List<Production> getProductions() {
		return productions;
	}

	/**
	 * @param productinos the productions to set
	 */
	public void setProductinos(List<Production> productinos) {
		this.productions = productinos;
	}

	/**
	 * @return the tree
	 */
	public TreeNArio<String> getTree() {
		return tree;
	}

	/**
	 * @param tree the tree to set
	 */
	public void setTree(TreeNArio<String> tree) {
		this.tree = tree;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the elapsedTime
	 */
	public long getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @param elapsedTime the elapsedTime to set
	 */
	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	/**
	 * @return the elapsedSeconds
	 */
	public long getElapsedSeconds() {
		return elapsedSeconds;
	}

	/**
	 * @param elapsedSeconds the elapsedSeconds to set
	 */
	public void setElapsedSeconds(long elapsedSeconds) {
		this.elapsedSeconds = elapsedSeconds;
	}
}
