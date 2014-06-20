package graphics;

public class Rect {

	//TODO : add some intersection/union methods
	
	public int l,t,r,b;
	/*
	 * @param l left co ordinate
	 * @param t top co ordinate
	 * @param r right co ordinate
	 * @param b bottom co ordinate
	 */
	public Rect(int l,int t, int r, int b){
		this.l = l;
		this.r = r;
		this.t = t;
		this.b = b;
	}
	
	/* 
	 * change location of rect to x,y without changing width 
	 * and height
	 */
	public void offsetTo(int newLeft, int newTop){
		int w = width();
		int h = height();
		this.l = newLeft;
		this.t = newTop;
		this.r = newLeft+w;
		this.b = newTop+h;
	}
	
	public boolean isValid(){
		if(l<=r && t<=b)
			return true;
		return false;
	}
	
	/*
	 * offset in x or y direction relative to current position
	 * without changing width or height
	 */
	public void offset(int xOffset, int yOffset){
		l+=xOffset; r+=xOffset;
		t+=yOffset; b+=yOffset;
	}
	
	@Override
	public String toString() {
		
		return "["+l+","+t+"]"+" "+"["+r+","+b+"]";
	}
	
	public int width(){
		return Math.abs(r-l);
	}
	
	public int height(){
		return Math.abs(b-t);
	}
	
	public boolean contains(int x,int y){
		if(l<=x && x<=r){
			if(t<=y && y<=b){
				return true;
			}
		}
		return false;
	}
	
	public int centerX(){
		return l+(r-l)/2;
	}
	
	public int centerY(){
		return t+(b-t)/2;
	}
	
	/*
	 * inset inwards/outwards uniformlyif +ve/-ve insets in x,y
	 */
	public void inset(int dx, int dy){
		l+=dx; r-=dx;
		t+=dy; b-=dy;
	}
	
	/*
	 * individual insets in each direction
	 */
	public void inset(int dl,int dt,int dr, int db){
		l+=dl; t+=dt; r-=dr; b-=db;
	}
	
	/*
	 * inset by a given rect
	 */
	public void inset(Rect r){
		inset(r.l,r.t,r.r,r.b);
	}
}
