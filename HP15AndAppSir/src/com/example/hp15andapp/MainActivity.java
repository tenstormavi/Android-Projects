package com.example.hp15andapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener 
{
    TextView tv1; 
	Button b1,b2,b3,b4;
	int c=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.fatv1);
        b1 = (Button)findViewById(R.id.fab1);
        b2 = (Button)findViewById(R.id.fab2);
        b3 = (Button)findViewById(R.id.fab3);
        b4 = (Button)findViewById(R.id.fab4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        Toast.makeText(this,"WELCOME",Toast.LENGTH_SHORT).show();
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.fab1:
			c++;
			break;
		case R.id.fab2:
			c--;
			if(c==-1){
				String msg = "NEGATIVE COUNTER STARTED.";
		        int duration = Toast.LENGTH_SHORT;
		        Toast t = Toast.makeText(this, msg, duration);
		        t.show();
			}
			break;
		case R.id.fab3:
			c = 0;
			break;
		case R.id.fab4:
			//Intent i  = new Intent("hp.app.SECOND");
			try{
			  String acn = "ALCDemo";
			  Class c = Class.forName("com.example.hp15andapp."+acn);
			  Intent i = new Intent(this,c);
			  startActivity(i);
			 }catch(Exception e){
			 Toast.makeText(this,"NO ACTIVITY",1000).show();	
			}
		}
		
		String opmsg = "COUNTER : "+c;
		tv1.setText(opmsg);
	}
    
	
    
  
}
