package graphics;

public class Point {

	public int x,y;
	
	public Point(int x,int y) {
	
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		
		return "Point:  x = "+x+" y = "+y;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Point){
			Point other = (Point)obj;
			if(other.x==x && other.y==y)
				return true;
		}
		return false;
	}
	
	public void offset(int offset){
		x+=offset;
		y+=offset;
	}
	
	public void offset(int xOffset,int yOffset){
		x+=xOffset;
		y+=yOffset;
	}
	
}
