package p1;
import java.io.*;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserReceiverJson {
		String line = null;
		JSONObject jsonObject;
    	JSONParser parser = new JSONParser();
    	String a= "";
	public List<Employee> getAllUsers(){ 
	      
	      List<Employee> userList = new ArrayList<Employee>(); 
	      try {
	 		 
	  		String name="", salary="", empid="";
	  		String str = FileDetails.getContent(); 
			Db database=new Db();
			Object obj = parser.parse(str);
           	jsonObject = (JSONObject) obj;
           	JSONArray employees=(JSONArray) jsonObject.get("employee");
           	Iterator i= employees.iterator();
           	while(i.hasNext()) {
           		Iterator<Map.Entry> itr1 = ((Map) i.next()).entrySet().iterator(); 
    			while (itr1.hasNext()) { 
        		Map.Entry pair = itr1.next(); 
       			System.out.println(pair.getKey() + " : " + pair.getValue()+" "); 
       			a= a + (String)pair.getValue()+":"; 
    			}
    			System.out.println(a);
    			String words[]= a.split(":");
    			for(int j=0;j<words.length;j++)
    			{
    				System.out.println("from for  "+words[j]);
    			}
    			salary=words[0];
    			empid=words[1];
    			name=words[2];
    			System.out.print(name+" "+empid+" "+salary);
    			database.addTodb(empid, name, salary);
       			Employee emp = new Employee(empid, name, salary);
       			userList.add(emp);
       			a="";
           	}
	           
	         saveUserList(userList);
	             
	              
	      }
	        catch(Exception e){
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
	 
}


