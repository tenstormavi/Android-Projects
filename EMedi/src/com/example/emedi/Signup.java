package com.example.emedi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends Activity {
	
	EditText USER_NAME,USER_PASS,CON_PASS;
	String user_name,user_pass,con_pass;
	Button REG;
	Context ctx = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getActionBar().setTitle("EMedi");
		setContentView(R.layout.activity_signup);
		USER_NAME = (EditText) findViewById(R.id.reg_user);
		USER_PASS = (EditText) findViewById(R.id.reg_pass);
		CON_PASS = (EditText) findViewById(R.id.con_pass);
		REG = (Button) findViewById(R.id.user_reg);
		REG.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		    user_name = USER_NAME.getText().toString();
		    user_pass = USER_PASS.getText().toString();
		    con_pass = CON_PASS.getText().toString();
		    
		    if(!(user_pass.equals(con_pass)))
		    {
		    	Toast.makeText(getBaseContext(), "Passwords are not Matching.", Toast.LENGTH_LONG).show();
		    	USER_PASS.setText("");
		    	CON_PASS.setText("");
		    }
		    else
		    {
		    	DatabaseOperations DB = new DatabaseOperations(ctx);
		    	DB.putInformation(DB, user_name, user_pass);
		    	Toast.makeText(getBaseContext(), "Registration Succesfull!!!", Toast.LENGTH_LONG).show();
		    	finish();
		    }
				
			}
		});
	}
	
	public void LoginPage(View v)
	{
		Intent i = new Intent(this,MainActivity.class);
		startActivity(i);
	}
}
