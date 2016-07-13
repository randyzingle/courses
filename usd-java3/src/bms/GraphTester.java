package bms;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import basicgraph.Graph;
import basicgraph.GraphAdjList;

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
		Graph myg = new GraphAdjList();
		
		// load the data in data/mystuff/simple.data (5 vertex graph)
		String file = "data/mystuff/simple.data";
		BufferedReader br = new BufferedReader(new FileReader(file));
		// first line has # of vertices (see file in comments at top of class)
		int nvert = Integer.parseInt(br.readLine());
		System.out.println(nvert);
		// add the vertices
		for (int i=0; i<nvert; i++) {
			myg.addVertex();
		}
		
		// read the edges and add them to the graph
		String line = null;
		while ( (line=br.readLine()) != null) {
			System.out.println(line);
			String[] svert = line.split("\\s+");
			int v = Integer.parseInt(svert[0]);
			int w = Integer.parseInt(svert[1]);
			myg.addEdge(v, w);
		}
		br.close();
		
		// print out the graph
		System.out.println("Simple graph:");
		System.out.println(myg.adjacencyString());
		// Degree sequence -> number of neighbors for each vertex in decreasing order
		System.out.println("Degree Sequence:");
		System.out.println(myg.degreeSequence());
		int v = 4;
		System.out.println("vertex: " + v);
		System.out.println("neigbors: " + myg.getNeighbors(v));
		System.out.println("in neigbors: " + myg.getInNeighbors(v));
		System.out.println("two hop vertices for " + v + ": ");
		System.out.println(myg.getDistance2(v));
	}

}
