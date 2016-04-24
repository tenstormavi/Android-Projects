package com.example.hp15andapp;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainMenu extends ListActivity {

	String[] mi = {"StudentData","DeviceMenu","MyBroadCast","MainActivity","FileDemo","ALCDemo","Second","Quiz","ServiceDemo","MusicPlayer","IntentMenu","WidgetMenu","LayoutMenu","Setting","EXIT"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
		ArrayAdapter<String> ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mi);
		setListAdapter(ad);
		
        SharedPreferences setting;
        setting = PreferenceManager.getDefaultSharedPreferences(this);
        boolean wts = setting.getBoolean("welcomechoice", true);
        if(wts==true){
		 String wt = "WELCOME TO HPES";
		 Toast.makeText(this,wt,1000).show();
        }
		
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
