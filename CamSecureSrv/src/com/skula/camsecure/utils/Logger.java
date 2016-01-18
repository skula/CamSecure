package com.skula.camsecure.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Logger {
	private Logger(){
	}
	
	public static void log(String level, String text){
		String tmp = "";
		DateFormat shortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		tmp += shortDateFormat.format(new Date());
		tmp+= ": [" + level + "] " + text +"\n";
		try
		{
			//FileWriter fw = new FileWriter(Property.get("LOG_PATH"), true);
			FileWriter fw = new FileWriter("/home/pi/Scripts/PROD/camsecure/log.txt", true);
			BufferedWriter output = new BufferedWriter(fw);
			output.write(tmp);
			output.flush();		
			output.close();
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
}