package testweb;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import testdrawing.shapes.images.FamilyList;

class FamilyListTest {

	private FamilyList familyList;		
	
	@Test
	void getCountPersonsTest() throws IOException {		
		String data = "1;name1;1950;2000;;green;\n2;name2;1960;2020;;red;";		
		InputStream inputStream = new ByteArrayInputStream(data.getBytes());		
		
		familyList = new FamilyList(inputStream);
		//familyList.getListOfShapes();
		
		assertEquals(familyList.getCountPersons(), 2);		
	}
	
	@Test
	void getBeginEpoheTest() throws IOException {		
		String data = "1;name1;550;1000;;green;\n2;name2;1960;2020;;red;";		
		InputStream inputStream = new ByteArrayInputStream(data.getBytes());		
		
		familyList = new FamilyList(inputStream);
		//familyList.getListOfShapes();
		
		assertEquals(familyList.getBeginEpohe(), 500);		
	}

	@Test
	void getDataTest() throws IOException {		
		String data = "1;name1;1950;2000;;green;\n2;name2;1960;2020;;red;";		
		InputStream inputStream = new ByteArrayInputStream(data.getBytes());		
		
		familyList = new FamilyList(inputStream);
		//familyList.getListOfShapes();
		
		assertEquals(familyList.getData().size(), 2);		
	}
	
	@Test
	void getListOfShapesTest() throws IOException {		
		String data = "1;name1;1950;2000;;green;\n2;name2;1960;2020;;red;";		
		InputStream inputStream = new ByteArrayInputStream(data.getBytes());		
		
		familyList = new FamilyList(inputStream);
		//familyList.getListOfShapes();
		
		assertEquals(familyList.getListOfShapes().size(), 11);			
	}
}
