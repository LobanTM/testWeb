package testweb;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import testdrawing.shapes.images.FamilyList;
import testdrawing.shapes.model.Person;

class PersonTest {

	private Person person;
	private FamilyList familyList;		
	
	@Test
	void getBeginTest() throws IOException {
		String data = "1;name1;1950;2000;;green;\n2;name2;1960;2020;;red;";		
		InputStream inputStream = new ByteArrayInputStream(data.getBytes());		
		
		familyList = new FamilyList(inputStream);	
		
		assertEquals(familyList.getData().get(0).getBegin(), 1950);
	}

}
