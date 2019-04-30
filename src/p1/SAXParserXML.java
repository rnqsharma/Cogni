package p1;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;



public class SAXParserXML {
	
	public SAXParserXML(){
		 try {
//	         File inputFile = new File("C:/Users/768980/Desktop/JavaBack/xmltotext2.xml");
			 
	         String ss = FileDetails.getContent();
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser saxParser = factory.newSAXParser();
	         UserHandler userhandler = new UserHandler();
	         InputStream is = new ByteArrayInputStream(ss.getBytes());
	         saxParser.parse(is, userhandler);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	public List<Employee> getListSAX(){
		UserHandler oo = new UserHandler();
		return oo.getList();
	}

}
