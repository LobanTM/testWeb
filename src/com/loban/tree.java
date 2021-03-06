package com.loban;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import testdrawing.shapes.images.FamilyList;
import testdrawing.shapes.images.FamilyListArc;
import testdrawing.shapes.model.ArcFamily;
import testdrawing.shapes.model.Line;
import testdrawing.shapes.model.Person;
import testdrawing.shapes.model.Rectangle;
import testdrawing.shapes.model.TextImage;

/**
 * Servlet implementation class tree
 */
@WebServlet(value="/tree")					//  localhost:8080/testweb/tree
@MultipartConfig(fileSizeThreshold = 1024*1024,
						maxFileSize = 1024*1024*5,
						maxRequestSize = 1024*1024*5*5)
public class tree extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FamilyList familyList;
	private FamilyListArc familyListArc;

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
		
		int wightDiv = 1500; 
		int heigthDiv = 1000;	
		
		String typeForm = request.getParameter("share");
		
		String firstParam = request.getParameter("firstParametr");				
		//папка для загрузки на сервер по умолчанию установлена:
		String uploadPath = getServletContext().getRealPath("") + "server";
		//System.out.println(uploadPath);		
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) uploadDir.mkdir();		
		//извлечь наш входящий File из request с помощью метода getParts () и сохранить его на диск
		Part part=request.getPart("fileData");
		String fileName = part.getSubmittedFileName(); //Для сервлетов 3.1.
		part.write(uploadPath + File.separator + fileName);
		System.out.println(uploadPath+ File.separator + fileName);	   
		String nameFile = uploadPath+ File.separator + fileName;
		
		InputStream inputStream = part.getInputStream();
		//===test=====
		//String data = "1;name1;1950;2000;;green;\n2;name2;1960;2020;;red;\n2;name2;1960;2020;;red;\n2;name2;1960;2020;;red;";		
		//inputStream = new ByteArrayInputStream(data.toString().getBytes());	
		List<Object> list = new ArrayList<Object>();
		if (typeForm.indexOf("rec")>-1) {
			familyList = new FamilyList(inputStream);//"/home/loban/Projects/LDAP/projectSpase/testweb/resource/dataFileExample.csv");//			
			list = familyList.getListOfShapes();//массив фигур для рисования
			heigthDiv = 50 + 30 * familyList.getCountPersons();
		}
		
		if (typeForm.indexOf("arc")>-1) {
			familyListArc = new FamilyListArc(inputStream);
			list = familyListArc.getListOfShapes();//массив фигур для рисования
			heigthDiv = 50 + 80 * familyListArc.getCountPersons();		
		}
		
		System.out.println("%%% "+ familyListArc.getCountPersons());
		System.out.println("%%% "+ heigthDiv);
		
		response.setContentType("text/html; charset=utf-8");
		//=================================================================
		String header = "<!DOCTYPE HTML>\n" + 
				"<html>\n" + 
				" <head>\n" + 
				"  <meta charset=\"utf-8\">\n" + 
				"  <title>Тег DIV</title>\n" + 
				"  <style type=\"text/css\">\n" + 
				"   .block1 { \n" + 
				"    width: 300px; \n" + 
				"    background: #ccc;\n" + 
				"    padding: 5px;\n" + 
				"    padding-right: 20px; \n" + 
				"    border: solid 1px black; \n" + 
				"    float: left;\n" + 
				"   }\n" + 
				"   .block2 { \n" + 
				"    width: "+wightDiv+"px; \n" + 
				"    background: #fff; \n" + 
				"    padding: 10px; \n" + 
				"    border: solid 1px black; \n" + 
				"    float: left; \n" + 
				"    position: relative; \n" + 
				"    top: 5px; \n" + 
				"    left: 0px; \n" + 
				"   }\n" + 
				"  </style> \n" + 
				" </head>\n" + 
				" <body>";	
				
		String div1 = "<div class=\"block1\">";		
		
		String form ="<form action = \"tree\"  method=\"post\" upload=\"true\" enctype=\"multipart/form-data\">\n" + 
				"		param1 <input type=\"file\" name=\"fileData\" id=\"input\" value=\"\">\n" + "<br/>\n" + 
						"		<input type=\"radio\" name=\"share\" value=\"rec\"> прямокутник\n" + 
						"		<input type=\"radio\" name=\"share\" value=\"arc\" checked> коло\n" + 								
				"		<input type=\"submit\" value=\"SEND\">\n" + 
				"	</form>	";	
		String div1End = "</div>";
		
		String div2 = "<div class=\"block2\">";
		String canvas = "<canvas id=\"canvas\" width=\""+wightDiv+"\" height=\""+heigthDiv+"\"\n" + 
				"            style=\"background-color:#fff; border:1px solid #ccc;\">\n" + 
				"            Ваш браузер не поддерживает Canvas\n" + 
				"    </canvas>";
		String script = "<script type=\"text/javascript\">";
		String varString = "var canvas = document.getElementById('canvas');\n" + 
				"  			if (canvas.getContext) {\n" + 
				"   				var ctx = canvas.getContext('2d');";
		
		String varStringEnd ="}";
		String scriptEnd = "</script>";
		String div2End = "</div>";
		String footer = " </body>\n" + 
				"</html>";
		//=================================================================
		response.getWriter().println(header);
		response.getWriter().println(div1);
		//response.getWriter().println("<a href=\"/testweb\">back</a>");
		//response.getWriter().println("<br/>");
		response.getWriter().println(fileName);		
		response.getWriter().println("<br/>");
		response.getWriter().println("<br/>");
		
		response.getWriter().println(form);
		
		response.getWriter().println(div1End);
		
		// darwing to page		
		response.getWriter().println(div2);
		response.getWriter().println(canvas);		
		response.getWriter().println(script);		
		response.getWriter().println(varString);		
		
			
		for( Object s : list) { 
			System.out.println( s.getClass() );
			
			if (s instanceof Line) {
				Line l = (Line) s;
				//System.out.println( l.getClass() );				
				response.getWriter().println("ctx.beginPath();");
				response.getWriter().println("ctx.strokeStyle = \"GREY\";");
				response.getWriter().println("ctx.lineWidth = \"2\";");
				response.getWriter().println("ctx.moveTo("+l.getX1()+", "+l.getY1()+");");				
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
			if (s instanceof ArcFamily) {			
				ArcFamily arc = (ArcFamily) s;
				response.getWriter().println("ctx.strokeStyle = \""+arc.getColor()+"\";");
				//response.getWriter().println("ctx.strokeStyle = \"rgb("+(arc.getRadius()-150)+","+(arc.getRadius()-200)+",100)\";");
				response.getWriter().println("ctx.beginPath();");
				//System.out.println( "x="+arc.getX()+" y="+arc.getY()+" radius="+arc.getRadius()+" start="+arc.getStartAngle()+" end="+arc.getEndAngle());
				response.getWriter().println("ctx.arc("+(arc.getX()+0)+", "+(arc.getY()+0)+","			//центр
													+ arc.getRadius()+"," 				//радиус
													+ arc.getStartAngle()+","+arc.getEndAngle()+", "		//начало и конец дуги в радианах
													+ "false);"); //true - против часовой стрелки
				response.getWriter().println("ctx.stroke();");
			}
			
		}	
		/*
		response.getWriter().println("ctx.strokeStyle = \"rgb(255,165,0)\";"); //#FFA500 //способьі задания цвета
		response.getWriter().println("ctx.setLineDash([5,7]);");	//пунктир
		response.getWriter().println("ctx.beginPath();");	
		response.getWriter().println("ctx.arc(300, 300,"			//центр
											+ " 100," 				//радиус
											+ " (-10*Math.PI/180), Math.PI/2, "		//начало и конец дуги в радианах
											+ "false);"); //true - против часовой стрелки
		response.getWriter().println("ctx.stroke();");
		*/
		response.getWriter().println(varStringEnd);		
		response.getWriter().println(scriptEnd);		
		response.getWriter().println(div2End);		
		response.getWriter().println(footer);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
