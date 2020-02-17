package testdrawing.shapes.images;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import connector.GetFromFile;
import testdrawing.shapes.model.ArcFamily;
import testdrawing.shapes.model.Circle;
import testdrawing.shapes.model.Line;
import testdrawing.shapes.model.Person;
import testdrawing.shapes.model.Rectangle;
import testdrawing.shapes.model.TextImage;
import testdrawing.shapes.tools.GraphicsPanel;

public class FamilyList {
	private List<Person> data = new ArrayList<>();	
	private List<Object> listOfShapes = new ArrayList<>();
	private GetFromFile dataFile = new GetFromFile();	
	private InputStream inputStream;
	private int countPersons;
	private int beginEpohe = 1600;
	private int endEpohe = 2000; 	
	
	public FamilyList(InputStream inputStream) throws IOException {
		super();		
		this.inputStream = inputStream;
		dataFile.setInputStream(inputStream);
		
		this.data = dataFile.getData();
		this.countPersons = data.size();
		
		List birthday = new ArrayList();
	 	for (Person p : data) {
	 		birthday.add((int)p.getBegin());
	 	}
	 	Collections.sort(birthday);
	 	this.beginEpohe = (((int)birthday.get(0)/100)*100);	 	
	 	
	}

	public int getCountPersons() {
		return countPersons;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;		
	}

	public int getBeginEpohe() {
		return beginEpohe;
	}

	public List<Person> getData() {
		return data;
	}

	public void setData(List<Person> data) {
		this.data = data;
	}

	public int getEndEpohe() {
		return endEpohe;
	}
	
	public List<Object> getListOfShapes() throws IOException{
				        
	        int year=new Date().getYear()+ 1900;     	
	        int rightKoef = 300;
	        
	        int fromTop = 40;  //расстояние от верха до первого прямоугольника
	        
	        int def = (int)(endEpohe-beginEpohe)/100;
	        Line h = new Line(0,100,def*rightKoef,100);
	        listOfShapes.add(h);	        
	        
	        for (int j=0; j<def+1;j++) {
	        	int a= (int)( j*rightKoef);
	        	//System.out.println(a); 
		        //Line v = ;
		        listOfShapes.add(new Line(a, 0,a,50+30*countPersons));
	        }
	        int i=0;
	        for (Person p : data) {	        	
	        	int nowDay = p.getEnd();
	        	if (nowDay==0) {nowDay=year;}
	        	double height = 20 ; 								//вьісота прямоугольника
	        	double width = 3*(nowDay-p.getBegin());				//длина прямоугольника
	        	double y = fromTop+i*(height+5);
	        	double x = 3*(p.getBegin()-beginEpohe);
	        	
	        	Rectangle r = new Rectangle(x,y,width,height, p.getColor());
	        	listOfShapes.add(r);
	        	
	        	//System.out.println(nowDay);       
	        	String nameEnd= String.valueOf(nowDay);
	        	if (nowDay==(new Date().getYear()+ 1900)) {nameEnd = "";}
	        	TextImage textBegin = new TextImage(String.valueOf(p.getBegin()), x-20, y );
	        	TextImage textEnd = new TextImage(nameEnd, (width+x), ( y) );
	        	TextImage textName = new TextImage(String.valueOf(p.getName()), (x+10), ( y+15) );	        	
	        	
	        	listOfShapes.add(textBegin);
	        	listOfShapes.add(textEnd);
	        	listOfShapes.add(textName);
	        	i++;
	        }    			 
		return listOfShapes;
	}
	
