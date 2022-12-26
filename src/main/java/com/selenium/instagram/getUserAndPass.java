package com.selenium.instagram;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class getUserAndPass {
	String values[] = new String[2];
	public String[] giveUserNameAndPassword(String value) throws IOException {
		
		FileReader reader=new FileReader(value);  
	      
	    Properties p=new Properties();  
	    p.load(reader);  
	    values[0]=p.getProperty("user");	
	    values[1]=p.getProperty("password");
		return values;
	}
}
