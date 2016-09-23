package com.login;

public class LoginDAO {
 public boolean isValidUser(String id,String pwd){
	 if(id.equals("Roopesh1")&&pwd.equals("Mnit1234")){
		 return true;
	 }
	 else
		 return false;
 }
}
