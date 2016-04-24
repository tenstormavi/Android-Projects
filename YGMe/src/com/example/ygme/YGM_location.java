package com.example.ygme;

import android.app.Activity;
import android.location.LocationListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class YGM_location extends Activity implements GooglePlayServicesClient.ConnectionCallbacks,
GooglePlayServicesClient.OnConnectionFailedListener,
LocationListener{
	private LocationManager lm;
	private String provider;
	String display="";
	Location location ;
	String tower;
	TextView t;
	
	SQLiteDatabase db;
		String str[]=new String[5];
		int flag=0;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_ygm_location);
			
			t = (TextView)findViewById(R.id.tv);
			db = openOrCreateDatabase("ygmdb", Context.MODE_PRIVATE,null);
			lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
			
			Criteria criteria = new Criteria();
			tower = lm.getBestProvider(criteria, false);
			//Toast.makeText(getApplicationContext(), provider+"", Toast.LENGTH_LONG).show();
			
			location = lm.getLastKnownLocation(tower);
			if (location != null) {
				String msg = "Provider " + tower + " has been selected";
				//Toast.makeText(getApplicationContext(), msg , Toast.LENGTH_LONG).show();
				t.setText("Current Location : "+msg);
				onLocationChanged(location);
			} else {
				display="Location nt available";
				Toast.makeText(getApplicationContext(), display, Toast.LENGTH_LONG).show();
				doingsmswork();
			}
		}



	private void doingsmswork() {
			// TODO Auto-generated method stub
			try{
				String q  = "select * from contact";
				Cursor c = db.rawQuery(q, null);
				if(c!= null){
					if (c.moveToFirst()) {
						do {
							//whole data of column is fetched by getColumnIndex()
							
							String p = c.getString(c.getColumnIndex("phone"));
						/*	if (!p.startsWith("+")){
							    p = "+" + p;
							}
							else if(!p.startsWith("+91")){
								p = "+91" + p;
							} */
							str[flag]=p;
							flag++;
							}
						while(c.moveToNext());
						}
				//count the total number of entries
				
				
				
				
				//db1.close();
				//if you close the database then illegal exception will be occurred...
			}
				} catch(Exception e){
	System.out.println(e);
			}
			for(int k=0;k<flag;k++){
			try
			{
				String dang="You Got Me Currently at :- "+display;
				SmsManager smsManager = SmsManager.getDefault(); 
				smsManager.sendTextMessage(str[k], null, dang, null, null);
				//Toast.makeText(getApplicationContext(), str[k],Toast.LENGTH_LONG).show();
				Toast.makeText(getApplicationContext(), "SMS sent....", Toast.LENGTH_LONG).show();
				
			}
			catch(Exception e)
			{
				Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show(); e.printStackTrace();
			}
			}
		}

		



	@Override
	public void onLocationChanged(Location loc) {
		// TODO Auto-generated method stub
		String msgloc = "Updated Location: " +
                Double.toString(loc.getLatitude()) + "\n" +
                Double.toString(loc.getLongitude());
		Toast.makeText(this, msgloc, Toast.LENGTH_SHORT).show();
		Geocoder geo=new Geocoder(getBaseContext(),Locale.getDefault());
		display=" ";
		try
		{
			List<Address> address=geo.getFromLocation(loc.getLatitude(), loc.getLongitude(), 1);
			if(address.size()>0)
			{
				for(int i=0;i<address.get(0).getMaxAddressLineIndex();i++)
				{
				
					display+=address.get(0).getAddressLine(i)+"\n";
				}
				Toast.makeText(this,display, Toast.LENGTH_SHORT).show();
				doingsmswork();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

 public void stopservice(){
	 System.exit(0);
 }
}