package p1;

import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;
 
@Path("/UserService") 

public class UserService {  
   UserReceiverXml userDao = new UserReceiverXml();
   UserReceiverRest userDaocsv = new UserReceiverRest();
   UserReceiverJson userDaoJson= new UserReceiverJson();
   UDPReceiver2 u1 = new UDPReceiver2();

   UserReceiverRest userDaoCsv = new UserReceiverRest();
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_JSON)
   public void getUsers(){

	   int c =0;
	   while(true)
	   {
		   u1.writeFunc();
		   System.out.println("Returned");
		   System.out.println("UserService : "+FileDetails.getExtension());
		   if(FileDetails.getExtension().equals(".xml")){
			   long start = System.currentTimeMillis();
			   SAXParserXML obj = new SAXParserXML();
			   long end = System.currentTimeMillis();
			   System.out.println(start-end);

		   }
		   else if(FileDetails.getExtension().equals(".json")){
			   long start = System.currentTimeMillis();
			   userDaoJson.getAllUsers();
			   long end = System.currentTimeMillis();
		   }
		   else{
			   long start = System.currentTimeMillis();
			   	userDaoCsv.getAllUsers();
			   	long end = System.currentTimeMillis();
		   }
		   
		   } 
	   
   }  
}
