package com.management.thisdeo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.*;

import javax.security.auth.callback.LanguageCallback;

import com.management.bean.Servlatadmin;

public class Admindeo {

String  selectadminlistBynub =      "SELECT* FROM ADMINLIST WHERE PHONENO=?;";
String  selectadminlistByadminid =  "SELECT* FROM ADMINLIST WHERE ADMINID=?;";
private Connection getConnection()  throws  SQLException{
	Connection  con =null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		System.out.println("jdbcDriver"+e);
		
	}
	
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DAIRY_MANAGEMENT","root","Mahesh88");
		
	   return con;
	}

public Servlatadmin loginvafyNub(long number) throws SQLException {

	Servlatadmin seradmin= null;
	try(Connection con = getConnection()){
		//System.out.println("connection");
PreparedStatement  ps = con.prepareStatement(selectadminlistBynub);
//System.out.println("peparedstamrnt");
ps.setLong(1,number);
System.out.println("ps.setString");
//ps.setLong(2, number);
ResultSet it =  ps.executeQuery();
System.out.println("executeQuery");
while(it.next()) {
	System.out.println("WHILE");
	String adminid = it.getString("ADMINID");
	System.out.println("Adminid is "+adminid);
	long  phoneno = it.getLong("PHONENO");
	String  name=it.getString("ANAME");
	String password=it.getString("PASSWORD");
	seradmin =new Servlatadmin();
	seradmin.setAdminid(adminid);
	seradmin.setNumber(phoneno);
	seradmin.setName(name);
	seradmin.setPassword(password);
}
	}
	catch(SQLException e) {
		System.out.println("NumberSQL"+e);
	}
	return seradmin;
	
}




public Servlatadmin loginvafyStr(String string) throws SQLException {
	Servlatadmin seradmin= null;
	try(Connection con = getConnection()){
PreparedStatement  ps = con.prepareStatement(selectadminlistByadminid);
System.out.println(string);
ps.setString(1,string);
System.out.println(string);
//ps.setLong(2,Long.parseLong(number));

ResultSet it =  ps.executeQuery();
while(it.next()) {
	String adminid = it.getString("ADMINID");
	long  phoneno = it.getLong("PHONENO");
	String  name=it.getString("ANAME");
	String password=it.getString("PASSWORD");
	seradmin =new Servlatadmin();
	seradmin.setAdminid(adminid);
	seradmin.setNumber(phoneno);
	seradmin.setName(name);
	seradmin.setPassword(password);
	
}

	}
	catch(SQLException e1) {
		System.out.println(e1);
	}
	
return seradmin;
	
}

}
