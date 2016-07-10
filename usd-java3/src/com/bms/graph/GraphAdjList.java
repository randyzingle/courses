package com.bms.graph;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class GraphAdjList extends BaseGraph {
	
	private Map<Integer, ArrayList<Integer>> adjListMap = new TreeMap<>();

	@Override
	public void addVertex() {
		nvert++;
		adjListMap.put(nvert, new ArrayList<Integer>());
	}

	@Override
	public void removeVertex(int v) {
		adjListMap.remove(v);
		for (Integer vert: adjListMap.keySet()) {
			ArrayList<Integer> edges = adjListMap.get(vert);
			edges.remove(new Integer(v));
		}
		nvert--;
	}

	@Override
	public void addEdge(int v, int w) {
		ArrayList<Integer> edges = adjListMap.get(v);
		edges.add(w);

	}

	@Override
	public void removeEdge(int v, int w) {
		ArrayList<Integer> edges = adjListMap.get(v);
		edges.remove(w);

	}

}
