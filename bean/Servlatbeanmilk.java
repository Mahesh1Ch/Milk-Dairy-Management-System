package com.management.bean;

public class Servlatbeanmilk {
private String milkdate,milkype,userid;
private  int milklno;
private float milkqty,milkfat,milkamount;

public Servlatbeanmilk(String milkdate, String milkype, int milklno, float milkqty, float milkfat, float milkamount) {
	this.milkdate = milkdate;
	this.milkype = milkype;
	this.milklno = milklno;
	this.milkqty = milkqty;
	this.milkfat = milkfat;
	this.milkamount = milkamount;
}

public Servlatbeanmilk(String milkdate, String milkype, int milklno, float milkqty, float milkfat, float milkamount, String userid) {
	this.milkdate = milkdate;
	this.milkype = milkype;
	this.userid = userid;
	this.milklno = milklno;
	this.milkqty = milkqty;
	this.milkfat = milkfat;
	this.milkamount = milkamount;
	//System.out.println("milkID ,,,,,,,,"+milklno+"MIKKTYPE"+milkype+"milkdate"+milkdate);
}


public Servlatbeanmilk(String milkdate, String milkype, String userid, float milkqty, float milkfat, float milkamount) {
	this.milkdate = milkdate;
	this.milkype = milkype;
	this.userid = userid;
	this.milkqty = milkqty;
	this.milkfat = milkfat;
	this.milkamount = milkamount;
}

public String getUserid() {
	return userid;
}



public void setUserid(String userid) {
	this.userid = userid;
}


public String getMilkdate() {
	return milkdate;
}
public void setMilkdate(String milkdate) {
	this.milkdate = milkdate;
}
public String getMilkype() {
	return milkype;
}
public void setMilkype(String milkype) {
	this.milkype = milkype;
}
public int getMilklno() {
	return milklno;
}
public void setMilklno(int milklno) {
	this.milklno = milklno;
}
public float getMilkqty() {
	return milkqty;
}
public void setMilkqty(float milkqty) {
	this.milkqty = milkqty;
}
public float getMilkfat() {
	return milkfat;
}
public void setMilkfat(float milkfat) {
	this.milkfat = milkfat;
}
public float getMilkamount() {
	return milkamount;
}
public void setMilkamount(float milkamount) {
	this.milkamount = milkamount;
}
}
