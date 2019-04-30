package p1;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class UserHandler extends DefaultHandler {

   boolean name = false;
   boolean salary = false;
   boolean empid = false;
   Employee ee = new Employee();

   List<Employee> userList = new ArrayList<>();
   @Override
   public void startElement(String uri, String localname, String qname, Attributes attributes) throws SAXException {

      if (qname.equalsIgnoreCase("emp")) {
         String empid = attributes.getValue("empid");
         
         ee.setId(empid);
         if(empid != null){
        	 System.out.println("Empid : " + empid);
         }
      } else if (qname.equalsIgnoreCase("name")) {
         name = true;
      } else if (qname.equalsIgnoreCase("salary")) {
         salary = true;
      } 
   }

   @Override
   public void endElement(String uri, String localname, String qname) throws SAXException {
      if (qname.equalsIgnoreCase("emp")) {
//         System.out.println("End Element :" + qname);
      }
   }

   @Override
   public void characters(char ch[], int start, int length) throws SAXException {
      
      if (name) {
         System.out.println("name: " + new String(ch, start, length));
         name = false;
         ee.setName(new String(ch, start, length));
      } else if (salary) {
         System.out.println("salary " + new String(ch, start, length));
          salary = false;
         ee.setSalary(new String(ch, start, length)); 
      }
      Db db = new Db();
//      db.addTodb(ee.getId(), ee.getName(), ee.getSalary());
      System.out.println("_________________________________________________________________________");
      System.out.println(ee.getId()+ " " +  ee.getName() + " " + ee.getSalary());
      UserHandler hh = new UserHandler();
      Employee ee1 = new Employee(ee.getId(), ee.getName(), ee.getSalary()); 
//    		  hh.empObj(ee.getId(), ee.getName(), ee.getSalary());
      userList.add(ee1);
   }
   
   public Employee empObj(String id, String name, String salary){
	   Employee ee = new Employee(id, name, salary);
	   return ee;
   }
   
   public List<Employee> getList(){
	   System.out.println(userList);
	   return userList;
   }
}