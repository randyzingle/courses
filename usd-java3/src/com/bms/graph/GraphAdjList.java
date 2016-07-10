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
			for (Integer edge: adjListMap.get(vert)) {
				// TODO if edge = v delete safely 
			}
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
