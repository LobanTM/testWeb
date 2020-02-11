package testdrawing.shapes.model;

import java.awt.geom.Rectangle2D;

public class Rectangle extends Rectangle2D {

	private Point p;
	private double width;
	private double height;
	private String color;
	
	public Rectangle(double x, double y, double width, double height, String color) {
		super();
		this.p = new Point(x, y);
		this.width = width;
		this.height = height;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override //пересечение прямоугольников
	public Rectangle2D createIntersection(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override //обьединение прямоугольников
	public Rectangle2D createUnion(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return null; 
	}

	@Override //принадлежность точки прямоугольнику
	public int outcode(double arg0, double arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Rectangle(double x, double y, double width, double height) {
		super();
		this.p = new Point(x, y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void setRect(double x, double y, double width, double height) {
		this.p = new Point(x, y);
		this.height = height;
		this.width = width;
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

}
