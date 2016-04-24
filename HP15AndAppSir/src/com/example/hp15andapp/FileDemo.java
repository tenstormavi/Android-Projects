package com.example.hp15andapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FileDemo extends Activity implements OnClickListener 
{

	EditText et;
	Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_demo);
		et = (EditText)findViewById(R.id.fdet);
		b1 = (Button)findViewById(R.id.fdb1);
		b2 = (Button)findViewById(R.id.fdb2);
		
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		File sdcard = Environment.getExternalStorageDirectory();
		File fobj = new File(sdcard,"data1.txt");
		if(v.getId()==R.id.fdb1){
			//READ
			try{
			FileInputStream fis = new FileInputStream(fobj);
			String data = "";
			while(true){
				int c = fis.read();
				if(c==-1) break;
				
				data = data+(char)c;
			}
			 et.setText(data);
			}catch(Exception e){
				
			}
		}
		else{
			//SAVE
			try{
				FileOutputStream fos = new FileOutputStream(fobj);
				String data = et.getText().toString();
				byte[] fragData = data.getBytes();
				fos.write(fragData);
				}catch(Exception e){
					
				}
		}
	}

	
}
