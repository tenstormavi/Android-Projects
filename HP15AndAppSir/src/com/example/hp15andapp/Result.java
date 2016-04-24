package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Result extends Activity {

	TextView mm, mo, gr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		mm = (TextView)findViewById(R.id.ratq);
		mo = (TextView)findViewById(R.id.ramo);
		gr = (TextView)findViewById(R.id.ragrade);
		
		Intent ri = getIntent();
		Bundle data = ri.getExtras();
		int rmm = data.getInt("mm");
		int rmo = data.getInt("mo");
		String rgr = data.getString("grade");
		
		String dmm = "TOTAL QUESTION : "+rmm;
		String dmo = "MARKS OBTAINED : "+rmo;
		
		mm.setText(dmm);
		mo.setText(dmo);
		gr.setText(rgr);
				
	}

	
}
