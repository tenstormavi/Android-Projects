package com.example.ygme;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class First extends Activity {
	Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        b = (Button)findViewById(R.id.ok);
        SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", true);
        if ( firstRun )
        {
        	Intent i = new Intent(this,Second.class);
            startActivityForResult(i, 10);
        }
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	// TODO Auto-generated method stub
    	super.onActivityResult(requestCode, resultCode, data);
    	if (requestCode == 10) 
    	{
            SharedPreferences settings = getSharedPreferences("prefs", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("firstRun", false);
            editor.commit();
        }
    }
    public void okygm(View v){
    	Intent i = new Intent(this, Ygm_Sensor.class);
    	startActivity(i);
    }
}

