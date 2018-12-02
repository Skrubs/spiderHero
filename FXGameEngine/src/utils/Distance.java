package utils;

public class Distance {
	
	
	
	
	public Distance() {
	
	}
	
	public static double calculateDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((Math.pow((x1 - x2), 2) + Math.pow((y2-y1), 2)));
	}
	
	public static double slope(double x1, double y1, double x2, double y2) {
		return ((y2-y1)/(x2-x1));
	}

}
