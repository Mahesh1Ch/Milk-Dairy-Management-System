package com.management.bean;

public class Servlatadmin {

private  long  number;
 private  String adminid;
 private String name;
 private String password;
 
 public void setNumber(long  number2)
 { 
	 this.number = number2;
		
 }
 public  long getNumber() {
 
 return number;
 
 }
 public void setAdminid(String adminid) {
	 this.adminid =  adminid;
	 
 }
 public String getAdminid() {
	 
	 return  adminid;
 }
 public void setName(String name) {
	 this.name=name;
 }
 public String getName() {
	 return  name;
 }
 public void setPassword(String pword) {
	 this.password= pword;
 }
 public String getPassword() {
	 return  password;
 }
}
