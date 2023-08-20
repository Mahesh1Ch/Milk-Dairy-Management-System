package com.management.thisdeo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import com.management.bean.Servlatbeanuser;

public class Userdeo {

	String  selectuserlist  = "SELECT *   FROM USERLIST WHERE USERID=?;";
	String selectalluser = "SELECT* FROM USERLIST;";
	
	
	String  insertuserlist   = "INSERT INTO USERLIST VALUES (?,?,?,?,?,?);";
	
	String  edituserlist     = "UPDATE USERLIST SET NAME=?,DATE=?,PHONE=?,LOCATION=?,STATE=? WHERE USERID = ?;";
	String  deleteuserlist      = "DELETE FROM USERLIST WHERE USERID = ?;";

	
	private Connection getConnection()  throws  SQLException{		
	Connection  con =null;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		System.out.println(e);
		
	}
	
	  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DAIRY_MANAGEMENT","root","Mahesh88");
		
	   return con;
	}
	public void  getUpdatebeam(String id,Servlatbeanuser  servlatbean1) {
		try(Connection  con  =getConnection();PreparedStatement pt = con.prepareStatement(edituserlist)){
			//pt.setString(1,  servlatbean1.getUserid());
			pt.setString(1,servlatbean1.getUsername());
			pt.setString(2, servlatbean1.getJoindate());
			pt.setLong(3,servlatbean1.getPhoneno());
			pt.setString(4, servlatbean1.getUserrlocation());
			pt.setString(5,servlatbean1.getUserstate());
			pt.setString(6, id);
			pt.executeUpdate();

		}catch(SQLException e) {
			System.out.println(e);
			
		}
	}
	public  void deleteUserdeo(Servlatbeanuser deleteuser) throws SQLException {
		try(Connection  con  =getConnection();PreparedStatement pt = con.prepareStatement(deleteuserlist)){
			pt.setString(1, deleteuser.getUserid());
			pt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
			
		}
	}
	public Servlatbeanuser  getUserbeam(String id) {
		Servlatbeanuser userdeoTcont = null;
		try(Connection con = getConnection()){
			PreparedStatement pt = con.prepareStatement(selectuserlist);
			pt.setString(1, id);
			ResultSet rt =pt.executeQuery();
			while(rt.next()) {
				   String userid =rt.getString("USERID");
				   String username=rt.getString("NAME");
				   String userjoindate=rt.getString("DATE");
				   long userphoneno  = Long.parseLong(rt.getString("PHONE"));
				   String  userlocation = rt.getString("LOCATION");
				   String  userState = rt.getString("STATE");
				   userdeoTcont = new  Servlatbeanuser(userid, username, userphoneno, userjoindate, userlocation, userState);
		
			}
			
		}catch(SQLException e1){
			System.out.println(e1);
			
		}
		
		
	return userdeoTcont;
		
}
	
	public    void  insertuser(Servlatbeanuser  servlatbean) {
		
		try(Connection  con  =getConnection();PreparedStatement pt = con.prepareStatement(insertuserlist)){
			pt.setString(1,  servlatbean.getUserid());
			pt.setString(2,servlatbean.getUsername());
			pt.setString(3, servlatbean.getJoindate());
			pt.setLong(4,servlatbean.getPhoneno());
			pt.setString(5, servlatbean.getUserrlocation());
			pt.setString(6,servlatbean.getUserstate());
			pt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}	
	public ArrayList<Servlatbeanuser> getAlluser(){
		ArrayList<Servlatbeanuser> arrayuser =  new ArrayList<>();
		try(Connection con = getConnection();
			PreparedStatement pt =con.prepareStatement(selectalluser)){
			
		ResultSet rt = pt.executeQuery();
		while(rt.next()) {
			System.out.println("user :");
			 String id1 =rt.getString("USERID");
			// System.out.println("user :"+id1);
			   String username1=rt.getString("NAME");
			   String  userjoindate1=rt.getString("DATE");
			   long userphoneno1  = Long.parseLong(rt.getString("PHONE"));
			   String  userlocation1 = rt.getString("LOCATION");
			   String  userState1 = rt.getString("STATE");
			  // userdeoTcont = new  Servlatbeanuser();
			    arrayuser.add(new Servlatbeanuser(id1,username1,userphoneno1,userjoindate1,userlocation1,userState1));
			
		}
		}catch(SQLException e) {
			System.out.println(e);
			
		}
		return arrayuser;
	}
}
