package p1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class UserReceiverRest {
	 public List<Employee> getAllUsers(){ 
	      
	      List<Employee> userList = null; 
	      try { 
//	 		System.out.println("ext....."+FileDetails.getExtension());
	   		 String words = FileDetails.getContent();
	  		 String name="", salary="", empid="";
	  		 String[] subcode=new String[3]; 
	  		 Db database=new Db();  
	          userList = new ArrayList<Employee>();
	          
	          if(FileDetails.getExtension().equals("form"))
	          {
	 					subcode= words.split(",");
	 			  		name = subcode[0];
	 			  		salary = subcode[1];
	 			  		empid = subcode[2];
	 			  		database.addTodb(empid, name, salary);
	 	 			   Employee emp = new Employee(empid, name, salary);
	 	 			  userList.add(emp);
	          }
	          else
	          {
		          	String[] code = words.split("%n");
				   
		 			  	for(int i=0;i<code.length;i++)
		 			  	{
//		 			  		System.out.println("ext....."+FileDeta-ils.getExtension());
		 			  		
		 					subcode= code[i].split(",");
		 			  		name = subcode[0];
		 			  		salary = subcode[1];
		 			  		empid = subcode[2];
	
		
		 	 			  	database.addTodb(empid, name, salary);
		 	 			   Employee emp = new Employee(empid, name, salary);
		 	 			  userList.add(emp);
		 			  	}
	          }
 			  	 
			  
	  		 
	          
	           
	          saveUserList(userList);

	             
	             

	         
	      } catch(Exception e){
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
