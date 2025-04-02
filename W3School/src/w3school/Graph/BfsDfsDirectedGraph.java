package w3school.Graph;

public class BfsDfsDirectedGraph {
	private int[][] adjMatrix;
	private char[] vertex;
	private int size;

	public BfsDfsDirectedGraph(int size) {
		this.size = size;
		this.adjMatrix = new int[size][size];
		this.vertex = new char[size];
	}

	/************ add edges **********************/
	public void addEdge(int u, int v) {
		if (u >= 0 && u < size && v >= 0 && v < size) {
			adjMatrix[u][v] = 1;
		}
	}

	/************* add vertex data *****************/
	public void addVertex(int ver, char data) {
		if (ver >= 0 && ver < size) {
			vertex[ver] = data;
		}
	}

	/************* print matrix *****************/
	public void print() {
		System.out.println("Adjacency matrix");
		for (int[] adjM : adjMatrix) {
			for (int adj : adjM) {
				System.out.print(adj + " ");
			}
			System.out.println();
		}
		int i = 0;
		for (int ver : vertex)
			System.out.println("vertex " + i++ + " " + (char) ver);
	}
	
	/******************* index ***************************/
	int findVertexIndex(char data) {
		for(int v=0; v<size; v++) {
			if(vertex[v]==data)
				return v;
		}
		return -1;
	}

	/******************* DFS Util ***************************/
	private void dfsUtill(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(vertex[v] + "-->");
		for (int i = 0; i < size; i++) {
			if (adjMatrix[v][i] == 1 && !visited[i]) {
				dfsUtill(i, visited);
			}
		}
	}

	public void DFS(char start) {
		boolean[] v = new boolean[size];
		int startVertex = findVertexIndex(start);
		dfsUtill(startVertex, v);
	}

	/******************* BFS ***************************/
	public void Bfs(char startVertexData) {
		boolean[] visited = new boolean[size];
		int[] queue = new int[size];
		int qStart = 0, qEnd = 0;

		int startVertex = new String(vertex).indexOf(startVertexData); //findVertexIndex(startVertexData);
		queue[qEnd++] = startVertex;
		visited[startVertex] = true;

		while (qStart < qEnd) {
			int currentVertex = queue[qStart++];
			System.out.print(vertex[currentVertex] + "-->");

			for (int i = 0; i < size; i++) {
				if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
					queue[qEnd++] = i;
					visited[i] = true;
				}
			}

		}

	}

	public static void main(String[] args) {
		BfsDfsDirectedGraph g = new BfsDfsDirectedGraph(7);
		g.addVertex(0, 'A');
		g.addVertex(1, 'B');
		g.addVertex(2, 'C');
		g.addVertex(3, 'D');
		g.addVertex(4, 'E');
		g.addVertex(5, 'F');
		g.addVertex(6, 'G');

		g.addEdge(3, 0); // D - A
		g.addEdge(3, 4); // D - E
		g.addEdge(4, 0); // E - A
		g.addEdge(0, 2); // A - C
		g.addEdge(2, 5); // C - F
		g.addEdge(2, 6); // C - G
		g.addEdge(5, 1); // F - B
		g.addEdge(1, 2); // B - c

		g.print();

		System.out.println("\nDFS");
		g.DFS('D');// D-->A-->C-->F-->B-->G-->E-->
		System.out.println("\nBFS");
		g.Bfs('D');// D-->A-->E-->C-->F-->G-->B-->
	}
}
