package testdrawing.shapes.model;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Line extends Line2D{
	
	private Point p1;
	private Point p2;
	private String color;

	public Line(double x1, double y1, double x2, double y2, String color) {
		super();
		this.p1 = new Point(x1,y1);
		this.p2 = new Point(x2,y2);	
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Line() {
		super(); 
	}

	public Line(double x1, double y1, double x2, double y2) {
		this.p1 = new Point(x1,y1);
		this.p2 = new Point(x2,y2);		 
	}
	
	public Line(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}	

	public Rectangle2D getBounds2D() {		
		return null;
	}

	@Override
	public Point2D getP1() {		
		return p1;
	}

	@Override
	public Point2D getP2() {		
		return p2;
	}

	@Override
	public double getX1() {		
		return p1.getX();
	}

	@Override
	public double getX2() {
		return p2.getX();
	}

	@Override
	public double getY1() {
		return p1.getY();
	}

	@Override
	public double getY2() {
		return p2.getY();
	}

	@Override
	public void setLine(double x1, double y1, double x2, double y2) {
		this.p1 = new Point(x1,y1);
		this.p2 = new Point(x2,y2);
		
	}

}
