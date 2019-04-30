package p1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {
	
	public DomParser(){
		
		try {
	         File inputFile = new File("C:/Users/768980/Desktop/JavaBack/dataXml.xml");
	         
	         BufferedWriter writer = new BufferedWriter(
	                 new FileWriter("C:/Users/768980/Desktop/JavaBack/xmltotext.txt", true)  //Set true for append mode
	             );
	         
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("emp");
	         System.out.println("----------------------------");
	         
	         for (int temp = 1; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               String name =  eElement.getElementsByTagName("name").item(0).getTextContent();
	               String sal = eElement.getElementsByTagName("salary").item(0).getTextContent();
	               String empid = eElement.getAttribute("empid");
	               String res = name + " " + sal + " " + empid;
	               writer.write(res);
	               writer.newLine();
	               
	            }
	         }
	         writer.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

}
