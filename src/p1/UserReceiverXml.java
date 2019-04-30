package p1;

import java.util.ArrayList; 
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.*;


public class UserReceiverXml { 
	static String str = "" ;
   public List<Employee> getAllUsers(){ 
      
      List<Employee> userList = null; 
      try { 
    	   	  
    	  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	 
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          String ss="", str="";
          
//         
//          StringBuilder sbr = new StringBuilder();
          str = FileDetails.getContent();
          InputStream is = new ByteArrayInputStream(str.getBytes());
          Document doc = dBuilder.parse(is);
          doc.getDocumentElement().normalize();
          System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
          NodeList nList = doc.getElementsByTagName("emp");
          System.out.println("----------------------------");
          userList = new ArrayList<Employee>(); 
          
          Db database = new Db();          
          for (int temp = 1; temp < nList.getLength(); temp++) {
             Node nNode = nList.item(temp);
             
             if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 String name =  eElement.getElementsByTagName("name").item(0).getTextContent();
                 String sal = eElement.getElementsByTagName("salary").item(0).getTextContent();
                 String empid = eElement.getAttribute("empid");
                 
                  database.addTodb(empid, name, sal);
                  
   	              Employee emp = new Employee(empid, name, sal); 
   	              
   	              userList.add(emp); 
   	              
                 
              }
           }
          saveUserList(userList);
          database.closeCon();
             

         
      } catch (IOException e) { 
         e.printStackTrace(); 
      }  catch(Exception e){
    	 e.printStackTrace();
      }
      return userList; 
   } 
   private void saveUserList(List<Employee> userList){ 
      try { 
         File file = new File("C:/Users/768980/Desktop/JavaBack/Emp111.dat"); 
         FileOutputStream fos;  
         fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(userList); 
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }
  public void sendFile(String stt){
	  str = stt;
//	  return str;
  }
}