	public void drawArc() {
		 List<Object> list = new ArrayList<Object>();
		 Color[] colors = {Color.BLUE, Color.RED,Color.BLUE, Color.RED};   
		 data.add(new Person(1950, 2020));
		 data.add(new Person(1951, 2000));
		 data.add(new Person(1930, 2020));
		 data.add(new Person(1901, 2010));
		 data.add(new Person(1916, 1990));
		 data.add(new Person(2006, 2020));
		 data.add(new Person(1920, 2000));
		 data.add(new Person(1930, 1990));
		 data.add(new Person(1940, 1994));
		 data.add(new Person(1950, 2000));
		 data.add(new Person(1960, 1994));
		 data.add(new Person(1970, 1990));
		
		 
		 	for (int i=0; i<41; i++) {
		 		Line l = new Line(100,100,400-i*10,100+i*10);
		 		//list.add(l);
		 	}
		 	//lines.forEach(l->list.add(l));
	        Line h = new Line(0,300,1000,300);
	        Line v = new Line(300, 0,300,1000);
	        Line v1 = new Line(700, 0,700,1000);
	        Line d1 = new Line(0, 0,1000,1000);
	        Line d2 = new Line(600, 0,0,600);
	        
	        Rectangle rect = new Rectangle(20,40,100,150);
	        Circle c = new Circle(100,100,300,200);      
	        int i=0;
	        for (Person p : data) {
	        	
	        	double width =  5*( p.getBegin()-1800)+20*i; //
	        	double height =  width;
	        	double x = 300-(width/2);
	        	double y = x;
	        	double angleStart = 0 - (2020 - p.getEnd()); //
	        	double angleExtent = angleStart - (p.getEnd() - p.getBegin());
	        	
	        	
	        	Arc2D arc = new Arc2D.Double(x,y,		//центр круга
	        								width,height,	//радиус (ширина, висота)
	        								angleStart,angleExtent,		//от угла и до угла (градусьі)
	        								Arc2D.PIE);	//тип арки (OPEN - открьітая, CHORD - с хородой, PIE - сектор)
	        	
	        	//TextImage t1 = new TextImage(String.valueOf(p.getBegin()), (width), (y+height) );
	        	TextImage t2 = new TextImage(String.valueOf(p.getBegin()), (width+x+angleStart), (300-angleStart*5) );
	        	//TextImage t2 = new TextImage(String.valueOf(p.getEnd()), (width+x+angleStart), (300-angleStart*5) );
	        	//ArcFamily arc = new ArcFamily(p.getBegin(),p.getEnd());
	        	 
	        	 /*
	        	 ArcFamily arc = new ArcFamily(p.getBegin(),p.getEnd(),		//центр круга
											//width,height,	//радиус (ширина, висота)
											//angleStart,angleExtent,		//от угла и до угла (градусьі)
											Arc2D.PIE,	//тип арки (OPEN - открьітая, CHORD - с хородой, PIE - сектор)
											colors[i]);
	        	 i++;
	        	 if (i==4) {i=0;}
	        	 */
	        	i++;
	        	list.add(arc);
	        	//list.add(t1);
	        	list.add(t2);
	        
	        }
	       
        	
        	list.add(h);list.add(v);list.add(v1);list.add(d1);list.add(d2);
        	
	        //list.add(lines);
	        //list.add(rect);
	        //list.add(c);
	        //list.add(arc);
	        //list.add(arc01);
	        
	        
	        JFrame frame = new JFrame();
	        frame.setTitle("Test");
	        frame.setSize(new Dimension(1500,1000));
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(new GridBagLayout());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        GraphicsPanel gp = new GraphicsPanel(list);        
	        
	        frame.add(gp, new GridBagConstraints(0,0,1,1,1,1,
	        					GridBagConstraints.NORTH,GridBagConstraints.BOTH,
	        					new Insets(2,2,2,2),0,0));
	        frame.setVisible(true);
	        
	        listOfShapes.add(list);
	}

	public void drawLine() {
		 List<Object> list = new ArrayList<Object>();
		 Color[] colors = {Color.BLUE, Color.RED,Color.BLUE, Color.RED};   
		 data.add(new Person(1950, 2020));
		 data.add(new Person(1970, 2020));
		 data.add(new Person(1990, 2020));
		 data.add(new Person(1901, 2010));
		 data.add(new Person(1916, 1990));
		 data.add(new Person(2006, 2020));
		 data.add(new Person(1920, 2000));
		 data.add(new Person(1930, 1990));
		 data.add(new Person(1940, 1994));
		 data.add(new Person(1950, 2000));
		 data.add(new Person(1960, 1994));
		 data.add(new Person(1970, 1990));
		
		 
		 	for (int i=0; i<41; i++) {
		 		Line l = new Line(100,100,400-i*10,100+i*10);
		 		//list.add(l);
		 	}
		 	//lines.forEach(l->list.add(l));
	        Line h = new Line(0,300,1000,300);
	        int a= ( 1800 - 1800);
	        Line v = new Line(a, 0,a,1000);
	        a= 5*( 1900 - 1800);
	        Line v1 = new Line(a, 0,a,1000);
	        a= 5*( 2000 - 1800);
	        Line v2 = new Line(a, 0,a,1000);
	        a= 5*( 2020 - 1800);
	        Line v3 = new Line(a, 0,a,1000);
	        //Line d1 = new Line(0, 0,1000,1000);
	        //Line d2 = new Line(600, 0,0,600);
	        
	        Rectangle rect = new Rectangle(20,40,100,150);
	        Circle c = new Circle(100,100,300,200);      
	        int i=0;
	        for (Person p : data) {
	        	
	        	double height = 20 ; //
	        	double width = 5*(p.getEnd()-p.getBegin());
	        	double y = 300+i*30+30;
	        	double x = 5*(p.getBegin()-1800);
	        	
	        	Rectangle r = new Rectangle(x,y,width,height);
	        	
	        	TextImage t1 = new TextImage(String.valueOf(p.getBegin()), x-20, y );
	        	TextImage t2 = new TextImage(String.valueOf(p.getEnd()), (width+x), ( y) );
	        	
	        	list.add(r);
	        	list.add(t1);
	        	list.add(t2);
	        	i++;
	        }
	       
       	
       	list.add(h);list.add(v);list.add(v1);list.add(v2);list.add(v3);
       	//list.add(d1);list.add(d2);
       	
	        //list.add(lines);
	        //list.add(rect);
	        //list.add(c);
	        //list.add(arc);
	        //list.add(arc01);
	        
	        
	        JFrame frame = new JFrame();
	        frame.setTitle("Test");
	        frame.setSize(new Dimension(1500,1000));
	        frame.setLocationRelativeTo(null);
	        frame.setLayout(new GridBagLayout());
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        GraphicsPanel gp = new GraphicsPanel(list);        
	       
	        frame.add(gp, new GridBagConstraints(0,0,1,1,1,1,
	        					GridBagConstraints.NORTH,GridBagConstraints.BOTH,
	        					new Insets(2,2,2,2),0,0));
	        frame.setVisible(true);
       	//listObject.add(list);
       	//return listObject;
	}

}
