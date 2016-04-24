package com.example.ygme;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class Ygm_Sensor extends Activity implements SensorEventListener{
	Sensor acceloremeter;
	SensorManager sm;
	int ctr=0;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.ygm_sensor);
			startService(new Intent(getBaseContext(), Ygm_Service.class));
			sm=(SensorManager) getSystemService(SENSOR_SERVICE);
			acceloremeter=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			sm.registerListener(this, acceloremeter,SensorManager.SENSOR_DELAY_NORMAL);
		/*	if (savedInstanceState == null) {
				getSupportFragmentManager().beginTransaction()
						.add(R.id.container, new PlaceholderFragment()).commit();
			} */
		}
	/*	public static class PlaceholderFragment extends Fragment {

			public PlaceholderFragment() {
			}

			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container,
					Bundle savedInstanceState) {
				View rootView = inflater.inflate(R.layout.ygm_sensor_fragment, container,
						false);
				return rootView;
			}
		}  */
			@Override
	public void onSensorChanged(SensorEvent event) {
				
		// TODO Auto-generated method stub
				if(event.values[0]>5)
				{
					ctr++;
					if(ctr>7)
					{
					//Toast.makeText(getApplicationContext(), (event.values[0]+" "+event.values[1]+" "+event.values[2]+" "), Toast.LENGTH_LONG).show();
				
				gothen();
				
					ctr=0;
					
					}
				}
		
	}

	private void gothen() {
				// TODO Auto-generated method stub
		Toast.makeText(getApplicationContext(), "ho gya!!!!", Toast.LENGTH_LONG).show();
		Intent intloc=new Intent(getApplicationContext(),YGM_location.class);
				startActivity(intloc);
			}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	public void nextpage(View v){
		Intent i = new Intent(this , Contacts.class);
		startActivity(i);
	}

}
