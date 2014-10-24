package geometry;

import java.awt.Point;

public class GeometryUtils {
	
	/*
	 * return -ve for clockwise
	 *        +ve for counterclockwise
	 *        0 for collinear
	 */
	public int arePointsCCW(Point p1,Point p2, Point p3){
		return (p2.x-p1.x)*(p3.y-p1.y)-(p2.y-p1.y)*(p3.x-p1.x);
	}
	
	
	

}
