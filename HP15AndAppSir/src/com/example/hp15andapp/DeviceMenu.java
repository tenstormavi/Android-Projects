package com.example.hp15andapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class DeviceMenu extends ListActivity {

	String[] mi = {"MenuDemo","WifiDemo","BlueToothDemo","SensorDemo","ProximityDemo","AnimationDemo","EXIT"};
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
