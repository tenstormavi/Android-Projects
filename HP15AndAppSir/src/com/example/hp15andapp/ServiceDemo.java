package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceDemo extends Activity implements OnClickListener 
{

	Button b1,b2;
	Intent si;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_service_demo);
		b1 = (Button)findViewById(R.id.sdb1);
		b2 = (Button)findViewById(R.id.sdb2);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		si = new Intent(this,MyService.class);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		 case R.id.sdb1:
			 startService(si);
		  break;
		 case R.id.sdb2:
			 stopService(si);
		  break;	 
		}
	}

}
