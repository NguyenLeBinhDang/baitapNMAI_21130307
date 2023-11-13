package student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		// Enter your code here
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (state[i].isConflict(state[j]) == true) {
					heuristic = heuristic + 1;
				}
			}
		}
		return heuristic;
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			Node n = new Node(state);
			state[i].move();
			if (state[i].getRow() > N - 1) {
				state[i].unMove();
			}
			result.add(n);
		}
		// Enter your code here

		return result;
	}

	public Node getBestCandidate() {
		Node best = null;
		int min = 9999;
		List<Node> candidate = generateAllCandidates();
		for (Node n : candidate) {
			int currentHeuristic = n.getH();
			if (currentHeuristic < min) {
				best = n;
				min = currentHeuristic;
			}
		}
//		best.displayBoard();
//		System.out.println("++++++++++++++++++");
//		System.out.println(best.getH());
		return best;
	}

	public Node selectNextRandomCandidate() {
		// Enter your code here

		return null;
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}

	public Node execute(Node initialState) {
		// Enter your code here.
		Node current = initialState;
		Node neighbor = null;
		int i = 3;
		if (current.getH() == 0) {
			return current;
		} else {
			while (current.getH() != 0||i != 0) {
				neighbor = current.getBestCandidate();
				if (neighbor.getH() < current.getH()) {
					current = neighbor;
				} else {
					return current;
				}
				i--;
			}
		}
		return current;
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		// Enter your code here.
		return null;
	}

	public static void main(String[] args) {
		Node n = new Node();
		n.generateBoard();
		n.displayBoard();
		System.out.println(n.getH());
		System.out.println("-----------------------------------------------------------------");
//		n.getBestCandidate();
		System.out.println("-----------------------------------------------------------------");
		n.execute(n);
		n.displayBoard();
		System.out.println(n.getH());
	}
}