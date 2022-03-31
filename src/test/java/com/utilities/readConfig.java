package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	public readConfig() {
		
		File src = new File("./Configuration//config.properties");//
		//C:\Users\Aniket\eclipse-workspace\Project2022\Configuration\config.properties
		try {
			FileInputStream fis= new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch (Exception e){
			System.out.println("Exception is "+ e.getMessage());
			
		}
	}
	
	public String getApplicationBaseUrl() {
		String url=pro.getProperty("baseurl");
		return url;
	}
	public String getUsername() {
		String user=pro.getProperty("username");
		return user;
	}
	public String getPassword() {
		String pass=pro.getProperty("passwd");
		return pass;
	}
	public String getChromePath() {
		String chrome=pro.getProperty("chromePath");
		return chrome;
	}
	public String getFirefoxPath() {
		String firefox=pro.getProperty("firefoxPath");
		return firefox;
	}	
		

}
