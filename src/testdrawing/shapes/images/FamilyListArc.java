package testdrawing.shapes.images;

import java.awt.geom.Arc2D;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import connector.GetFromFile;
import testdrawing.shapes.model.ArcFamily;
import testdrawing.shapes.model.Line;
import testdrawing.shapes.model.Person;
import testdrawing.shapes.model.Rectangle;
import testdrawing.shapes.model.TextImage;

public class FamilyListArc {
	private List<Person> data = new ArrayList<>();	
	private List<Object> listOfShapes = new ArrayList<>();
	private GetFromFile dataFile = new GetFromFile();	
	private InputStream inputStream;
	private int countPersons;
	private int beginEpohe = 1600;
	private int endEpohe = 2000; 
	
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
	
	public FamilyListArc(InputStream inputStream) throws IOException {
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

	
	public List<Object> getListOfShapes() {
		int year=new Date().getYear()+ 1900;     	
        int rightKoef = 100;
        
        int fromTop = 40;  //расстояние от верха до первого прямоугольника
        
        double ang = -Math.PI/2;
        int deltaY = 100;
        int deltaX = 200;
        int proportia = 1;
        TextImage text;
        if (beginEpohe>=1700) {
        	proportia=3;
        	deltaY = 0;
            deltaX = 0;
            listOfShapes.add(new Line(300+deltaX,300+deltaY,
    				(300+deltaX+proportia*(2020-1800)* Math.cos((2020-endEpohe)*(Math.PI/180))),
    				(300+deltaY-proportia*(2020-1800)* Math.sin((2020-endEpohe)*(Math.PI/180)))));
            
            text =  new TextImage(String.valueOf(2000), 1300+deltaX, 295+deltaY );
            listOfShapes.add(text);
        }
        
        int def = (int)(endEpohe-beginEpohe)/100;
        Line h = new Line(0+deltaX,300+deltaY,def*rightKoef+900+deltaX,300+deltaY);
        listOfShapes.add(h);	        
        
        
        for (int j=0; j<def+2;j++) {
        	int a= (int)( j*proportia*rightKoef);
        	//System.out.println(a); 
	        //Line v = ;
	        listOfShapes.add(new Line(a+deltaX+300, 290+deltaY,a+deltaX+300,310+deltaY));	        
	        listOfShapes.add(new TextImage(String.valueOf(beginEpohe+100*j), a+deltaX+300, 280+deltaY ));	
	        System.out.println("beginEpohe="+beginEpohe+" beginEpohe+100*j="+(beginEpohe+100*j)+" a="+a+" x="+(a+deltaX)+" y="+(280+deltaY));
        }
        int i=0;
        for (Person p : data) {	        	
        	int nowDay = p.getEnd();
        	if (nowDay==0) {nowDay=year;}
        	        	
        	int x = 300+deltaX;
        	int y = 300+deltaY;
        	
        	int radius = proportia*(p.getBegin()-beginEpohe); //
        	        	
        	double startAngle = 0 + (endEpohe - nowDay)*(Math.PI/180); //
        	double endAngle = startAngle+((nowDay - p.getBegin())*(Math.PI/180));
        	if(nowDay - p.getBegin() == 0) {endAngle = startAngle+(1*(Math.PI/180));}
        	        	
        	ArcFamily arc = new ArcFamily(x,y,radius,startAngle,endAngle,false,p.getColor());
        	
        	listOfShapes.add(arc);  
        	
        	//listOfShapes.add(new Line(300+deltaX,300+deltaY,
     		//		(300+deltaX+(radius)* Math.cos((p.getBegin()-endEpohe)*(Math.PI/180))),
     		//		(300+deltaY-(radius)* Math.sin((p.getBegin()-endEpohe)*(Math.PI/180)))));
        	 
        	 listOfShapes.add(new TextImage(String.valueOf(p.getBegin()),
        			 (300+deltaX+(radius)* Math.cos((p.getBegin()-endEpohe)*(Math.PI/180))), 
        			 (300+deltaY-(radius)* Math.sin((p.getBegin()-endEpohe)*(Math.PI/180)))));	
        	 
        	 
        	String nameEnd= String.valueOf(nowDay);
        	if (nowDay==(new Date().getYear()+ 1900)) {nameEnd = "";}
        	//TextImage textBegin = new TextImage(String.valueOf(p.getBegin()), x-20, y );
        	//TextImage textEnd = new TextImage(nameEnd, (width+x), ( y) );
        	//TextImage textName = new TextImage(String.valueOf(p.getName()), (x+10), ( y+15) );	        	
        	
        	//listOfShapes.add(textBegin);
        	//listOfShapes.add(textEnd);
        	//listOfShapes.add(textName);
        	i++;
        }   
		
		return listOfShapes;
	}
}
