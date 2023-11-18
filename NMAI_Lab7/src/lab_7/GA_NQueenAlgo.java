package lab_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import lab_7.Node;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
// Enter your code here
		// begin and end
		initPopulation();
		int l = 0;
		while (l++ < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<Node>();
			for (int i = 0; i < POP_SIZE; i++) {
//				Node x = getParentByRandomSelection();
//				Node y = getParentByRandomSelection();
				Node x = getParentByTournamentSelection();
				Node y = getParentByTournamentSelection();
				Node child = reproduce(x, y);
				if (rd.nextDouble() < MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0) {
					return child;
				}
				newPopulation.add(child);
			}
			population = newPopulation;
		}
		Collections.sort(population);
		population.get(0).displayBoard();
		return population.get(0);
	}

// Mutate an individual by selecting a random Queen and 
//move it to a random row.
	public void mutate(Node node) {
// Enter your code here
		int rq = rd.nextInt(Node.N);
		int rr = rd.nextInt(Node.N);
		for (int i = 0; i < rq; i++) {
			node.setRow(rq, rr);
		}
		return;
	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
// Enter your code here
		Node child = new Node();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for (int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			child.setRow(i, y.getRow(i));
		}
		return child;
	}

// Select K individuals from the population at random and 
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
// Enter your code here
		int k = 10;
		List<Node> nodes = new ArrayList<Node>();
		for (int i = 0; i < k; i++) {
			Node child = population.get(rd.nextInt(POP_SIZE));
			if (!nodes.contains(child)) {
				nodes.add(child);
			}
		}
		Collections.sort(nodes);
		Node parrent = nodes.get(0);
		return parrent;
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
// Enter your code here
		Node parrent = population.get(rd.nextInt(POP_SIZE));
		return parrent;
	}

	public static void main(String[] args) {
		GA_NQueenAlgo n = new GA_NQueenAlgo();
		n.execute();

	}
}
