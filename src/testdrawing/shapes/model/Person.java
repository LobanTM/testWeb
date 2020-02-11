package testdrawing.shapes.model;

public class Person {
	
	private String name;
	private int begin;
	private int end;
	private String color;
	
	public Person(int begin, int end) {
		super();
		this.begin = begin;
		this.end = end;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Person(int begin, int end, String name, String color) {
		super();
		this.name = name;
		this.begin = begin;
		this.end = end;
		this.color = color;
	}
	
	public Person(String begin, String end, String name, String color) {
		super();
		this.name = name;
		this.begin =  (Integer.valueOf(begin));
		this.end = (Integer.valueOf(end));
		this.color = color;
	}
	
	
	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	

}
