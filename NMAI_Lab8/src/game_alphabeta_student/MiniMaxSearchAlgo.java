package game_alphabeta_student;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		System.out.println(maxValue(node));
		
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		// Enter your code here
		int v;
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			node.setValue(Integer.MIN_VALUE);
			v = node.getValue();
//			v = Integer.MIN_VALUE;
			List<Node> childrens = node.getChildren();
			childrens.sort(Node.LabelComparator);
			for (Node child : childrens) {
				v = Math.max(v, minValue(child));
			}
		}
		node.setValue(v);
		System.out.println(node.getLabel()+" "+node.getValue());
		return v;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		// Enter your code here
		int v;
		if (node.isTerminal()) {
			return node.getValue();
		} else {
			node.setValue(Integer.MAX_VALUE);
			v = node.getValue();
//			v = Integer.MAX_VALUE;
			List<Node> childs = node.getChildren();
			childs.sort(Node.LabelComparator);
			for (Node child : childs) {
				v = Math.min(v, maxValue(child));
			}
		}
		node.setValue(v);
		System.out.println(node.getLabel()+" "+node.getValue());
		return v;
	}

	public static void main(String[] args) {
		Node nA = new Node("A");
		Node nB = new Node("B");
		Node nC = new Node("C");
		Node nD = new Node("D");

		Node nE = new Node("E", 3);
		Node nF = new Node("F", 12);
		Node nG = new Node("G", 8);
		Node nH = new Node("H", 2);
		Node nI = new Node("I", 4);
		Node nJ = new Node("J", 6);
		Node nK = new Node("K", 14);
		Node nL = new Node("L", 5);
		Node nM = new Node("M", 2);

		nA.addChild(nB);
		nA.addChild(nC);
		nA.addChild(nD);
		nB.addChild(nE);
		nB.addChild(nF);
		nB.addChild(nG);
		nC.addChild(nH);
		nC.addChild(nI);
		nC.addChild(nJ);
		nD.addChild(nK);
		nD.addChild(nL);
		nD.addChild(nM);

		MiniMaxSearchAlgo m1 = new MiniMaxSearchAlgo();
		m1.execute(nA);
	}
}
