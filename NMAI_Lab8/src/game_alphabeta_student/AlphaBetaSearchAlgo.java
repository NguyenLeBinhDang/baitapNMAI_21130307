package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		int v;
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			node.setValue(Integer.MIN_VALUE);
			v = node.getValue();
			List<Node> children = node.getChildren();
			children.sort(Node.LabelComparator);
			for (int i = 0; i < children.size(); i++) {
				v = Math.max(v, minValue(children.get(i), alpha, beta));
				if (v >= beta) {
					for (int j = i + 1; j < children.size(); j++) {
						System.out.println("Đã cắt nhánh: " + children.get(j).getLabel());
					}
					System.out.println("Best for the Node was from: " + node.getLabel());
					return v;
				}
				alpha = Math.max(alpha, v);
			}
		}
		node.setValue(v);
		System.out.println(node.getLabel() + " " + node.getValue());
		return v;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		int v;
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			node.setValue(Integer.MAX_VALUE);
			v = node.getValue();
			List<Node> children = node.getChildren();
			children.sort(Node.LabelComparator);
			for (int i = 0; i < children.size(); i++) {
				v = Math.min(v, maxValue(children.get(i), alpha, beta));
				if (v <= alpha) {
					for (int j = i + 1; j < children.size(); j++) {
						System.out.println("Đã cắt nhánh: " + children.get(j).getLabel());
					}
					System.out.println("Best for the Node was from: " + node.getLabel());
					return v;
				}
				beta = Math.min(beta, v);
			}
		}
		node.setValue(v);
		System.out.println(node.getLabel() + " " + node.getValue());
		return v;
	}

	public static void main(String[] args) {
		Node na = new Node("A");
		Node nb = new Node("B");
		Node nc = new Node("C");
		Node nd = new Node("D", 0);
		Node ne = new Node("E");
		Node nf = new Node("F");
		Node ng = new Node("G", -5);
		Node nh = new Node("H", 3);
		Node ni = new Node("I", 8);
		Node nj = new Node("J");
		Node nk = new Node("K");
		Node nl = new Node("L", 2);
		Node nm = new Node("M");
		Node nn = new Node("N", 4);
		Node no = new Node("O");
		Node np = new Node("P", 9);
		Node nq = new Node("Q", -6);
		Node nr = new Node("R", 0);
		Node ns = new Node("S", 3);
		Node nt = new Node("T", 5);
		Node nu = new Node("U", -7);
		Node nv = new Node("V", -9);
		Node nw = new Node("W", -3);
		Node nx = new Node("X", 5);

		na.addChild(nb);
		na.addChild(nc);
		na.addChild(nd);
		na.addChild(ne);
		nb.addChild(nf);
		nb.addChild(ng);
		nc.addChild(nh);
		nc.addChild(ni);
		nc.addChild(nj);
		ne.addChild(nk);
		ne.addChild(nl);
		ne.addChild(nm);
		nf.addChild(nn);
		nf.addChild(no);
		nj.addChild(np);
		nj.addChild(nq);
		nj.addChild(nr);
		nk.addChild(ns);
		nk.addChild(nt);
		nm.addChild(nu);
		nm.addChild(nv);
		no.addChild(nw);
		no.addChild(nx);

		AlphaBetaSearchAlgo as = new AlphaBetaSearchAlgo();
		as.execute(na);
	}
}
