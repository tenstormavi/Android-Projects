package com.example.hp15andapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class ProgressBarDemo extends Activity {

	ProgressBar pb;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_progress_bar_demo);
		pb = (ProgressBar)findViewById(R.id.pb1);
		pb.setMax(100);
		
		Thread t = new Thread(){
			public void run(){
				for(int i=0;i<=100;i=i+5)
				{
					try{
						pb.setProgress(i);
						sleep(600);
					}catch(Exception e){}
					
				}
			}
		};
		t.start();
		
	}

}
