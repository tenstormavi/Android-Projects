package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DictionarySupport extends Activity {

	String [][] wms  = {{"Dog","A animal"},{"Android","Robot like human"},{"Java","Programmin Language"},{"Mango","A fruit"},{"Car","A vehicle"}};
	String responseText="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dictionary_support);
		Intent ri = getIntent();
		Bundle b = ri.getExtras();
		String word = b.getString("word");
		for(int i=0;i<wms.length;i++){
			if(wms[i][0].equals(word)){
				responseText=wms[i][1];
			}
		}
		if(responseText.equals("")){
			
		}
		else{
			
			finish();
		}
	}

	public void back(View v){
		finish();
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.putExtra("rt",responseText);
		setResult(RESULT_OK,i);
		super.finish();
	}
	
}
