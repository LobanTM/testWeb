package testdrawing.shapes.model;

import java.awt.Font;

public class TextImage {
	
	private String name;
	private double x;
	private double y;
	private int heigthFont;
	private String font;
	private String color;
	
	public TextImage(String name, double x, double y, int heigthFont, String font, String color) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.heigthFont = heigthFont;
		this.font = font;
		this.color = color;
	}
	public TextImage(String name, Float x, Float y, int heigthFont, String font) {
		super();
		this.name = name;
		this.x = x;
		this.y = y;
		this.heigthFont = heigthFont;
		this.font = font;
	}
	public TextImage(String name, double d, double e) {
		super();
		this.name = name;
		this.x = d;
		this.y = e;
		this.heigthFont = 10;
		this.font = Font.SANS_SERIF;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getHeigthFont() {
		return heigthFont;
	}
	public void setHeigthFont(int heigthFont) {
		this.heigthFont = heigthFont;
	}
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

}
