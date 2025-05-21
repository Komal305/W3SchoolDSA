package w3school.Graph;

import java.util.Arrays;

public class UnionFindCycle {
	int size;
	int adjMatrix[][];
	char vertexD[];
	int parent[];

	UnionFindCycle(int size) {
		this.size = size;
		this.adjMatrix = new int[size][size];
		this.vertexD = new char[size];
		this.parent = new int[size];

		for (int i = 0; i < size; i++) {
			parent[i] = i;
		}
	}

	void addEdge(int u, int v) {
		if (u >= 0 && v >= 0 && u < size && v < size) {
			adjMatrix[u][v] = 1;
			adjMatrix[v][u] = 1;
		}
	}

	void addVertex(int ver, char data) {
		if (ver >= 0 && ver < size) {
			vertexD[ver] = data;
		}
	}

	int find(int i) {
		if (parent[i] == i) {
			return i;
		}
		return find(parent[i]);
	}

	void Union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		System.out.println("Parent : " + vertexD[x] + " + " + vertexD[y]);
		parent[xRoot] = yRoot;
		System.out.print(Arrays.toString(parent) + "\n");
	}

	boolean isCyclic() {
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (adjMatrix[i][j] == 1) {
					int x = find(i);
					int y = find(j);

					if (x == y)
						return true;
					Union(x, y);
				}
			}
		}
		return false;
	}
	
	/*************  print matrix  *****************/

	public void print() {
		System.out.println("Adjacency matrix");
		for (int[] adjM : adjMatrix) {
			for (int adj : adjM) {
				System.out.print(adj + " ");
			}
			System.out.println();
		}
		int i = 0;
		for (int ver : vertexD)
			System.out.println("vertex " + i++ + " " + (char) ver);
	}
	
	public static void main(String[] args) {
		UnionFindCycle g = new UnionFindCycle(7);
		g.addVertex(0, 'A');
        g.addVertex(1, 'B');
        g.addVertex(2, 'C');
        g.addVertex(3, 'D');
        g.addVertex(4, 'E');
        g.addVertex(5, 'F');
        g.addVertex(6, 'G');

        g.addEdge(1, 0); // B - A
        g.addEdge(0, 3); // A - D
        g.addEdge(0, 2); // A - C
        g.addEdge(2, 3); // C - D
        g.addEdge(3, 4); // D - E
        g.addEdge(3, 5); // D - F
        g.addEdge(3, 6); // D - G
        g.addEdge(4, 5); // E - F

        
        System.out.println("Graph has cycle: " + g.isCyclic());
        g.print();

	}
}
