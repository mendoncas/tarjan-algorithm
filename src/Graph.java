import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

    // No. of vertices
    private int V;

    // Adjacency Lists
    private LinkedList<User> adjacencyList[];
    // private List<String> nameReference[];
    private HashMap<Integer, String> nameReference;
    private int Time;

    // Constructor
    @SuppressWarnings("unchecked")
    Graph(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        nameReference = new HashMap<Integer, String>();

        for (int i = 0; i < v; ++i)
            adjacencyList[i] = new LinkedList();

        Time = 0;
    }

    // Function to add an edge into the graph
    void addEdge(int v, User user) {
        adjacencyList[v].add(user);
        nameReference.put(user.index, user.name);
    }


    // A recursive function that finds and prints strongly
    // connected components using DFS traversal
    // u --> The vertex to be visited next
    // disc[] --> Stores discovery times of visited vertices
    // low[] -- >> earliest visited vertex (the vertex with
    // minimum discovery time) that can be reached
    // from subtree rooted with current vertex
    // st -- >> To store all the connected ancestors (could be part
    // of SCC)
    // stackMember[] --> bit/index array for faster check
    // whether a node is in stack
    public List<Cluster> SCCUtil(int u, int low[], int disc[],
            boolean stackMember[],
            Stack<Integer> st) {

        // Initialize discovery time and low value
        List<Cluster> clusters = new ArrayList<Cluster>();
        disc[u] = Time;
        low[u] = Time;
        Time += 1;
        stackMember[u] = true;
        st.push(u);

        User n;

        // Go through all vertices adjacent to this
        Iterator<User> i = adjacencyList[u].iterator();

        while (i.hasNext()) {
            n = i.next();

            if (disc[n.index] == -1) {
                SCCUtil(n.index, low, disc, stackMember, st);

                // Check if the subtree rooted with v
                // has a connection to one of the
                // ancestors of u
                // Case 1 (per above discussion on
                // Disc and Low value)
                low[u] = Math.min(low[u], low[n.index]);
            } else if (stackMember[n.index] == true) {

                // Update low value of 'u' only if 'v' is
                // still in stack (i.e. it's a back edge,
                // not cross edge).
                // Case 2 (per above discussion on Disc
                // and Low value)
                low[u] = Math.min(low[u], disc[n.index]);
            }
        }

        // head node found, pop the stack and print an SCC
        // To store stack extracted vertices
        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = (int) st.pop();
                System.out.print(w + " ");
                System.out.print(nameReference.get(w) + " ");
                stackMember[w] = false;
            }
            System.out.println();
        }
        return clusters;
    }

    // The function to do DFS traversal.
    // It uses SCCUtil()
    void SCC() {

        // Mark all the vertices as not visited
        // and Initialize parent and visited,
        // and ap(articulation point) arrays
        int disc[] = new int[V];
        int low[] = new int[V];
        for (int i = 0; i < V; i++) {
            disc[i] = -1;
            low[i] = -1;
        }

        boolean stackMember[] = new boolean[V];
        Stack<Integer> st = new Stack<Integer>();

        // Call the recursive helper function
        // to find articulation points
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++) {
            if (disc[i] == -1)
                SCCUtil(i, low, disc,
                        stackMember, st);
        }
    }
}
