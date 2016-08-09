package bms;

import java.util.List;
import java.util.Random;
import java.util.Set;

import geography.GeographicPoint;
import roadgraph.MapGraph;
import util.GraphLoader;

public class MapGraphTesterDijkstra {
	
	private static int NTESTS = 5;
	private static String SIMPLE_MAP = "data/testdata/simpletest.map";
	private static String MAP1 = "data/graders/mod3/map1.txt";

	public static void main(String[] args) {
		try {
			doIt();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void doIt() {
		MapGraph graph = new MapGraph();
		String file = SIMPLE_MAP;
		GraphLoader.loadRoadMap(file, graph);
		System.out.println(graph);
		
		System.out.println("Running Dijkstra Search: ");
		Set<GeographicPoint> plist = graph.getVertices();
		GeographicPoint[] ptArray = plist.toArray(new GeographicPoint[plist.size()]);
		
//		runRandom(graph, ptArray);
		runSet(graph);
	}

	private static void runSet(MapGraph graph) {
		// Dijkstra's algorithm from (7.0, 3.0) to (4.0, -1.0)
		GeographicPoint start = new GeographicPoint(1.0, 1.0);
		GeographicPoint goal = new GeographicPoint(4.0, 0.0);
		System.out.println("starting vertex: " + start);
		System.out.println("end vertext: " + goal);
		List<GeographicPoint> path = graph.dijkstra(start, goal);
		printPath(path);
	}

//	private static void runRandom(MapGraph graph, GeographicPoint[] ptArray) {
//		Random rand = new Random();
//		for (int i=0; i<NTESTS; i++) {	
//			int sin = rand.nextInt(ptArray.length);
//			int gin = rand.nextInt(ptArray.length);
//			GeographicPoint start = ptArray[sin];
//			GeographicPoint goal = ptArray[gin];
//			System.out.println("starting vertex: " + start);
//			System.out.println("end vertext: " + goal);
//			List<GeographicPoint> path = graph.bfs(start, goal);
//			printPath(path);
//		}
//	}
	
	private static void printPath(List<GeographicPoint> path) {
		System.out.print("PathTH: ");
		if (path==null || path.isEmpty()) {
			System.out.println("NO PATH FOUND");
			return;
		}
		StringBuilder buf = new StringBuilder();
		buf.append("\t");
		for (GeographicPoint pt: path) {
			buf.append("("+pt+") ");
		}
		System.out.println(buf.toString());
	}

}
