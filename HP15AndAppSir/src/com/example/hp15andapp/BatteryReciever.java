package com.example.hp15andapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BatteryReciever extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Bundle b = intent.getExtras();
		String info = b.getString(BatteryManager.BATTERY_INFO);
		String per = b.getString(BatteryManager.BATTERY_PERCENTAGE);
		
		String display = "BATTERY REPORT : \n-------------";
		display += "\nBATTERY INFO       : "+info;
		display += "\nBATTERY PERCENTAGE : "+per;
		
		
		Toast.makeText(context,display,Toast.LENGTH_LONG).show();
	}

}
