package com.reader.Reader;

//STEP 1. Import required packages
import java.sql.*;
import java.util.Random;

//import javax.sql.DataSource;
//import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class dbAccess {
 // JDBC driver name and database URL
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
 static final String DB_URL = "jdbc:mysql://localhost/story_db";

 //  Database credentials
 static final String USER = "root";
 static final String PASS = "hotpie321";
 String url = "www.google.com";
 public static void main(String[] args) {}
 public String getLink(){
 Connection conn = null;
 Statement stmt = null;
 try{
    //STEP 2: Register JDBC driver
    Class.forName("com.mysql.jdbc.Driver");

    //STEP 3: Open a connection
    System.out.println("Connecting to database...");
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    
    Random randomGenerator = new Random();
    int num = randomGenerator.nextInt(55)+1;
    stmt=conn.createStatement();
    String sql = "SELECT url FROM stories WHERE sno =" + num;
    
    System.out.println("\n\n\n FETCHING RESULT SET \n\n\n");
    
    ResultSet rs = stmt.executeQuery(sql);
    rs.next();
    
    
    
    url = rs.getString("url");
    System.out.println("\n\n\n RESULT SET IS : \n\n\n" + url);
    
    
   /* //STEP 4: Execute a query
    System.out.println("Creating database...");
    stmt = conn.createStatement();
    
    String sql = "CREATE DATABASE STUDENTS";
    stmt.executeUpdate(sql);
    System.out.println("Database created successfully...");*/
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
    url="www.google.com";
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
    url="www.google.com";
 }finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          stmt.close();
    }catch(SQLException se2){ url="www.google.com";
    }// nothing we can do
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){ url="www.google.com";
       se.printStackTrace();
    }//end finally try
 }//end try
 return url;
 //System.out.println("Goodbye!");
}//end main
}//end JDBCExample
