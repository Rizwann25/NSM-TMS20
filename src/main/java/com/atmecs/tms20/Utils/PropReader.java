package com.atmecs.tms20.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropReader {

		Properties prop;
		public PropReader(String filepath)
		{
		prop=new Properties();

		try {
		prop.load(new FileInputStream(new File(filepath)));
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		}
		}
		public String get(String key)
		{
		return prop.getProperty(key);
		}


		public void set(String key , String value, String filepath)
		{
		prop.setProperty(key , value);
		try {
		             prop.store(new FileOutputStream(new File(filepath)), null);
		         } catch (IOException ex) {
		            System.out.println(ex);
		         }
		}

}
