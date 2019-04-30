package p1;

import java.sql.*;
public class Db {
	
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	String insertSql = "insert into employee values(?,?,?)";
	PreparedStatement preparedStatement ;
	public Db(){
		try{

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","password-1");
			System.out.println(con);
			stmt = con.createStatement();
			//String sql = "CREATE TABLE IF NOT EXISTS EMPLOYEE (empid VARCHAR(255), empname VARCHAR(255),salary VARCHAR(255)) ";
			//rs = stmt.executeQuery(sql);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void addTodb(String id, String name, String salary){
		try{
			preparedStatement = con.prepareStatement(insertSql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, salary);
			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
	public void closeCon(){
		try{
			con.close();
//			preparedStatement.close();
			stmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	
}
