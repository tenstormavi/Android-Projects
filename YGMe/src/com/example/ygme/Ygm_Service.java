package com.example.ygme;



import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class Ygm_Service extends Service {
	
	
		@Override
		public int onStartCommand(Intent intent, int flags, int startId){
		 super.onStartCommand(intent, flags, startId);
			 Intent senin=new Intent(this,Ygm_Sensor.class);
			// startService(senin);
			 PendingIntent pendin=PendingIntent.getBroadcast(this,0, senin,PendingIntent.FLAG_UPDATE_CURRENT);
			 Toast.makeText(getApplicationContext(), "Flag update", 1000).show();
			 NotificationCompat.Builder mbuilder=new NotificationCompat.Builder(this)
			 .setSmallIcon(R.drawable.ic_launcher)
			 .setContentTitle("YGM")
			 .setWhen(System.currentTimeMillis())
			 .setContentIntent(pendin)
			 .setContentText("Started");
			 mbuilder.setContentIntent(pendin);
			 NotificationManager nm=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
			 nm.notify(2,mbuilder.build());
			 Toast.makeText(getApplicationContext(), "notification", 1000).show();   
			
			 return Service.START_STICKY;  
		}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void onRebind(Intent intent) {
		// TODO Auto-generated method stub
		super.onRebind(intent);
	}
	@Override
	public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	}
}

