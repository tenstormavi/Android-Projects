package com.example.hp15andapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class ACDemo extends Activity {

	String [] acdata = {"Antartica","Austria","Australia","Bay Of Bengal","Bangladesh","India","Indonasia","Ireland","Srilanka","Sweden","Bhutan","New Zealand","Nepal"};
	AutoCompleteTextView actv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_acdemo);
		actv = (AutoCompleteTextView)findViewById(R.id.acdactv);
		ArrayAdapter<String> ad;
		ad = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,acdata);
		actv.setAdapter(ad);
	}

	
}
