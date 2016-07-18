package roadgraph;

import geography.GeographicPoint;

public class EdgeNode {
	
	private GeographicPoint endPoint;
	private String roadName;
	private String roadType;
	private double length;
	
	public EdgeNode(){}
	
	public EdgeNode(GeographicPoint endPoint, String roadName, String roadType, double length) {
		super();
		this.endPoint = endPoint;
		this.roadName = roadName;
		this.roadType = roadType;
		this.length = length;
	}

	public GeographicPoint getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(GeographicPoint endPoint) {
		this.endPoint = endPoint;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "EdgeNode [endPoint=" + endPoint + ", roadName=" + roadName + ", roadType=" + roadType + ", length="
				+ length + "]";
	}


}
