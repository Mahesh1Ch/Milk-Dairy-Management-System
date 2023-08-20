package com.management.thisdeo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.management.bean.Servlatbeanmilk;
import com.management.bean.Servlatbeanuser;

public class Milkdeo {

	String selectusermilklist   = "SELECT *   FROM MILKLIST WHERE USERID = ?;";
	String  insertmilklist  = "insert into milklist(lno,date,milktype,qty,fat,amount,userid) values(?,?,?,?,?,?,?)";
	String editmilklist     = "UPDATE MILKLIST SET DATE=?,MILKTYPE=?,QTY=?,FAT=?,AMOUNT=? WHERE LNO=? && USERID=?;";
	String selectmilk = "SELECT* FROM MILKLIST WHERE LNO=? && USERID = ?;";
	String  deleteuserlist      = "DELETE FROM MILKLIST WHERE LNO=? AND USERID = ?;";

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
	public  void deletemilk(String userid,int  milklno) {
		//"DELETE FROM MILKLIST WHERE LNO = ? AND USER=?;"
		try(Connection con=getConnection();PreparedStatement pt = con.prepareStatement(deleteuserlist)){
			
			pt.setInt(1, milklno);
			pt.setString(2, userid);
			pt.executeUpdate();
		}catch(SQLException e) {
		   System.out.println(e);
		}
		
	}
	public Servlatbeanmilk takeForedit(String userid,int milklno) {
		Servlatbeanmilk deoTocont = null;
		try(Connection con=getConnection();PreparedStatement pt =con.prepareStatement(selectmilk)){
			      pt.setInt(1, milklno);
			      pt.setString(2, userid);
			      //System.out.println("userid,,,,,,,,"+userid+"milklno,,,,,,,"+milklno);
			      ResultSet rt =pt.executeQuery();
			    while(rt.next()) {
			    	
			    	
			    	int milkid=	rt.getInt("LNO");
					//System.out.println("milkid,,,,,,,,,,,"+milkid);
					String milkdate =	rt.getString("DATE");
					String milktype =rt.getString("MILKTYPE");
					float milkqty =rt.getFloat("QTY");
					float milkfat =	rt.getFloat("FAT");
					float milkamount = rt.getFloat("AMOUNT");
					String milkuserid =rt.getString("USERID");
					deoTocont=	new Servlatbeanmilk(milkdate, milktype, milkid, milkqty, milkfat,milkamount,milkuserid);

			    	
			    }
			      
		}catch(SQLException e) {
			System.out.println(e);
		}
		return deoTocont;
		
	}
	public ArrayList<Servlatbeanmilk> milkdetailslist(String userid){
		
		ArrayList<Servlatbeanmilk> milklist = new ArrayList<>();
		try(Connection con = getConnection();PreparedStatement  pt = con.prepareStatement(selectusermilklist)){
			pt.setString(1, userid);
			ResultSet rt = pt.executeQuery();
			while(rt.next()) {
			int milkid=	rt.getInt("LNO");
			//System.out.println("milkid,,,,,,,,,,,"+milkid);
			String milkdate =	rt.getString("DATE");
			String milktype =rt.getString("MILKTYPE");
			float milkqty =rt.getFloat("QTY");
			float milkfat =	rt.getFloat("FAT");
			float milkamount = rt.getFloat("AMOUNT");
			String milkuserid =rt.getString("USERID");
				milklist.add(new Servlatbeanmilk(milkdate, milktype, milkid, milkqty, milkfat,milkamount,milkuserid));
	
			}
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		
		return milklist;
		
	}
	public void insertmilkdetails(Servlatbeanmilk beanmilk) {	
		try(Connection  con = getConnection();PreparedStatement pt =con.prepareStatement(insertmilklist)){
			int  milklno=beanmilk.getMilklno();
			String date = beanmilk.getMilkdate();
			String milktype=beanmilk.getMilkype();
			float milkqty=beanmilk.getMilkqty();
			float milkfat=beanmilk.getMilkfat();
			float milkamount=beanmilk.getMilkamount();
			String userid=beanmilk.getUserid();
			//String userid1=beanmilk.getUserid();
			//System.out.println("date,,,,,,,,,,,"+date+"milktype"+milktype+"milkqty"+milkqty);
		pt.setInt(1, milklno);	
		pt.setString(2,date);
		pt.setString(3,   milktype);
		pt.setFloat(4,milkqty);
		pt.setFloat(5,milkfat);
		pt.setFloat(6,milkamount);
		pt.setString(7,userid);
		//pt.setString(7,userid1);
		
		pt.executeUpdate();
		
	}catch(SQLException e) {
		System.out.println(e);
	}
	}
	public void editmilkdetails(Servlatbeanmilk beanmilk) throws SQLException {
		try(Connection  con = getConnection();PreparedStatement pt =con.prepareStatement(editmilklist)){
			    int milklno=beanmilk.getMilklno();
				String date = beanmilk.getMilkdate();
				String milktype=beanmilk.getMilkype();
				float milkqty=beanmilk.getMilkqty();
				float milkfat=beanmilk.getMilkfat();
				float milkamount=beanmilk.getMilkamount();
				String userid=beanmilk.getUserid();
//"UPDATE MILKLIST SET DATE=?,MILKTYPE=?,QTY=?,FAT=?,AMOUNT=? WHERE LNO=? && USERID=?;";
		 System.out.println("date,,,,"+date+"milktype"+milktype+"milkqty"+milkqty+"milkfat"+milkfat+"milkamount"+milkamount+"milklno"+milklno+"userid"+userid);
				pt.setString(1,date);
				pt.setString(2,milktype);
				pt.setFloat(3,milkqty);
				pt.setFloat(4,milkfat);
				pt.setFloat(5,milkamount);
				pt.setInt(6, milklno);
				pt.setString(7, userid);
				pt.executeUpdate();
	}

}
}