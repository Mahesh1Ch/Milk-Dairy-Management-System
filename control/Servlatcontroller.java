package com.management.control;

import com.management.bean.Servlatadmin;
import com.management.bean.Servlatbeanmilk;
import com.management.bean.Servlatbeanuser;
import com.management.thisdeo.Admindeo;
import  com.management.thisdeo.Milkdeo;
import com.management.thisdeo.Userdeo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import  javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
@WebServlet("/")
public class Servlatcontroller  extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig  config) {
		
		
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {	
	String action = request.getServletPath();
	switch(action){
		case "/loginadmin" :  loginadmin(request,response);
		break;
		case "/loginuser"  :  try {
			loginuser(request,response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		//USERDETAILS
		case "/edituser"  : edituser(request,response);
		break;
		case "/updateuser"  :updateuser(request,response);
		break;
		case "/deleteuser"  : try {
			deleteuser(request,response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		case "/newuser":      newuser(request,response);
		break;
		case "/insertuser" :  insertuser(request,response);
		break;
		//MILKDETAILS
		case "/milkdetails" : usermilkdetails(request,response);
		break;
		case "/addnewmilk": try {
			addmilksell(request,response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		case "/insertmilk"  : addnewmilk(request,response);
		break;
		case "/editmilk" : try {
			editmilk(request,response);
		} catch (SQLException | ServletException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		break;
		case "/updatemilk":try {
			updatemilk(request,response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		case "/deletemilk" :try {
			deletemilk(request,response);
		} catch (SQLException | ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		default            :  mainpage(request,response);
		break;
	}
	}
	public void deletemilk(HttpServletRequest  request,HttpServletResponse response) throws  SQLException,ServletException,IOException{
		 String userid = request.getParameter("userid");
		 int milklno=Integer.parseInt(request.getParameter("id"));
		System.out.println("userid,,,,,"+userid+"milklno"+milklno);
		Milkdeo   milkcontlTdeo =  new Milkdeo();
		 milkcontlTdeo.deletemilk(userid, milklno);
		// response.sendRedirect("/Milkdairymanagement/milkdetails?usermilkdts="+userid);
		 //response.sendRedirect("/Milkdairymanagement/Mainpage");
		 //response.sendRedirect("Mainpage");
		 //RequestDispatcher  dispacher =   request.getRequestDispatcher("/Mainpage.jsp");
			//dispacher.forward(request, response);
		 Milkdeo  contlTodeo =new Milkdeo();
			ArrayList<Servlatbeanmilk>  milkdeoTocont =contlTodeo.milkdetailslist(userid);
			
			request.setAttribute("milkdeoTocont", milkdeoTocont);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/milklist.jsp");
			dispatcher.forward(request, response);
				 
	}
public void editmilk(HttpServletRequest request,HttpServletResponse response) throws SQLException,ServletException,IOException{
	 String userid =   request.getParameter("userid");
	 int  milklno = Integer.parseInt(request.getParameter("id"));
	 Milkdeo   milkcontlTdeo =  new Milkdeo();
	 Servlatbeanmilk conlTobean=milkcontlTdeo.takeForedit(userid, milklno);
	 	  request.setAttribute("usersell", conlTobean);
	 	  RequestDispatcher dispatcher = request.getRequestDispatcher("/sellmilk.jsp");
dispatcher.forward(request, response);
}
	public void updatemilk(HttpServletRequest request,HttpServletResponse response) throws SQLException ,ServletException,IOException{
		 		int  milkid =Integer.parseInt(request.getParameter("milklno"));
				//System.out.println("milkid,,,,,,,,,,,,,,111111111"+milkid);
				float milkqty =Float.parseFloat(request.getParameter("milkqty"));
				String milktype =request.getParameter("milktype");
				String milkdate =request.getParameter("milkdate");
				float milkfat =Float.parseFloat(request.getParameter("milkfat"));
				float milkamount =Float.parseFloat(request.getParameter("milkamount"));
				String userid =request.getParameter("userid");
				Servlatbeanmilk beanmilk = new Servlatbeanmilk(milkdate,milktype,milkid,milkqty,milkfat,milkamount,userid);
				Milkdeo   milkcontlTdeo =  new Milkdeo();
				milkcontlTdeo.editmilkdetails(beanmilk);
				
				response.sendRedirect("/Milkdairymanagement/milkdetails?usermilkdts="+userid);
				
				
	}
	public void addmilksell(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException{
		
		//response.sendRedirect("/Milkdairymanagement/sellmilk.jsp");
		String userid = request.getParameter("userid");
		request.setAttribute("userid", userid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/sellmilk.jsp");
		dispatcher.forward(request, response);
	}
	public void addnewmilk(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		int  milkid =Integer.parseInt(request.getParameter("milklno"));
		//System.out.println("milkid,,,,,,,,,,,,,,111111111"+milkid);
		float milkqty =Float.parseFloat(request.getParameter("milkqty"));
		String milktype =request.getParameter("milktype");
		String milkdate =request.getParameter("milkdate");
		float milkfat =Float.parseFloat(request.getParameter("milkfat"));
		float milkamount =Float.parseFloat(request.getParameter("milkamount"));
		String userid =request.getParameter("userid");
		//(String milkdate, String milkype, int milklno, float milkqty, float milkfat, float milkamount, String userid) 
		
		Servlatbeanmilk beanmilk = new Servlatbeanmilk(milkdate, milktype, milkid, milkqty, milkfat, milkamount, userid);
		Milkdeo   milkcontlTdeo =  new Milkdeo();
		milkcontlTdeo.insertmilkdetails(beanmilk);
		response.sendRedirect("/Milkdairymanagement/milkdetails?usermilkdts="+userid);
		//request.setAttribute("usermilkdts", userid);
		//usermilkdetails(request,response);
			
	}
	public void usermilkdetails(HttpServletRequest request,HttpServletResponse response) throws ServletException , IOException{
		String usermilkid =request.getParameter("usermilkdts");
		Milkdeo  contlTodeo =new Milkdeo();
		ArrayList<Servlatbeanmilk>  milkdeoTocont =contlTodeo.milkdetailslist(usermilkid);
		
		request.setAttribute("milkdeoTocont", milkdeoTocont);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/milklist.jsp");
		dispatcher.forward(request, response);
	}
	public void newuser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Addnewseller.jsp");
		
		dispatcher.forward(request, response);
	}
	public void insertuser(HttpServletRequest request, HttpServletResponse response)  throws ServletException,IOException{
	
		String useId = request.getParameter("userid");
		String userName =request.getParameter("username");
		String userjoindate=request.getParameter("joindate");
		long  phoneNo = Long.parseLong(request.getParameter("usernumber"));
		String userlocation = request.getParameter("userlocation");
		String userState =  request.getParameter("userState");
		Servlatbeanuser  usercontlTbean= new Servlatbeanuser(useId, userName, phoneNo,userjoindate,userlocation, userState);	
		Userdeo  usedeocontlTdeo = new Userdeo();
		usedeocontlTdeo.insertuser(usercontlTbean);
		response.sendRedirect("/Milkdairymanagement/Mainpage");
	}
	public void  mainpage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher  dispacher =   request.getRequestDispatcher("/Mainpage.jsp");
		dispacher.forward(request, response);
	}
	public void  loginadmin(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher  dispacher =   request.getRequestDispatcher("/login.jsp");
		dispacher.forward(request, response);
	}

	public void edituser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/Addnewseller.jsp");
        String editUid = request.getParameter("id");
        Userdeo  userTdeo =  new  Userdeo();
        //Servlatbeanuser  edituser =  new Servlatbeanuser();
        Servlatbeanuser  edituser=userTdeo.getUserbeam(editUid);
        request.setAttribute("user", edituser);
		dispatcher.forward(request, response);
	}
	public void updateuser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	  String useId = request.getParameter("userid");
		String userName =request.getParameter("username");
		String userjoindate=request.getParameter("joindate");
		long  phoneNo = Long.parseLong(request.getParameter("usernumber"));
		String userlocation = request.getParameter("userlocation");
		String userState =  request.getParameter("userState");
	  Userdeo  userTdeo =  new  Userdeo();
	  Servlatbeanuser  usercontlTbeanedit = new Servlatbeanuser(useId, userName, phoneNo,userjoindate,userlocation, userState);
	userTdeo.getUpdatebeam(useId,usercontlTbeanedit);
	  response.sendRedirect("/Milkdairymanagement/Mainpage");
	  
	}
	public void deleteuser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, SQLException {
	  String userId = request.getParameter("id");
	  Servlatbeanuser deleteuser   = new Servlatbeanuser(userId);
	  Userdeo  userTdeo =  new  Userdeo();
	  userTdeo.deleteUserdeo(deleteuser);
	  response.sendRedirect("/Milkdairymanagement/Mainpage");
	}
public void  loginuser(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException, SQLException{
		
	String numberstr =  request.getParameter("number");
	String password = request.getParameter("password");
	
	Servlatadmin seradmin1 = new Servlatadmin();
	
	
	
	
	/*//if(Pattern.matches("[0-9]{10}",numberstr)) {
		long number =Long.parseLong(numberstr);
	//System.out.println("Number is "+number);
		 
		admin = new Admindeo();
		Servlatadmin seradmin =admin.loginvafy( number);
		long phoneFdeo=seradmin.getNumber();
		System.out.println("Number is "+phoneFdeo);
		//String adminidFdeo=seradmin.getAdminid();
		//String nameFdeo=seradmin.getName();
		String passwordFdeo=seradmin.getPassword();
		//if(number==phoneFdeo&&password.equals(passwordFdeo)) {
			RequestDispatcher  dispacher =   request.getRequestDispatcher("/adminlist.jsp");
			request.setAttribute("admininfo", seradmin);
			dispacher.forward(request, response);
		/*}
	}
	else {*/
       String	number =numberstr;
      // seradmin1.setAdminid(number);
		
       Admindeo admin = new Admindeo();
		Servlatadmin seradmin =admin.loginvafyStr( number);
		//long phoneFdeo=seradmin.getNumber();
		String adminidFdeo=seradmin.getAdminid();
		
		//String nameFdeo=seradmin.getName();
		String passwordFdeo=seradmin.getPassword();
		Userdeo userdeoTocont = new Userdeo();

		ArrayList<Servlatbeanuser>  userbeanTcont = userdeoTocont.getAlluser();
		//Iterator itr =userbeanTcont.iterator();
		//while(itr.hasNext()) {
		//	System.out.println("itr  "+itr.next());
		//}
		System.out.println("userbeanTcont"+userbeanTcont);
      if(number.equals(adminidFdeo)  &&  password.equals(passwordFdeo)) {
    	  request.setAttribute("userbeanTcont", userbeanTcont);
    	  RequestDispatcher dispatcher = request.getRequestDispatcher("adminlist.jsp");
			//request.setAttribute("admininfo", seradmin);
			
			dispatcher.forward(request, response);
       }

		
//	}
	
	
	
}
	
protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {	
doGet(request,response);
}
}
