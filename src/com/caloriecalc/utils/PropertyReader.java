package com.caloriecalc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyReader {
	public static FileInputStream inputStream = null;
	public static Properties prop = null; 
	
	public static String readProperty(String PropertyName) throws IOException{
		String PropertyValue = null;
		String ProjectPath = System.getProperty("user.dir");
		//Pointing to the pysical location of the properties file in read mode
		inputStream = new FileInputStream(ProjectPath +"/src/com/caloriecalc/config/config.properties");
		prop = new Properties();
		//loading the properties is essential to read from the properties file
		prop.load(inputStream);
		PropertyValue = prop.getProperty(PropertyName);
		return PropertyValue;
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println(PropertyReader.readProperty("browser"));
		System.out.println(PropertyReader.readProperty("appurl"));
	}

}