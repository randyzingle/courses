package roadgraph;

import geography.GeographicPoint;

public class EdgeNode implements Comparable<EdgeNode> {
	
	private GeographicPoint location;
	private String roadName;
	private String roadType;
	private double length;
	private double distanceFromStart = Double.MAX_VALUE;
	private static double TINY = 0.0001;
	
	public EdgeNode(){}
	
	public EdgeNode(GeographicPoint location, String roadName, String roadType, double length) {
		this.location = location;
		this.roadName = roadName;
		this.roadType = roadType;
		this.length = length;
	}

	public double getDistanceFromStart() {
		return distanceFromStart;
	}

	public void setDistanceFromStart(double distanceFromStart) {
		this.distanceFromStart = distanceFromStart;
	}

	public GeographicPoint getLocation() {
		return location;
	}

	public String getRoadName() {
		return roadName;
	}

	public String getRoadType() {
		return roadType;
	}

	public double getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "EdgeNode [endPoint=" + location + ", roadName=" + roadName + ", roadType=" + roadType + ", length="
				+ length + ", distanceFromStart=" + distanceFromStart + "]";
	}

	@Override
	public int compareTo(EdgeNode otherNode) {
		if (otherNode == null) throw new NullPointerException("Trying to compare EdgeNode to null");
 
		if (this.distanceFromStart > otherNode.getDistanceFromStart()) {
			return 1;
		} else if (this.distanceFromStart < otherNode.getDistanceFromStart()) {
			return -1;
		}
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EdgeNode other = (EdgeNode) obj;
		double distance = this.getLocation().distance(other.getLocation());
		if (distance < TINY) return true;
		return false;
	}
	
	

}