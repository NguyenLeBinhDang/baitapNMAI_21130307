package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();
//	private List<Node> children = new ArrayList<Node>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		data.sort(DESCOMPARATOR);
		List<Node> children = new ArrayList<Node>();
		for (int i = 0; i < data.size(); i++) {
			int curr = data.get(i);
			for (int j = 1; j <= curr / 2; j++) {
				if (j != curr - j) {
					Node n = new Node();
					n.add(j);
					n.add(curr - j);
					for (int k = 0; k < data.size(); k++) {
						if (k != i) {
							n.add(data.get(k));
							if (!children.contains(n)) {
								children.add(n);
							}
						}
					}
				}
			}
		}
//		System.out.println(children);
		return children;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		data.sort(DESCOMPARATOR);
		if (data.get(0) == 2) {
			return true;
		}
		return false;
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
