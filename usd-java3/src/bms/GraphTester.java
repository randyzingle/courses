package bms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import basicgraph.Graph;
import basicgraph.GraphAdjList;
import basicgraph.GraphAdjMatrix;

public class GraphTester {
// simple.data file
//	5
//	0 1
//	0 2
//	0 3
//	1 0
//	1 4
//	2 0 
//	2 3
//	3 0
//	3 2
//	4 1

	public static void main(String[] args) throws Exception {
		simpleTest();
	}

	private static void simpleTest() throws FileNotFoundException, IOException {
		// lets start with an adjacency list type graph
		Graph grlist = new GraphAdjList();
		Graph grmatr = new GraphAdjMatrix();
		
		// load the data in data/mystuff/simple.data (5 vertex graph)
		String file = "data/mystuff/simple.data";
		BufferedReader br = new BufferedReader(new FileReader(file));
		// first line has # of vertices (see file in comments at top of class)
		int nvert = Integer.parseInt(br.readLine());
		System.out.println(nvert);
		// add the vertices
		for (int i=0; i<nvert; i++) {
			grlist.addVertex();
			grmatr.addVertex();
		}
		
		// read the edges and add them to the graph
		String line = null;
		while ( (line=br.readLine()) != null) {
			System.out.println(line);
			String[] svert = line.split("\\s+");
			int v = Integer.parseInt(svert[0]);
			int w = Integer.parseInt(svert[1]);
			grlist.addEdge(v, w);
			grmatr.addEdge(v, w);
		}
		br.close();
		
		// print out the graph
		System.out.println("Simple graph as list:");
		System.out.println(grlist.adjacencyString());
		System.out.println("Simple graph as matrix:");
		System.out.println(grmatr.adjacencyString());
		// Degree sequence -> number of neighbors for each vertex in decreasing order
		System.out.println("Degree Sequence:");
		System.out.println(grlist.degreeSequence());
		System.out.println(grmatr.degreeSequence());
		int v = 0;
		System.out.println("vertex: " + v);
		System.out.println("neigbors: " + grlist.getNeighbors(v));
		System.out.println("in neigbors: " + grlist.getInNeighbors(v));
		System.out.println("two hop vertices for " + v + ": ");
		System.out.println(grlist.getDistance2(v));
		System.out.println(grmatr.getDistance2(v));
	}

}
