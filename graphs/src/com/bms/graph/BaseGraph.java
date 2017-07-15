package com.bms.graph;

public abstract class BaseGraph {
	
	int nvert;
	int nedge;
	
	public int getNvert() {
		return nvert;
	}
	
	public int getNedge() {
		return nedge;
	}
	
	public abstract void addVertex();
	
	public abstract void removeVertex(int v);
	
	public abstract void addEdge(int v, int w);
	
	public abstract void removeEdge(int v, int w);

}
