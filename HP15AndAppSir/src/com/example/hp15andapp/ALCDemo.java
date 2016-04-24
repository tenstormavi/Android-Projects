package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ALCDemo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alcdemo);
		Toast.makeText(this,"ON-CREATE CALLED",1000).show();
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Toast.makeText(this,"ON-START CALLED",1000).show();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(this,"ON-RESUME CALLED",1000).show();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(this,"ON-STOP CALLED",1000).show();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(this,"ON-PAUSE CALLED",1000).show();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this,"ON-DESTROY CALLED",1000).show();
	}
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Toast.makeText(this,"ON-RESTART CALLED",1000).show();
	}
	
	
	
	
	public void open(View v){
		Intent i = new Intent(this,Second.class);
		startActivity(i);
	}

}
