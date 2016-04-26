package com.example.emedi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class SplashPage extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		//getActionBar().hide();
		getActionBar().setTitle("EMedi");
		setContentView(R.layout.activity_splash_page);
	}
}
