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
import java.util.ArrayList;
import java.util.Arrays;
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
	private String nameFileData = "";
	private List<Object> listObject = new ArrayList<>();
	private GetFromFile dataFile = new GetFromFile();
	
	public FamilyList(String nameFileData) {
		super();
		this.nameFileData = nameFileData;
	}

	public List<Object> listOfShapes() throws IOException{
		List <Object>listObject1 = new ArrayList<>();
		/* data.add(new Person(1950, 0, "FirstName", "bisque"));		 
		 data.add(new Person(1951, 2000, "FirstName", "fuchsia"));
		 data.add(new Person(1930, 0, "FirstName", "turquoise"));
		 data.add(new Person(1901, 2010, "FirstName", "crimson"));
		 data.add(new Person(1916, 1990, "FirstName", "tomato"));
		 data.add(new Person(2006, 0, "FirstName", "magenta"));
		 data.add(new Person(1920, 2000, "FirstName", "violet"));
		 data.add(new Person(1930, 1990, "FirstName", "purple"));
		 data.add(new Person(1940, 1994, "FirstName", "pink"));
		 data.add(new Person(1950, 2000, "FirstName", "green"));
		 data.add(new Person(1960, 1994, "FirstName", "olive"));
		 data.add(new Person(1970, 1990, "FirstName", "lime"));
		 data.add(new Person(1970, 0, "FirstName", "chocolate"));
		 data.add(new Person(1970, 1990, "FirstName", "yellow"));
		 data.add(new Person(1970, 1990, "FirstName", "khaki"));
		 data.add(new Person(2020, 0, "FirstName", "BLUE"));
		*/ 
		//dataFile.setNameFile("/home/loban/Projects/LDAP/projectSpase/testweb/resource/dataFileExample.csv");
		dataFile.setNameFile(nameFileData);
		
		 data = dataFile.getData();
		 		 
		 	//lines.forEach(l->list.add(l));
	        Line h = new Line(0,100,1000,100);
	        listObject1.add(h);
	        int year=new Date().getYear()+ 1900;
	        int beginEpohe = 1700;
	        int endEpohe = 2000;	        
	        int def = (int)(endEpohe-beginEpohe)/100;
	        
	        for (int j=0; j<def+1;j++) {
	        	int a= (int)( j*3*100);
	        	System.out.println(a); 
		        Line v = new Line(a, 0,a,1000);
		        listObject1.add(v);
	        }
	        
	        //int a= ( 1800 - 1850);
	        //Line v = new Line(a, 0,a,1000);
	        //a= 5*( 1900 - 1850);
	        //Line v1 = new Line(a, 0,a,1000);
	        //a= 5*( 2000 - 1850);
	        //Line v2 = new Line(a, 0,a,1000);
	        //a= 5*( 2020 - 1850);
	        //Line v3 = new Line(a, 0,a,1000);
	        
	        int i=0;
	        for (Person p : data) {
	        	
	        	int nowDay = p.getEnd();
	        	if (nowDay==0) {nowDay=year;}
	        	double height = 20 ; //
	        	double width = 3*(nowDay-p.getBegin());
	        	double y = 20+i*30+30;
	        	double x = 3*(p.getBegin()-beginEpohe);
	        	
	        	Rectangle r = new Rectangle(x,y,width,height, p.getColor());
	        	
	        	System.out.println(nowDay);       
	        	String n= String.valueOf(nowDay);
	        	if (nowDay==(new Date().getYear()+ 1900)) {n = "";}
	        	TextImage t1 = new TextImage(String.valueOf(p.getBegin()), x-20, y );
	        	TextImage t2 = new TextImage(n, (width+x), ( y) );
	        	TextImage tn = new TextImage(String.valueOf(p.getName()), (x+10), ( y+15) );
	        	
	        	listObject1.add(r);
	        	listObject1.add(t1);
	        	listObject1.add(t2);
	        	listObject1.add(tn);
	        	i++;
	        }	       
    			 
		return listObject1;
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
	        
	        listObject.add(list);
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
