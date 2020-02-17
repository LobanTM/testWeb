package testdrawing.shapes.tools;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import testdrawing.shapes.model.ArcFamily;
import testdrawing.shapes.model.Circle;
import testdrawing.shapes.model.Line;
import testdrawing.shapes.model.Rectangle;
import testdrawing.shapes.model.TextImage;

public class GraphicsPanel extends JPanel{	
	
	private Object object;	
	private List<Object> shaps;	
	
	private Line line;
	private Rectangle rectangle;
	private Circle circle;

	public GraphicsPanel(Object object) {
		super();		
		this.object = object;
	}

	public GraphicsPanel(List<Object> shaps) {
		super();
		this.shaps = shaps;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		//Object s = object;
		for( Object s : shaps) {
			System.out.println( s.getClass() );
			/*
			switch (s.getClass()) {
			case (Line):
				;
				breack;
			}
			*/
			
			if (s instanceof TextImage) {			
				TextImage t = (TextImage) s;
				g2.setPaint(Color.BLACK);
				g2.setFont(new Font(t.getFont(), Font.PLAIN, t.getHeigthFont()));
				g2.drawString(t.getName(), (int)t.getX(), (int)t.getY());
				System.out.println( "TextImage" );
				System.out.println("x: "+ t.getX()+" / y: "+t.getY());
				
			}
			
			if (s instanceof Line) {			
				line = (Line) s;
				g2.setPaint(Color.GRAY);
				g2.draw(line);
				System.out.println( "Line" );
			}
			if (s instanceof Rectangle) {
				rectangle=(Rectangle) s;				
				g2.setPaint(Color.LIGHT_GRAY);
				g2.fill(rectangle);
				System.out.println( "Rectangle" );
				System.out.println("x: "+ rectangle.getX()+" / y: "+rectangle.getY());
				System.out.println("width: "+ rectangle.getWidth());
			}
			if (s instanceof Circle) {	
				circle = (Circle) s;
				g2.draw(circle);
				System.out.println( "Circle" );
			}
			if (s instanceof Arc2D) {	
				//circle = (Circle) s;
				g2.setPaint(Color.BLUE);
				Arc2D a = (Arc2D)s;
				g2.draw(a);
				System.out.println( "Arc2D" );
				System.out.println("x: "+ a.getX()+" / y: "+a.getY());
				System.out.println("width: "+ a.getWidth());
				System.out.println("start: "+ a.getAngleStart()+" / end: "+a.getAngleExtent());				
			}
			/*if (s instanceof ArcFamily) {	
				//circle = (Circle) s;
				ArcFamily a = (ArcFamily)s;
				g2.setPaint(a.getColor());
				
				g2.draw(a);
				System.out.println( "ArcFamily" );
				System.out.println( a.toString());
				
			}
			*/
		}
		System.out.println( "well done" );
		
		
	}
}
