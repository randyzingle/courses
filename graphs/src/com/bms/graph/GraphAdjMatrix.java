package com.bms.graph;

public class GraphAdjMatrix extends BaseGraph {
	
	private int[][] adjMatrix;
	
	public GraphAdjMatrix(int nvert) {
		adjMatrix = new int[nvert][nvert];
	}

	@Override
	public void addVertex() {
		nvert++;
		// can we fit the new vertex into our existing matrix?
		if (nvert > adjMatrix.length) {
			int[][] newAdjMatrix = new int[nvert*2][nvert*2];
			// copy the old matrix into the new one
			for (int i=0; i<adjMatrix.length; i++) {
				for (int j=0; j<adjMatrix.length; j++) {
					newAdjMatrix[i][j] = adjMatrix[i][j];
				}
			}
			adjMatrix = newAdjMatrix;
		}

	}

	@Override
	public void addEdge(int v, int w) {
		adjMatrix[v][w] = 1;
	}

	@Override
	public void removeVertex(int v) {
	}

	@Override
	public void removeEdge(int v, int w) {
		adjMatrix[v][w] = 0;
		
	}

}
