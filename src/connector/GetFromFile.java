package connector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import testdrawing.shapes.model.Person;


public class GetFromFile {
	
	private String nameFile = "/home/loban/Projects/LDAP/projectSpase/testweb/resource/dataFile.csv";
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<Person> getData() throws IOException {
		List<Person> data = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";
	
		Person p;
		
		//FileInputStream fstream = new FileInputStream(nameFile);
		//InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		//BufferedReader reader = new BufferedReader(inputStreamReader);
		br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
		while ((line = br.readLine()) != null) {
			System.out.println(line);
			p = new Person(line.split(cvsSplitBy)[2],line.split(cvsSplitBy)[3],line.split(cvsSplitBy)[1],line.split(cvsSplitBy)[5]);
			data.add(p);
		}
	
		return data;
	}

	public GetFromFile() {
		super();
	}
	
	public GetFromFile(String nameFile) {
		super();
		this.nameFile = nameFile;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	
}
