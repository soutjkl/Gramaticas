package modules.RegularGrammar.dataStructure;

import java.util.ArrayList;
import java.util.List;

public class MyNode<T> {

	protected MyNode<T> father;
	protected List<MyNode<T>> sons;
	protected T data;

	/**
	 * @param data Builder method
	 */
	public MyNode(T data) {
		// TODO Auto-generated constructor stub
		this.father = null;
		this.sons = new ArrayList<MyNode<T>>();
		this.data = data;
	}

	/**
	 * @param father
	 * @param data   Builder method
	 */
	public MyNode(MyNode<T> father, T data) {
		this.father = father;
		this.data = data;
		this.sons = new ArrayList<MyNode<T>>();
	}

	/**
	 * @return the father
	 */
	public MyNode<T> getFather() {
		return father;
	}

	/**
	 * @param father the father to set
	 */
	public void setFather(MyNode<T> father) {
		this.father = father;
	}

	/**
	 * @return the sons
	 */
	public List<MyNode<T>> getSons() {
		return sons;
	}

	/**
	 * @param sons the sons to set
	 */
	public void setSons(List<MyNode<T>> sons) {
		this.sons = sons;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}
}
