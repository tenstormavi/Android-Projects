package com.example.hp15andapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class SensorDemo extends Activity implements SensorEventListener 
{

	RelativeLayout screen;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sensor_demo);
		
		screen = (RelativeLayout)findViewById(R.id.sensorscreen);
		
		String sn = Context.SENSOR_SERVICE;
		SensorManager sm = (SensorManager)getSystemService(sn);
		
		Sensor cs = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		
		sm.registerListener(this,cs,SensorManager.SENSOR_DELAY_NORMAL);
		
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
	
		float range = event.values[0];
		
		if(range==0)
		 screen.setBackgroundResource(R.drawable.bg1);
		else
		 screen.setBackgroundResource(R.drawable.doggy);	
		
		
	}
	
	
	
	
	
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

}
