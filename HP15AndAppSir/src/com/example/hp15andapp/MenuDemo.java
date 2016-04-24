package com.example.hp15andapp;

import java.lang.reflect.Field;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuDemo extends Activity {

	Button b1;
	ImageView campic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_demo);
		
		b1 = (Button)findViewById(R.id.mdb1);
		campic = (ImageView)findViewById(R.id.campic);
		registerForContextMenu(b1);
		
		try {
			 ViewConfiguration config = ViewConfiguration.get(this);
			 Field menuKeyField = ViewConfiguration.class.getDeclaredField                      ("sHasPermanentMenuKey");

			 if (menuKeyField != null) {
				 menuKeyField.setAccessible(true);
				 menuKeyField.setBoolean(config, false);
				}
			  }
			catch (Exception e) { }
					
			ActionBar ab = getActionBar();
			ab.setDisplayHomeAsUpEnabled(true);
			ab.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.menu_demo, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if(id==R.id.omi1){
			Intent i = new Intent(this,Setting.class);
			startActivity(i);
		}
		else if(id==R.id.omi2){
		  String cian = MediaStore.ACTION_IMAGE_CAPTURE;
		  Intent ci = new Intent(cian);
		  startActivityForResult(ci,10);
		}
		else if(id==R.id.omi3){
			Toast.makeText(this,"REFRESH CLICKED",1000).show();
		}
		else if(id==R.id.omi4){
			finish();
		}
		else{
			finish();
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater mi = getMenuInflater();
		mi.inflate(R.menu.menu_demo, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if(id==R.id.omi1){
			Intent i = new Intent(this,Setting.class);
			startActivity(i);
		}
		else if(id==R.id.omi2){
			Toast.makeText(this,"CAMERA SELECTED",1000).show();
		}
		else if(id==R.id.omi3){
			Toast.makeText(this,"REFRESH CLICKED",1000).show();
		}
		else if(id==R.id.omi4){
			finish();
		}
		return super.onContextItemSelected(item);
	}
	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Bundle b = data.getExtras();
		campic.setImageBitmap((Bitmap)b.get("data"));
	}
	
	
	
	
	
	
	
	
	
	
	
}
