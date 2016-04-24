package com.example.hp15andapp;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MyBroadCast extends Activity implements OnClickListener 
{

	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_broad_cast);
		b1 = (Button)findViewById(R.id.bdb1);
		b2 = (Button)findViewById(R.id.bdb2);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent bi = new Intent();
				bi.putExtra("status","BATTERY LOW");
				bi.putExtra("level","11%");
				bi.setAction("samsung.battery.low");
				sendBroadcast(bi);
			}
		});
		
		b2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent(this,PushMessageScreen.class);
		i.putExtra("subject", "EXAM DATE");
		i.putExtra("detail", "Android batch final exam is decided\n schedule date is 7th July 2015");
		PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
		
		Notification.Builder nb = new Notification.Builder(this);
		nb.setContentTitle("Exam Alert");
		nb.setContentText("Final Exam date is announced");
		nb.setSmallIcon(android.R.drawable.ic_menu_compass);
		nb.setContentIntent(pi);
		
		Notification n = nb.build();
		
		String nsn = Context.NOTIFICATION_SERVICE;
		NotificationManager nm = (NotificationManager)getSystemService(nsn);
		
		n.flags |= Notification.FLAG_AUTO_CANCEL;
		
		nm.notify(0,n);
	}

}











