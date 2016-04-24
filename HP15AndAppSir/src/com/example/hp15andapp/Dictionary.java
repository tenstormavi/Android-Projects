package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Dictionary extends Activity implements OnClickListener 
{

	EditText w, m;
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary);
		w = (EditText)findViewById(R.id.word);
		m = (EditText)findViewById(R.id.meaning);
		b1 = (Button)findViewById(R.id.calldict);
		b1.setOnClickListener(this);
	    SharedPreferences pref;
	    pref = getSharedPreferences("formstatedict",0);
	    String sd1 = pref.getString("wet1","");
	    String sd2 = pref.getString("met1","");
	    w.setText(sd1);
	    m.setText(sd2);
    		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String wtext = w.getText().toString();
		Intent i = new Intent(this,DictionarySupport.class);
		i.putExtra("word",wtext);
		startActivityForResult(i,10);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent rri) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, rri);
		Bundle b = rri.getExtras();
		String meaning = b.getString("rt");
		m.setText(meaning);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		String data1 = w.getText().toString();
		String data2 = m.getText().toString();
		SharedPreferences pref = getSharedPreferences("formstatedict",0);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("wet1",data1);
		editor.putString("met1",data2);
		editor.commit();
	}

	
}
