public class App {
	public static void main(String[] args) throws Exception {

		// Create a graph given in the above diagram
		Graph g1 = new Graph(5);

		g1.addEdge(1, new User(0, "vaush"));
		g1.addEdge(0, new User(2, "rafael"));
		g1.addEdge(2, new User(1, "teste"));
		g1.addEdge(0, new User(3, "a"));
		g1.addEdge(3, new User(4, "b"));
		System.out.println("SSC in first graph ");
		g1.SCC();

		Graph g2 = new Graph(4);
		g2.addEdge(0, new User(0, "z"));
		g2.addEdge(0, new User(1, "c"));
		g2.addEdge(1, new User(2, "d"));
		g2.addEdge(2, new User(3, "e"));
		System.out.println("\nSSC in second graph ");
		g2.SCC();

		Graph g3 = new Graph(7);
		g3.addEdge(0, new User(1, "f"));
		g3.addEdge(1, new User(2, "g"));
		g3.addEdge(2, new User(0, "h"));
		g3.addEdge(1, new User(3, "i"));
		g3.addEdge(1, new User(4, "j"));
		g3.addEdge(1, new User(6, "k"));
		g3.addEdge(3, new User(5, "l"));
		System.out.println("\nSSC in third graph ");
		g3.SCC();

		// Graph g4 = new Graph(11);
		// g4.addEdge(0, 1);
		// g4.addEdge(0, 3);
		// g4.addEdge(1, 2);
		// g4.addEdge(1, 4);
		// g4.addEdge(2, 0);
		// g4.addEdge(2, 6);
		// g4.addEdge(3, 2);
		// g4.addEdge(4, 5);
		// g4.addEdge(4, 6);
		// g4.addEdge(5, 6);
		// g4.addEdge(5, 7);
		// g4.addEdge(5, 8);
		// g4.addEdge(5, 9);
		// g4.addEdge(6, 4);
		// g4.addEdge(7, 9);
		// g4.addEdge(8, 9);
		// g4.addEdge(9, 8);
		// System.out.println("\nSSC in fourth graph ");
		// g4.SCC();

		// Graph g5 = new Graph (5);
		// g5.addEdge(0, 1);
		// g5.addEdge(1, 2);
		// g5.addEdge(2, 3);
		// g5.addEdge(2, 4);
		// g5.addEdge(3, 0);
		// g5.addEdge(4, 2);
		// System.out.println("\nSSC in fifth graph ");
		// g5.SCC();
	}
}
