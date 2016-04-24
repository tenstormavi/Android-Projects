package com.example.hp15andapp;

import android.net.Uri;

public class StudentContract {
	public static final String stu_name = "name";
	public static final String stu_rollno = "rollno";
	
	private static String address = "content://hp.records.student";
	
	public static final Uri STU_URI = Uri.parse(address);
	
	public static int getColumnIndex(String columnName){
		if(columnName.equals("name"))
			return 1;
		else
			return 0;
	} 
}
