package com.example.hp15andapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ToggleWidgetDemo extends Activity implements OnClickListener 
{

	CheckBox c1,c2,c3;
	Button b1;
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_toggle_widget_demo);
		c1 = (CheckBox)findViewById(R.id.tbcb1);
		c2 = (CheckBox)findViewById(R.id.tbcb2);
		c3 = (CheckBox)findViewById(R.id.tbcb3);
		b1 = (Button)findViewById(R.id.tbb1);
		tv1 = (TextView)findViewById(R.id.tbresult);
		
		b1.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String result = "YOUR CHOICE : \n-------------";
		if(c1.isChecked()==true){
			result += "\n"+c1.getText(); 
		}
		if(c2.isChecked()==true){
			result += "\n"+c2.getText(); 
		}
		if(c3.isChecked()==true){
			result += "\n"+c3.getText(); 
		}
		
		tv1.setText(result);
	}

}
