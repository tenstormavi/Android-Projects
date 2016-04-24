package com.example.hp15andapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class StudentData extends Activity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_data);
		tv = (TextView)findViewById(R.id.data);
		
		
		
		ContentResolver cr = getContentResolver();
		/*
		Uri uri = StudentContract.STU_URI; 
		Cursor c = cr.query(uri,null,null,null,null);
		String data="";
		while(c.moveToNext()){
			int ri = StudentContract.getColumnIndex(StudentContract.stu_rollno);
			String r = c.getString(ri);
			int ni = StudentContract.getColumnIndex(StudentContract.stu_name);
			String n = c.getString(ni);
			data = data + (r+" : "+n)+"\n";
		}
		tv.setText(data);
		*/
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		Cursor pbc = cr.query(uri,null,null,null,null);
		String data = "CONTACT NAME : \n";
		while(pbc.moveToNext()){
			int ni = pbc.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String name = pbc.getString(ni);
			data += name+"\n";
		}
		tv.setText(data);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("CONTACT ACCESS");
		builder.setIcon(android.R.drawable.ic_menu_call);
		builder.setMessage("Contact Data Loaded Successfully!!");
		builder.setPositiveButton("OK",null);
		
		AlertDialog dialog = builder.create();
		dialog.show();
	}

	
}
