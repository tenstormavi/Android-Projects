package com.example.hp15andapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class SeekBarDemo extends Activity implements OnSeekBarChangeListener 
{

	TextView status;
	SeekBar sb;
	Thread sbchanger;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar_demo);
		status = (TextView)findViewById(R.id.sbdstatus);
		sb = (SeekBar)findViewById(R.id.sbdsb1);
		sb.setMax(100);
		
		sb.setOnSeekBarChangeListener(this);
		
		sbchanger = new Thread(){
			public void run(){
				for(int i=0; i<=100; i++){
					sb.setProgress(i);
					try{
						sleep(250);
					}catch(Exception e){}
				}
			}
		};
		sbchanger.start();
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		String s = "SB PROGRESS : "+progress;
		status.setText(s);
		
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"START SEEK", 1000).show();
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		Toast.makeText(this,"END SEEK", 1000).show();
		
	}

	
}
