package p1;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Employee implements Serializable{
	private static final long serialVersionUID = 1L; 
	   private String id; 
	   private String name; 
	   private String salary;  
	   public Employee(){} 
	    
	   public Employee(String id, String name, String salary){  
	      this.id = id; 
	      this.name = name; 
	      this.salary = salary; 
	   }  
	   public String getId() { 
	      return id; 
	   }  
	   @XmlElement 
	   public void setId(String id) { 
	      this.id = id; 
	   } 
	   public String getName() { 
	      return name; 
	   } 
	   @XmlElement
	   public void setName(String name) { 
	      this.name = name; 
	   } 
	   public String getSalary() { 
	      return salary; 
	   } 
	   @XmlElement 
	   public void setSalary(String salary) { 
	      this.salary = salary; 
	   }   
}
