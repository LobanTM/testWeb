package testdrawing.shapes.model;

import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class ArcFamily extends Arc2D{
	
	private final int marge = 100; 
	private double angleStart = -180;
	private double angleExtent = 0;
	private int typeArc = Arc2D.CHORD;
	
	private Point centre = new Point(0, 0);
	private int begin;
	private int end;
	
	private double x;
	private double y;
	private double width;
	private double height;
	private Color color = Color.BLUE ;
	
	public ArcFamily(double angleStart, int typeArc, Point centre) {
		super();
		this.angleStart = angleStart;
		//this.typeArc = typeArc;
		//this.centre = centre;
	}

	/*public ArcFamily(int begin, int end) {
		super();
		this.angleStart = angleStart;
		//this.typeArc = typeArc;
		//this.centre = centre;
		this.x = centre.getX();
		this.y = centre.getY();
		this.width = marge + (end - begin);
		this.height = width;
		this.angleExtent = angleStart - (end - begin);		
	}
*/
	public ArcFamily(int begin, int end, int typeArc, Color color) {
		super();
		this.angleStart = 0 - (2020 - end );
		this.angleExtent = angleStart - 2*(end - begin);
		
		this.width = 5*( begin - 1800);
		this.height = width;
		this.x = 0-width/2;
		this.y = x;		
		this.color = color;
		this.typeArc = 1;
	}

	

	@Override
	public String toString() {
		return "ArcFamily [angleStart=" + angleStart + ", angleExtent=" + angleExtent + ", typeArc=" + typeArc + ", x="
				+ x + ", y=" + y + ", width=" + width + ", height=" + height + ", color=" + color + "]";
	}

	@Override
	public double getAngleExtent() {
		return angleStart-(end-begin);
	}

	@Override
	public double getAngleStart() {
		return angleStart;
	}
	
	

	@Override
	protected Rectangle2D makeBounds(double arg0, double arg1, double arg2, double arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAngleExtent(double angleExtent) {
		this.angleExtent = angleExtent;		
	}

	@Override
	public void setAngleStart(double angleStart) {
		this.angleStart = angleStart;
	}

	@Override
	public void setArc(double x, double y, double height, double width, double angleStart, double angleExtent, int typeArc) {
		//this.angleStart = angleStart;
		//this.typeArc = typeArc;
		//this.centre = new Point(x, y);
		
		//this.width = width;
		//this.height = height;
		//this.angleExtent = angleExtent;		
	}

	@Override
	public double getHeight() {		
		return height;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getX() {
		return centre.getX();
	}

	@Override
	public double getY() {
		return centre.getY();
	}

	@Override
	public boolean isEmpty() {		
		return false;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}
