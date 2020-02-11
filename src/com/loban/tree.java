package com.loban;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testdrawing.shapes.images.FamilyList;
import testdrawing.shapes.model.Line;
import testdrawing.shapes.model.Rectangle;
import testdrawing.shapes.model.TextImage;

/**
 * Servlet implementation class tree
 */
@WebServlet(value="/tree")					//  localhost:8080/testweb/tree
public class tree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FamilyList familyList;

    /**
     * Default constructor. 
     */
    public tree() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		String firstParam = request.getParameter("firstParametr");
		String secondParam = request.getParameter("nameFile");
		
		response.getWriter().println(secondParam);
		response.getWriter().println("<br/>");
		
		// darwing to page
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		familyList = new FamilyList("/home/loban/Projects/LDAP/projectSpase/testweb/resource/dataFileExample.csv");
		//familyList.drawLine();    
				
		String canvas = "<canvas id=\"canvas\" width=\"1500\" height=\"1000\"\n" + 
				"            style=\"background-color:#fff; border:1px solid #ccc;\">\n" + 
				"            Ваш браузер не поддерживает Canvas\n" + 
				"    </canvas>";		

		response.getWriter().println(canvas);
		String script = "<script type=\"text/javascript\">";
		response.getWriter().println(script);
		
		String varString = "var canvas = document.getElementById('canvas');\n" + 
				"  			if (canvas.getContext) {\n" + 
				"   				var ctx = canvas.getContext('2d');";
		response.getWriter().println(varString);
		
		
		for( Object s : familyList.listOfShapes()) { //массив фигур для рисования
			System.out.println( s.getClass() );
			
			if (s instanceof Line) {
				Line l = (Line) s;
				//System.out.println( l.getClass() );				
				response.getWriter().println("ctx.beginPath();");
				response.getWriter().println("ctx.strokeStyle = \"GREY\";");
				response.getWriter().println("ctx.lineWidth = \"2\";");
				response.getWriter().println("ctx.moveTo("+l.getX1()+", "+l.getY1()+");");
				//response.getWriter().println("ctx.arc(240, 90, 50, 0, Math.PI/2, true);");
				response.getWriter().println("ctx.lineTo("+l.getX2()+", "+l.getY2()+");");
				response.getWriter().println("ctx.closePath();");
				response.getWriter().println("ctx.stroke();");				
			}
			if (s instanceof Rectangle) {
				Rectangle rectangle=(Rectangle) s;		
				//System.out.println( rectangle.getClass() );
				response.getWriter().println("ctx.beginPath();");				
				response.getWriter().println("ctx.moveTo("+rectangle.getX()+", "+rectangle.getY()+");");
				response.getWriter().println("ctx.strokeStyle = \""+rectangle.getColor()+"\";");
				
				//response.getWriter().println("ctx.arc(240, 90, 50, 0, Math.PI/2, true);");
				response.getWriter().println("ctx.lineWidth = \"5\";");
				response.getWriter().println("ctx.rect("+rectangle.getX()+", "+rectangle.getY()+","+rectangle.getWidth()+","+rectangle.getHeight()+");");
				response.getWriter().println("ctx.closePath();");
				response.getWriter().println("ctx.stroke();");				
			}
			if (s instanceof TextImage) {			
				TextImage t = (TextImage) s;
				response.getWriter().println("ctx.strokeStyle = \"BLACK\";");
				response.getWriter().println("ctx.font = \"10px Georgia\";");				
				response.getWriter().println("ctx.fillText(\""+t.getName()+"\", "+t.getX()+", "+t.getY()+");");
				//response.getWriter().println("ctx.stroke();");		
			}
		}
		
		
		varString ="}";
		response.getWriter().println(varString);
		script = "</script>";
		response.getWriter().println(script);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
