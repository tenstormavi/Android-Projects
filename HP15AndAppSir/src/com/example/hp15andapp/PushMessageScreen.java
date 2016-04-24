package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PushMessageScreen extends Activity {

	TextView tv1, tv2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_push_message_screen);
		tv1 = (TextView)findViewById(R.id.pmsubject);
		tv2 = (TextView)findViewById(R.id.pmcontent);
		
		Intent i = getIntent();
		Bundle data = i.getExtras();
		String s = data.getString("subject");
		String d = data.getString("detail");
		
		tv1.setText("SUBJECT : "+s);
		tv2.setText("MESSAGE : \n"+d);
	}

}
