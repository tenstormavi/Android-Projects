package com.example.emedi;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	EditText usrname, pswrd;
	Context CTX = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences settings = getSharedPreferences("prefs", 0);
        boolean firstRun = settings.getBoolean("firstRun", true);
        if ( firstRun )
        {
        	Intent i = new Intent(this,SplashPage.class);
            startActivityForResult(i, 10);
        }
        usrname = (EditText)findViewById(R.id.username);
    	pswrd = (EditText)findViewById(R.id.password);
	}
	
	public void CheckLogin(View v)
	{
		DatabaseOperations DOP = new DatabaseOperations(CTX);
		Cursor CR = DOP.getInformation(DOP);
		CR.moveToFirst();
		boolean loginstatus = false;
		String NAME = "";
		do
		{
			if((usrname.getText().toString()).equals(CR.getString(0)) && (pswrd.getText().toString()).equals(CR.getString(1)))
			{
				loginstatus = true;
				NAME = CR.getString(0);
			}
		}while(CR.moveToNext());
		if(loginstatus)
		{
			Toast.makeText(this, "Login Successfull!!!", Toast.LENGTH_SHORT).show();
			Intent i = new Intent(this,ListOptions.class);
			startActivity(i);
		}
		else
		{
			Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
		}
	}
	
	public void SignUp(View V)
	{
		Intent i = new Intent(this,Signup.class);
		startActivity(i);
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
}
