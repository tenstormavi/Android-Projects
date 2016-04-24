package com.example.hp15andapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class ScreenBG extends Activity implements OnClickListener 
{

	RadioGroup rg;
	RadioButton r1,r2,r3,r4;
	Button b1,b2;
	RelativeLayout screen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_bg);
		rg = (RadioGroup)findViewById(R.id.sbgrg);
		r1 = (RadioButton)findViewById(R.id.sbgr1);
		r2 = (RadioButton)findViewById(R.id.sbgr2);
		r3 = (RadioButton)findViewById(R.id.sbgr3);
		r4 = (RadioButton)findViewById(R.id.sbgr4);
		
		screen = (RelativeLayout)findViewById(R.id.myscreen);
		
		b1 = (Button)findViewById(R.id.sbgb1);
		b2 = (Button)findViewById(R.id.sbgb2);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.sbgb1){
			if(r1.isChecked())
				screen.setBackgroundColor(Color.RED);
			else if(r2.isChecked())
				screen.setBackgroundColor(Color.CYAN);
			else if(r3.isChecked())
				screen.setBackgroundColor(Color.GRAY);
			else if(r4.isChecked())
				screen.setBackgroundColor(Color.GREEN);
		}else{
			rg.clearCheck();
			screen.setBackgroundColor(Color.WHITE);
		}
	}

}
