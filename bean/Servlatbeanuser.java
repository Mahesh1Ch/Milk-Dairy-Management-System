package com.management.bean;

public class Servlatbeanuser {
	 
	      private String userid,username,joindate,userrlocation,userstate;
	      private long phoneno;
	      public Servlatbeanuser(String userid) {
	    	  this.userid = userid;
	      }
	      public Servlatbeanuser(String userid ,String username,long phoneno,String  joindate ,String userrlocation,String userstate) {
	    	 this.userid = userid;
	    	// System.out.println("userid,,,,,,,,,,,,,,,,,,,,, "+userid);
	    	 this.username=username;
	    	 this.phoneno=phoneno;
	    	 this.joindate = joindate;
	    	  this.userrlocation = userrlocation;
	    	  this.userstate = userstate;
	      }
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getJoindate() {
			return joindate;
		}
		public void setJoindate(String joindate) {
			this.joindate = joindate;
		}
		public String getUserrlocation() {
			return userrlocation;
		}
		public void setUserrlocation(String userrlocation) {
			this.userrlocation = userrlocation;
		}
		public String getUserstate() {
			return userstate;
		}
		public void setUserstate(String userstate) {
			this.userstate = userstate;
		}
		public long getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(long phoneno) {
			this.phoneno = phoneno;
		}
	      
}
