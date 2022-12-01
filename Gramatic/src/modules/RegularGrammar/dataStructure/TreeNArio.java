package modules.RegularGrammar.dataStructure;

import java.util.Comparator;

public class TreeNArio<T> {

	protected MyNode<T> root;
	protected Comparator<T> comparator;

	public TreeNArio(T data, Comparator<T> comparator) {
		this.root = new MyNode<T>(data);
		this.comparator = comparator;
	}

	public void addSon(T father, T data) {
		addSon(this.root, father, data);
	}

	private void addSon(MyNode<T> root, T father, T data) {
		if (this.comparator.compare(father, root.data) != 0) {
			for (MyNode<T> node : root.sons) {
				addSon(node, father, data);
			}
		} else {
			root.sons.add(new MyNode<T>(root, data));
		}
	}

	public MyNode<T> search(T data) {
		return (this.root != null) ? search(this.root, data) : null;
	}

	public MyNode<T> getRoot() {
		return root;
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	private MyNode<T> search(MyNode<T> root, T data) {
		if (this.comparator.compare(root.data, data) == 0) {
			return root;
		} else if (root.sons.isEmpty()) {
			return null;
		} else {
			for (int i = 0; i < root.sons.size(); i++) {
				MyNode<T> aux = search(root.sons.get(i), data);
				if (aux != null) {
					return aux;
				}
			}
			return null;
		}
	}
}
