package testdrawing.shapes.model;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Circle extends Ellipse2D{

	private Point p;
	private double width;
	private double height;
	private double radius;	
	
	
	
	public Circle(double x, double y, double width, double height) {
		super();
		this.p = new Point(x, y);
		this.width = width;
		this.height = height;
	}
		
	public Circle(double x, double y, double radius) {
		super();
		this.p = new Point(x, y);
		this.radius = radius;
	}

	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
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
		return p.getX();
	}

	@Override
	public double getY() {		
		return p.getY();
	}

	@Override
	public boolean isEmpty() {		
		return false;
	}

	@Override
	public void setFrame(double x, double y, double width, double height) {
		this.p = new Point(x, y);
		this.height = height;
		this.width = width;		
	}

	
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}	

}
