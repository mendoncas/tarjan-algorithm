import java.util.ArrayList;
import java.util.Arrays;

public class App {
	public static void main(String[] args) throws Exception {
		ArrayList<Cluster> clusters;

		// Create a graph given in the above diagram
		Graph g1 = new Graph(5);
		ArrayList g1Users = new ArrayList<User>(Arrays.asList(
				new User(0, "Ricardo"),
				new User(1, "Ronaldo"),
				new User(2, "Roberto"),
				new User(3, "Arthur"),
				new User(4, "Rafael")));

		g1.addUsers(g1Users);
		g1.addEdge(0, 2);
		g1.addEdge(0, 1);
		g1.addEdge(1, 0);
		g1.addEdge(1, 2);
		g1.addEdge(2, 1);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		System.out.println("\n Clusters no primeiro grafo: ");
		clusters = g1.SCC();
		g1.makeRecommendations();

		Graph g2 = new Graph(4);
		ArrayList g2Users = new ArrayList<User>(Arrays.asList(
				new User(0, "Ricardo"),
				new User(1, "Ronaldo"),
				new User(2, "Roberto"),
				new User(3, "Rafael")));

		g2.addUsers(g2Users);
		g2.addEdge(0, 0);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		System.out.println("\n Clusters no segundo grafo: ");
		g2.SCC();
		g2.makeRecommendations();

		Graph g3 = new Graph(7);
		ArrayList g3Users = new ArrayList<User>(Arrays.asList(
				new User(0, "Ricardo"),
				new User(1, "Ronaldo"),
				new User(2, "Roberto"),
				new User(3, "Arthur"),
				new User(4, "Jonas"),
				new User(5, "Vitor"),
				new User(6, "Rafael")));

		g3.addUsers(g3Users);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 0);
		g3.addEdge(2, 3);
		g3.addEdge(3, 0);
		g3.addEdge(1, 3);
		g3.addEdge(1, 4);
		g3.addEdge(1, 6);
		g3.addEdge(3, 5);
		System.out.println("\n Clusters no terceiro grafo: ");
		g3.SCC();
		g3.makeRecommendations();

	}
}
