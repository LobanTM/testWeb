package testdrawing.shapes.model;

import java.awt.Color;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;

public class ArcFamily {
	private int x;
	private int y;
	private int radius;
	private double startAngle;
	private double endAngle;
	private boolean anticlockwise; //1 - против часовой стрелки, 0 - по часововй стрелке
	private String color;	
	
	public ArcFamily() {
		super();
		this.x = 0;
		this.y = 0;
		this.radius = 100;
		this.startAngle = 0;
		this.endAngle = (Math.PI/2);
		this.anticlockwise = false;
		this.color = "black";
	}
	public ArcFamily(int x, int y, int radius, double startAngle, double endAngle, boolean anticlockwise, String color) {
		super();
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.startAngle = startAngle;
		this.endAngle = endAngle;
		this.anticlockwise = anticlockwise;
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public double getStartAngle() {
		return startAngle;
	}
	public void setStartAngle(double startAngle) {
		this.startAngle = startAngle;
	}
	public double getEndAngle() {
		return endAngle;
	}
	public void setEndAngle(double endAngle) {
		this.endAngle = endAngle;
	}
	public boolean isAnticlockwise() {
		return anticlockwise;
	}
	public void setAnticlockwise(boolean anticlockwise) {
		this.anticlockwise = anticlockwise;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
