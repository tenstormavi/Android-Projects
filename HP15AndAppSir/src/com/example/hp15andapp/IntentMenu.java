package com.example.hp15andapp;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class IntentMenu extends ListActivity {

	String[] mi = {"Quiz","Dictionary","PHONEBOOK","PHONE DIALER","MESSENGER","WEB BROWSER","HPES INDIA","MAP","EXIT"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ArrayAdapter<String> ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mi);
		setListAdapter(ad);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String ci  = mi[position];
		if(ci.equals("EXIT")){
			finish();
		}
		else if(ci.equals("PHONE DIALER")){
			String pn = "09128435221";
			Uri uri = Uri.parse("tel:"+pn); 
			Intent ds = new Intent(Intent.ACTION_DIAL,uri);
			startActivity(ds);
		}
		else if(ci.equals("PHONEBOOK")){
			Uri uri = Uri.parse("content://contacts/people/");
			Intent pb = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(pb);
		}
		else if(ci.equals("MESSENGER")){
			Uri uri = Uri.parse("sms:9977442211"); 
			String msg = "This is demo text for tesing sms app from Android developers at HP";
			Intent ms = new Intent(Intent.ACTION_SENDTO,uri);
			ms.putExtra("sms_body",msg);
			startActivity(ms);
		}
		else if(ci.equals("WEB BROWSER")){
			Uri uri = Uri.parse("http://"); 
			Intent ds = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(ds);
		}
		else if(ci.equals("HPES INDIA")){
			Uri uri = Uri.parse("http://www.hpesindia.com"); 
			Intent ds = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(ds);
		}
		else if(ci.equals("MAP")){
			Uri uri = Uri.parse("google.navigation:q=New+York+NY"); 
			Intent map = new Intent(Intent.ACTION_VIEW,uri);
			startActivity(map);
		}
		else{
			try{
				 Class c = Class.forName("com.example.hp15andapp."+ci);
				  Intent i = new Intent(this,c);
				  startActivity(i);
				 }catch(Exception e){
				 Toast.makeText(this,"NO ACTIVITY",1000).show();	
				}
		}
	}

	
}
